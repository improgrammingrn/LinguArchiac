package com.example.linguarchiac
class RagEngine(
    private val stories:List<Story>
){
    fun search(query:String):List<Story> {
        val searchTerms = query
            .lowercase()
            .split(" ")
            .filter { it.isNotBlank() }

        return stories
            .map { story ->
                var score = 0
                for (term in searchTerms) {
                    if (
                        story.themes.any {
                            it.lowercase().contains(term)

                        }
                    ) {
                        score += 3
                    }
                    if (story.title.lowercase().contains(term)) {
                        score += 2
                    }
                    if (story.context.lowercase().contains(term)) {
                        score += 1
                    }
                    if (story.text.lowercase().contains(term)) {
                        score += 1
                    }
                }
                story to score
            }
            .filter { (_, score) ->
                score > 0
            }
            .sortedByDescending { (_, score) ->
                score
            }
            .map { (story, _) ->
                story
            }
        }

        fun findRelevantPassage(
            query: String,
            story: Story,
            maxSentences:Int=3
        ): String{
            val sentences=story.text
                .split(Regex("(?<=[.!?])\\s+"))
                .filter{it.isNotBlank()}
            val searchTerms=query
                .lowercase()
                .split(" ")
            val scoredSentences=sentences.map{ sentence ->
                var score=0
                val lowerSentence=sentence.lowercase()

                for (term in searchTerms){
                    if(lowerSentence.contains(term)){
                        score++
                    }
                }
                sentence to score
            }
            if (scoredSentences.isEmpty()) {
                return ""
            }
            val bestIndex=scoredSentences
                .indices
                .maxByOrNull { scoredSentences[it].second }!!

            val start=maxOf(0, bestIndex-1)
            val end=minOf(
                sentences.size,
                bestIndex+maxSentences
            )
            return sentences
                .subList(start,end)
                .joinToString(" ")
        }
    }
