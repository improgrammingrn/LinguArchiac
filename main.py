import re
import json
from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity


with open("stories.json", "r", encoding="utf-8") as file:
    stories = json.load(file)

print(f"Stories loaded: {len(stories)}")

model = SentenceTransformer("all-MiniLM-L6-v2")

print("AI model loaded!")

story_texts = []

for story in stories:
    text = (
        story["title"]
        + " "
        + " ".join(story["themes"])
        + " "
        + story["context"]
        + " "
        + story["text"]
    )

    story_texts.append(text)

story_embeddings = model.encode(
    story_texts,
    normalize_embeddings=True
)

def find_relevant_passage(query, story_text, max_sentences=3):
    sentences = re.split(r'(?<=[.!?])\s+',story_text)

    query_embedding=model.encode(
    [query],
    normalize_embeddings=True
    )
    sentence_embeddings=model.encode(
    sentences,
    normalize_embeddings=True)

    similarities=cosine_similarity(
    query_embedding,
    sentence_embeddings) [0]
    best_index=similarities.argmax()
    start=max(0,best_index-1)
    end=min(len(sentences), best_index+max_sentences)

    passage=" ".join(sentences[start:end])
    return passage


print("Story embeddings created!")


def search_stories(query, top_k=3):
    query_embedding=model.encode(
    [query],
    normalize_embeddings=True
    )

    similarities=cosine_similarity(
    query_embedding,
    story_embeddings
    )[0]

    ranked_indices=similarities.argsort()[::-1]
    results=[]
    for index in ranked_indices[:top_k]:
        results.append({
            "title":stories[index]["title"],
            "language":stories[index]["language"],
            "similarity":float(similarities[index]),
            "text":stories[index]["text"],
            "context":stories[index]["context"]
        })
    return results

query=input("What are you looking for?")
results=search_stories(query)
print("Best matches:")

for result in results:
    print(
    f"{result['title']}"
    f"({result['language']})-"
    f"score:{result['similarity']:.3f}"
)
print("\nRelevant Passage:")
passage=find_relevant_passage(
query,
results[0]["text"])
print(passage)
