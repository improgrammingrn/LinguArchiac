package com.example.linguarchiac
//imports
import androidx.compose.material3.Card
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Box
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import android.media.MediaPlayer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.DisposableEffect
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.shadow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.foundation.clickable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import com.example.linguarchiac.ui.theme.LinguArchiacTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.navigation.NavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextOverflow

//linked
class MainActivity : ComponentActivity() {
    private var deepLinkUri:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        deepLinkUri=intent?.data

        enableEdgeToEdge()
        val ragEngine = RagEngine(archivestories)
        val results = ragEngine.search("spiritual")
        setContent {

            LinguArchiacTheme {

                val navController = rememberNavController()
                LaunchedEffect(Unit) {
                    if(deepLinkUri?.scheme=="linguarchiac"&&
                        deepLinkUri?.host=="submissionthanks")
                    {
                        navController.navigate("submissionthanks")
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = "welcome"
                ) {

                    composable("welcome") {

                        WelcomeScreen(navController)

                    }
                    composable("language") {
                        HomePage(navController)
                    }

                    composable("toto") {
                        TotoScreen(navController)
                    }
                    composable("ainu") {
                        AinuScreen(navController)
                    }
                    composable("ainuarchive") {
                        AinuArchive(navController)
                    }
                    composable("ragtest") {
                        RagTestScreen(
                            navController = navController
                        )
                    }
                    composable("totoarchive") {
                        TotoArchive(navController)
                    }
                    composable("myaamia") {
                        MyaamiaScreen(navController)
                    }
                    composable("myaamiaarchive") {
                        MyaamiaArchive(navController)
                    }

                    composable("story1") {
                        StoryScreen(
                            navController = navController,
                            title = "Pananpe Escapes from Demon’s Hands",
                            description = "Deception fools no one. Explore this idea through the short "+
                            "folktale about what goes around, comes around.",
                            image = R.drawable.ainu,
                            engText = StoryText.story1English,
                            ogText = StoryText.story1Japanese,
                            audio = R.raw.ainu_story_1

                        )
                    }
                    composable("story2") {
                        StoryScreen(
                            navController = navController,
                            title = "The Singing Cuckoo and The Thunder God",
                            description = "We often love one another, but never the nature around us."+
                            " In this short folktale, you will explore how connections between humans" +
                            " and nature is incredibly important, and must be present for a healthy livelihood.",
                            image = R.drawable.ainu_story_2,
                            engText = StoryText.story2English,
                            ogText = StoryText.story2Japanese,
                            audio = R.raw.ainu_story_2

                        )
                    }
                    composable("story3") {
                        StoryScreen(
                            navController = navController,
                            title = "The Girl in the Snow",
                            description = "Bravery combats all issues. Even when a big bear comes"+
                            " and disrupts the entire community. This story showcases the importance"+
                            " of resilience and bravery through a communal setting.",
                            image = R.drawable.ainu_bear,
                            engText = StoryText.story3English,
                            ogText = StoryText.story3Japanese,
                            audio = R.raw.ainu_story_3

                        )
                    }

                    composable("story4") {
                        StoryScreen(
                            navController = navController,
                            title = "White Clew & Black Clew",
                            description = "Consequences are something no one likes. Through melodious "+
                            "refrains, you can understand why morality is important."+" Ethics are valued"
                            +" heavily in the Ainu culture, and through this story you can take a glimpse"+
                            " at how it has been embedded in the culture for centuries.",
                            image = R.drawable.ainustory3,
                            engText = StoryText.story4English,
                            ogText = StoryText.story4Japanese,
                            audio = R.raw.ainu_story_4
                        )
                    }
                    composable("totostory1") {
                        BengaliStoryScreen(
                            navController = navController,
                            title = "Love Your Enemies",
                            description = "Enemies are associated with the word hate. In this Christian"+
                            " teaching you will learn why enemies should be associated with an antonym, love.",
                            image = R.drawable.loveyourenemy,
                            engText = StoryText.story1english,
                            ogText = StoryText.story1Bengali,
                            audio = R.raw.totostory1
                        )
                    }
                    composable("totostory2") {
                        BengaliStoryScreen(
                            navController = navController,
                            title = "Moses's Laws",
                            description = "Laws are ideas we must adhere to."+
                                    " But why? In this short teaching you can understand Moses's Laws"+
                            " and why they were created.",
                            image = R.drawable.lawsofgod,
                            engText = StoryText.story2english,
                            ogText = StoryText.story2Bengali,
                            audio = R.raw.totostory2
                        )
                    }
                    composable("totostory3") {
                        BengaliStoryScreen(
                            navController = navController,
                            title = "The Prodigal Son",
                            description = "A father's love can't be described through words. Yet it has"+
                            " been in this short Bible teaching. After his son betrays him, his father"+
                            " still welcomes him with open arms." +
                            " Why? Read more to find out.",
                            image = R.drawable.forgiveness,
                            engText = StoryText.story3english,
                            ogText = StoryText.story3Bengali,
                            audio = R.raw.totostory3
                        )
                    }
                    composable("myaamiastory1") {
                        MyaamiaStoryScreen(
                            navController = navController,
                            title = "Emergence of the Myaamia",
                            description = "This story is about how the Myaamian tribe had first come"+
                            " to North America. They had sailed, and faced a journey only one can describe."
                            +" Read more to find out how they settled, and adjusted to life in America.",
                            image = R.drawable.myaamia,
                            engText = StoryText.story1eng,
                            ogText = StoryText.story1Myaamia
                        )
                    }
                    composable("community") {
                        CommunityScreen(navController)
                    }
                    composable("submitstory") {
                        SubmitStoryScreen(navController)
                    }
                    composable("submissionthanks") {
                        SubmissionThanksScreen(navController)
                    }

                }

            }

        }
    }

    @Composable
    fun CommunityScreen(
        navController: NavController
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.map_bg),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                alpha = 0.35f,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x99E2DACB))
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Bar(navController)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = 28.dp,
                            end = 28.dp,
                            top = 45.dp,
                            bottom = 40.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Community",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5A4635)
                    )

                    Spacer(
                        modifier = Modifier.height(40.dp)
                    )
                    Text(
                        text = "Share your story in a language you wish to preserve.",
                        fontSize = 18.sp,
                        color = Color(0xFF5A4635),
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(60.dp)
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE0D5C4)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Share a story",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5A4635)
                            )
                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )
                            Text(
                                text = "One story at a time, tell us a story you would be incomplete without.",
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                color = Color(0xFF6B5745),
                                textAlign = TextAlign.Center
                            )
                            Spacer(
                                modifier = Modifier.height(40.dp)
                            )
                            Button(
                                onClick = {
                                    navController.navigate("submitstory")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF8A6A45)
                                )
                            ) {
                                Text(
                                    text = "+ Share a story",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(80.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        CommunityStep(
                            number = "1",
                            title = "Share",
                            description = "Tell your story"
                        )
                        CommunityStep(
                            number = "2",
                            title = "Approved",
                            description = "Approves integrity"
                        )
                        CommunityStep(
                            number = "3",
                            title = "Archived",
                            description = "Posted on the archive"
                        )
                    }
                        }
                    }


                }
            }

    @Composable
    fun SubmissionThanksScreen(
        navController: NavController
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.map_bg),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                alpha = 0.35f,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x99E2DACB))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Thank you!",
                    fontSize = 47.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Text(
                    text = "We really appreciate your voice. ",
                    fontSize = 18.sp,
                    lineHeight = 21.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF6B5745)
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Text(
                    text = "Every story keeps a language thriving.",
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF6B5745),
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier.height(48.dp)
                )
                Button(
                    onClick = {
                        navController.navigate("welcome")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8A6A45)
                    )
                ) {
                    Text(
                        text = "Back to Home",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

    @Composable
    fun CommunityStep(
        number: String,
        title: String,
        description: String
    ) {
        Column(
            modifier = Modifier.width(95.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        color = Color(0xFF8A6A45),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = description,
                fontSize = 15.sp,
                lineHeight = 15.sp,
                color = Color(0xFF6B5745),
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun SubmitStoryScreen(
        navController: NavController
    ) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {

                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true

                    webViewClient = object : WebViewClient() {

                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {

                            val url = request?.url?.toString() ?: ""

                            if (url.contains("submissionthanks")) {
                                navController.navigate("submissionthanks")
                                return true
                            }

                            return false
                        }
                    }

                    loadUrl(
                        "https://form.jotform.com/samadritabha786/linguarchiac-story-submission"
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }

    //first screen
    @Composable
    fun WelcomeScreen(navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.map_bg),
                contentDescription = "map background",
                contentScale = ContentScale.Crop,
                alpha = 0.35F,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x99E2DACB))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 28.dp,
                        end = 28.dp,
                        top = 56.dp,
                        bottom = 32.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier.height(200.dp)
                )

                Text(
                    text = "LinguArchiac",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(
                    modifier = Modifier.height(60.dp)
                )
                SpeechBubble()
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Text(
                    text = "Saving one mother tongue, one story at a time.",
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        navController.navigate("language")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8A6A45)
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Text(
                        text = "Begin your journey →"
                    )
                }


            }
        }
    }

    //the screen where we have the ai, map, etc.
    @Composable
    fun HomePage(
        navController: NavController
    ) {
        var searchQuery by remember {
            mutableStateOf("")
        }
        val ragEngine = remember {
            RagEngine(archivestories)
        }
        var searchResults by remember {
            mutableStateOf(emptyList<Story>())
        }
        var relevantPassages by remember {
            mutableStateOf(emptyMap<String, String>())
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(R.drawable.map_bg),
                contentDescription = "map background",
                contentScale = ContentScale.Crop,
                alpha = 0.35f,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x99E2DACB))
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Bar(navController)

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            start = 28.dp,
                            end = 28.dp,
                            top = 45.dp,
                            bottom = 40.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Language Engine",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5A4635),
                        textAlign = TextAlign.Center
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Powered by exploration.",
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF5A4635)
                    )

                    Spacer(
                        modifier = Modifier.height(30.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "3",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5A4635)
                            )
                            Text(
                                text = "Languages",
                                fontSize = 14.sp,
                                color = Color(0xFF6B5745)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "8",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5A4635)
                            )
                            Text(
                                text = "Stories",
                                fontSize = 14.sp,
                                color = Color(0xFF6B5745)
                            )

                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "7",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5A4635)
                            )
                            Text(
                                text = "Recordings",
                                fontSize = 14.sp,
                                color = Color(0xFF6B5745)
                            )
                        }
                        Spacer(
                            modifier = Modifier.height(80.dp)
                        )
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE0D5C4)
                        ),
                        border = BorderStroke(
                            1.dp,
                            Color(0xFFB8A48A)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = "Ask the engine.",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF5A4635)
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )
                            Text(
                                text = "Explore stories in our supported languages.",
                                fontSize = 15.sp,
                                lineHeight = 20.sp,
                                color = Color(0xFF6B5745)
                            )
                            Spacer(
                                modifier = Modifier.height(18.dp)
                            )
                            if (searchResults.isNotEmpty()) {
                                Spacer(
                                    modifier = Modifier.height(20.dp)
                                )
                                Text(
                                    text = "Stories found",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF5A4635)
                                )
                                Spacer(
                                    modifier = Modifier.height(12.dp)
                                )
                                searchResults.forEach { story ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(bottom = 12.dp),
                                        shape = RoundedCornerShape(18.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFE0D5C4)
                                        ),
                                        border = BorderStroke(
                                            1.dp,
                                            Color(0xFFB8A48A)
                                        ),
                                        elevation = CardDefaults.cardElevation(
                                            defaultElevation = 4.dp
                                        )
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp)
                                        ) {
                                            Text(
                                                text = story.title,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF5A4635)
                                            )
                                            Spacer(
                                                modifier = Modifier.height(5.dp)
                                            )
                                            Text(
                                                text = "${story.language}·${story.region}",
                                                fontSize = 12.sp,
                                                color = Color(0xFF6B5745)
                                            )
                                            Text(
                                                text = story.context,
                                                fontSize = 14.sp,
                                                lineHeight = 21.sp,
                                                color = Color(0xFF5A4635)
                                            )
                                            Spacer(
                                                modifier = Modifier.height(10.dp)
                                            )
                                            Text(
                                                text = relevantPassages[story.title] ?: "",
                                                fontSize = 14.sp,
                                                lineHeight = 21.sp,
                                                fontStyle = FontStyle.Italic,
                                                color = Color(0xFF6B5745)
                                            )
                                            Text(
                                                text = "View story →",
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF8A6A45)
                                            )
                                        }

                                    }
                                }
                            }else if (searchQuery.isNotBlank()){
                                Spacer(
                                    modifier=Modifier.height(20.dp)
                                )
                                Text(
                                    text="No stories found.",
                                    fontSize=20.sp,
                                    color=Color(0xFF5A4635),
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(
                                    modifier=Modifier.height(20.dp)
                                )
                                Text(
                                    text="Try searching for another story type, or theme.",
                                    fontSize = 15.sp,
                                    color=Color(0xFF6B5745)
                                )
                            }

                            Text(
                                text = "Pro-tip: Search a theme, story type, a supported language name, or genre. Eg. 'God', 'Ainu', 'folkatale', etc.",
                                fontSize = 14.sp,
                                color = Color(0xFF6B5745)
                            )
                            OutlinedTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                placeholder = {
                                    Text("Start by typing here: " )
                                },
                                singleLine = true,
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.fillMaxWidth(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color(0xFF8A6A45),
                                    unfocusedBorderColor = Color(0xFFB8A48A),
                                    focusedContainerColor = Color(0xFFF0E8DB),
                                    unfocusedContainerColor = Color(0xFFF0E8DB)
                                )
                            )
                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )
                            Button(
                                onClick = {
                                    searchResults = ragEngine.search(searchQuery)

                                    relevantPassages = searchResults.associate { story ->
                                        story.title to ragEngine.findRelevantPassage(
                                            searchQuery,
                                            story
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF8A6A45)
                                )
                            ) {
                                Text(
                                    "SEARCH ARCHIVE",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(
                                modifier = Modifier.height(10.dp)
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(30.dp)
                    )
                    Button(
                        onClick = {
                            navController.navigate("community")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8A6A45)
                        )
                    ) {
                        Text(
                            text = "Share your story",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = "Archive Map",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF5A4635)
                    )
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp)
                            .height(300.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE0D5C4)
                        ),
                        border = BorderStroke(
                            1.dp,
                            Color(0xFFB8A48A)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(R.drawable.globe),
                                contentDescription = "Archive Map",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .offset(
                                        x = 86.dp,
                                        y = -5.dp
                                    )
                                    .clickable {
                                        navController.navigate("toto")
                                    }
                                    .background(
                                        color=Color(0xFFE0D5C4),
                                        shape= RoundedCornerShape(8.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical=4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "\uD83D\uDCCD Toto",
                                    fontSize = 15.sp,
                                    color=Color(0xFF5A4635),
                                    maxLines = 1
                                )

                            }
                            Spacer(
                                modifier = Modifier.height(20.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .offset(
                                        x = -130.dp,
                                        y = -30.dp
                                    )
                                    .clickable {
                                        navController.navigate("myaamia")
                                    }
                                    .background(
                                        color=Color(0xFFE0D5C4),
                                        shape= RoundedCornerShape(8.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical=4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "\uD83D\uDCCD Myaamia",
                                    fontSize = 15.sp,
                                    color=Color(0xFF5A4635),
                                    maxLines = 1
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .offset(
                                        x = 149.dp,
                                        y = -35.dp
                                    )
                                    .clickable {
                                        navController.navigate("ainu")
                                    }
                                    .background(
                                        color=Color(0xFFE0D5C4),
                                        shape= RoundedCornerShape(8.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical=4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "\uD83D\uDCCD Ainu",
                                    fontSize = 15.sp,
                                    color=Color(0xFF5A4635),
                                    maxLines = 1
                                )
                            }


                        }

                    }
                }
            }
        }
    }
}

//ai finder
@Composable
fun RagTestScreen(
    navController: NavController
) {
    val ragEngine = RagEngine(archivestories)
    val results = ragEngine.search("spiritual")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "RAG TEST",
            fontSize = 28.sp
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        results.forEach { story ->
            Text(
                text = story.title,
                fontSize = 28.sp
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }
    }
}

@Composable
fun LangScreen(
    navController: NavController,
    languageName: String,
    tagline: String,
    voices: String,
    homelandTitle: String,
    homelandSubtitle: String,
    scriptYear: String,
    scriptTitle: String,
    originDescription:String,
    notableWorks:String,
    scriptSubtitle: String,
    regionDescription: String,
    rootsDescription: String,
    endangeredDescription: String,
    archiveRoute: String
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )
        Bar(navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier=Modifier.height(120.dp))
            Text(
                text = languageName,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )


            Text(
                text = tagline,
                fontSize = 18.sp,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center
            )


            Spacer(
                modifier = Modifier.height(30.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                StatCard(
                    number = voices,
                    title = "voices",
                    subtitle = "now"
                )


                StatCard(
                    number = homelandTitle,
                    title = "homeland",
                    subtitle = "keeps $languageName alive"
                )


                StatCard(
                    number = scriptYear,
                    title = "$languageName's script",
                    subtitle = scriptSubtitle
                )

            }


            Spacer(
                modifier = Modifier.height(35.dp)
            )


            ExpandableCard(
                title = "📍 Region",
                description = regionDescription
            )


            ExpandableCard(
                title = "💬 Origin of $languageName",
                description = originDescription
            )


            ExpandableCard(
                title = "⚠️ Why is it endangered?",
                description = endangeredDescription
            )
            ExpandableCard(
                title = "\uD83D\uDCD6 Notable Works",
                description = notableWorks
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End){
                Button(
                onClick = {
                    navController.navigate(archiveRoute)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8A6A45)
                )
            ) {
                Text(
                    text = "Explore the Archive →"
                )

                }}
        }
    }
}

@Composable
fun TotoScreen(
    navController: NavController
) {
    LangScreen(
        navController = navController,
        languageName = "Toto",
        tagline = "A language more endangered than its tribe.",
        voices = "~1600",
        homelandTitle = "1",
        homelandSubtitle = "homeland",
        scriptYear = "2015",
        scriptTitle = "Toto's script",
        originDescription = "Toto is a small Indigenous language spoken in the Toto community in Totopara, West Bengal, India. The language faces pressure from more widely spoken regional languages such as Bengali, Hindi, and English. Children who grow up speaking Toto at home primarily use Bengali in educational settings. Currently, there are about ~1000 speakers, even though there are about ~1,600 people in the Toto tribe.",
        notableWorks = "Dhaniram Toto had created the first-ever dictionary and writing system in 2025. It had primarily been an oral language, and creating the writing system helped move Toto away from extinction. A trilinugal dictionary has been published in 2023, in English, Bengali, and Toto.",
        scriptSubtitle = "was recognized.",
        regionDescription = "Toto is spoken in West Bengal, India. It is primarily spoken in Totopara near the India-Bhutan border.",
        rootsDescription = "Toto is a part of the Tibeto-Burman family. It was first documented in 1815 by the British, and it was noted for its unique tone. It has ancestral ties to Bhutan and Mongolia.",
        endangeredDescription = "Dominant languages such as Bengali, Hindi, and English are increasingly used for education, employment, and daily life, reducing the need for Toto.",
        archiveRoute = "totoarchive"

    )
}

@Composable
fun AinuScreen(
    navController: NavController
) {
    LangScreen(
        navController = navController,
        languageName = "Ainu",
        tagline = "A language rooted in the belief of spirituality in nature. ",
        voices = "~2",
        homelandTitle = "1",
        homelandSubtitle = "homeland",
        scriptYear = "2019",
        originDescription = "Ainu is an Indigenous language of the Ainu people of northern Japan, particularly Hokkaido. After decades of declining speakers, there are many efforts for revitalization as many work to preserve and teach Ainu.",
        notableWorks = "Ainu oral traditions include yukar, epic narratives traditionally passed down through generations, along with songs, folktales, and other forms of oral storytelling.",
        scriptTitle = "the people",
        scriptSubtitle = "were recognized.",
        regionDescription = "Ainu is traditionally spoken by the indigenous Ainu people of northern Japan. THe language is concentrated in Hokkaido. Smaller Ainu communities have also existed in other parts of Japan and in nearby regions.",
        rootsDescription = "Ainu is generally considered as an isolated language and has not been known to be related to another known language family. It has its own distinct vocabulary and grammatical structure.",
        endangeredDescription = "Ainu declined sharply as Japanese became dominant through assimilation, education, and social pressures. Today, efforts to revitalize the language include language classes, educational programs, and cultural initiatives.",
        archiveRoute = "ainuarchive"

    )
}

@Composable
fun MyaamiaScreen(
    navController: NavController
) {
    LangScreen(
        navController = navController,
        languageName = "Myaamia",
        tagline = "A language brought back by its people. ",
        voices = "Growing",
        homelandTitle = "1",
        homelandSubtitle = "is",
        scriptYear = "Latin",
        originDescription = "Myaamia is an Indigenous language of the Miami people, historically spoken across parts of the Great Lakes region. Today, community-led revitalization efforts are helping bring the language back to new generations.",
        notableWorks = "Myaamia stories, teachings, songs, and recorded oral traditions are being preserved and shared through community language programs and digital archives.",
        scriptTitle = "writing system",
        scriptSubtitle = "gone in 1970",
        regionDescription = "Myaamia is the language of the Myaamia people, historically spoken across parts of what is now Illinois, Indiana, Ohio, and surrounding areas. It combines indeginous languages from Miami and the Midwest.",
        rootsDescription = "Myaamia belongs to the Algonquian language family and is part of the Miami-Illinois group of languages.",
        endangeredDescription = "Myaamia stopped being passed down as a first language within the community during the 20th century. Today, the Myaamia Center and community members are working to revitalize the language through education, research, and cultural activities.",
        archiveRoute = "myaamiaarchive"

    )
}

//ainu archive screen
@Composable
fun AinuArchive(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(135.dp)
            )

            Text(
                text = "The Archive",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "Your voice won't be forgotten.",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            Text(
                text = "Featured Story",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            ArchiveFolder(
                title = "The Clew",
                nativeLanguage = "日本語",
                onClick = {
                    navController.navigate("story4")
                }
            )

            Spacer(
                modifier = Modifier.height(130.dp)
            )

            Text(
                text = "Stories",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(35.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {

                item {
                    ArchiveDocument(
                        archiveNumber = "STORY 03",
                        title="Pananpe Escapes",
                        nativeLanguage = "Ainu",
                        description = "",
                        duration = "",
                        onClick = {
                            navController.navigate("story1")
                        }
                    )
                }

                item {
                    ArchiveDocument(
                        archiveNumber = "STORY 03",
                        title="Cuckoo & God",
                        nativeLanguage = "Ainu",
                        description = "",
                        duration = "",
                        onClick = {
                            navController.navigate("story2")
                        }
                    )
                }

                item {
                    ArchiveDocument(
                        archiveNumber = "STORY 04",
                        title="Girl in the Snow",
                        nativeLanguage = "Ainu",
                        description = "",
                        duration = "",
                        onClick = {
                            navController.navigate("story3")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TotoArchive(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(135.dp)
            )

            Text(
                text = "The Archive",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "Your voice won't be forgotten.",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            Text(
                text = "Featured Story",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            ArchiveFolder(
                title = "Love Enemies",
                nativeLanguage = "বাংলা",
                onClick = {
                    navController.navigate("totostory1")
                }
            )

            Spacer(
                modifier = Modifier.height(130.dp)
            )

            Text(
                text = "Stories",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(35.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {

                item {
                    ArchiveDocument(
                        archiveNumber = "STORY 02",
                        title="Moses's Laws",
                        nativeLanguage = "Toto",
                        description = "",
                        duration = "",
                        onClick = {
                            navController.navigate("totostory2")
                        }
                    )
                }

                item {
                    ArchiveDocument(
                        archiveNumber = "STORY 03",
                        title="Prodigal Son",
                        nativeLanguage = "Toto",
                        description = "",
                        duration = "",
                        onClick = {
                            navController.navigate("totostory3")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MyaamiaArchive(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(135.dp)
            )

            Text(
                text = "The Archive",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "Your voice won't be forgotten.",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            Text(
                text = "Featured Story",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            ArchiveFolder(
                title = "The Origin",
                nativeLanguage = "English",
                onClick = {
                    navController.navigate("myaamiastory1")
                }
            )

            Spacer(
                modifier = Modifier.height(130.dp)
            )

            Text(
                text = "Revitalization",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )
            Spacer(
                modifier=Modifier.height(20.dp)
            )
            Card(
                modifier=Modifier.fillMaxWidth(),
                shape= RoundedCornerShape(20.dp),
                colors=CardDefaults.cardColors(
                    containerColor = Color(0xFFE0D5C4)
                ),
                border= BorderStroke(
                    1.dp,
                    Color(0xFFB8A48A)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ){
                Column(
                    modifier=Modifier.padding(20.dp)
                ){
                    Text(
                        text="A language being brought back to life.",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color=Color(0xFF5A4635)
                    )
                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )
                    Text(
                        text="Current revitalization groups are trying to bring back the language. Their efforts are " +
                                "across the Midwest.",
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        color=Color(0xFF6B5745)
                    )
                }
            }
        }
    }
}

//used in TOTOSCREEN function
@Composable
fun ExpandableCard(
    title: String,
    description: String
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                expanded = !expanded
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE0D5C4)
        ),

        border = BorderStroke(
            1.dp,
            Color(0xFFB8A48A)
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = if (expanded) "⌄" else "›",
                    fontSize = 24.sp
                )
            }


            if (expanded) {

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = description,
                    fontSize = 16.sp
                )
            }
        }
    }
}


//only for the feature, then switch size :)
@Composable
fun ArchiveFolder(
    title: String,
    nativeLanguage: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.clickable() {
            onClick()
        }
    ) {
        Box(
            modifier = Modifier
                .padding(start = 2.dp)
                .width(90.dp)
                .height(30.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(
                        topStart = 7.dp,
                        topEnd = 7.dp
                    )
                )
                .background(
                    color = Color(0xFFD7C4A3),
                    shape = RoundedCornerShape(
                        topStart = 7.dp,
                        topEnd = 7.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
        ) {

            Text(
                text = title,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 10.dp, top = 4.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

        }
        Card(
            shape = RoundedCornerShape(
                topStart = 7.dp,
                topEnd = 7.dp,
                bottomStart = 12.dp,
                bottomEnd = 12.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEADCC3)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            border = BorderStroke(
                1.dp,
                Color(0xFFD7C4A3),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .offset(y = 26.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            )

            {
                Text(
                    text = "A story passed down through many generations.",
                    fontSize = 16.sp
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "\uD83D\uDD0A Listen"
                    )
                    Text(
                        text = "\uD83C\uDF10 EN | $nativeLanguage"
                    )
                    Text(
                        text = "\uD83D\uDD70\uFE0F 4m"
                    )

                }
            }
        }
    }
}

@Composable
fun ArchiveDocument(
    archiveNumber:String,
    title:String,
    nativeLanguage: String,
    description: String,
    duration:String,
    onClick: () -> Unit
){
    val titleSize= when {
        title.length > 45->16.sp
        title.length > 30 ->18.sp
        else -> 20.sp
        }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{onClick()}
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE2D1B5))
                .border(
                    1.dp,
                    Color(0xFFBFA77F)
                )
                .padding(
                    start=28.dp,
                    end=16.dp,
                    top=16.dp,
                    bottom=16.dp
                )
        ){
           Row(
               modifier=Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween
           ){
               Text(
                   text=archiveNumber,
                   fontSize = 15.sp,
                   fontWeight = FontWeight.Bold,
                   color=Color(0xFF4A3829)
               )
           }
           Spacer(
               modifier=Modifier.height(10.dp)
           )
            Text(
                text=title,
                fontSize = titleSize,
                fontWeight = FontWeight.Bold,
                color=Color(0xFF4A3829)
            )
            Spacer(modifier=Modifier.height(3.dp))
            Text(
                text=nativeLanguage,
                fontSize = 12.sp,
                color=Color(0xFF4A3829)
            )
            Spacer(
                modifier=Modifier.height(12.dp)
            )
            Text(
                text=description,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color=Color(0xFF5A4635),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(
                modifier=Modifier.height(12.dp)
            )
            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement=Arrangement.SpaceBetween
            ){
                Text(
                    text="Audio Recording",
                    fontSize=10.sp,
                    letterSpacing = 1.sp,
                    fontWeight=FontWeight.Bold,
                )
                Spacer(
                    modifier=Modifier.height(10.dp)
                )
                Text(
                    text=duration,
                    fontSize=10.sp,
                    color=Color(0xFF5A4635)
                )
            }
        }
        Box(
            modifier=Modifier
                .align(Alignment.TopStart)
                .offset(x=10.dp,y=15.dp)
                .size(10.dp)
                .border(7.dp,
                    Color(0xFFB09D71),
                    CircleShape)

        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x=10.dp)
                .size(10.dp)
                .border(7.dp,
                    Color(0xFFB09D71),
                    CircleShape)

        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x=10.dp,y=(-15).dp)
                .size(10.dp)
                .border(7.dp,
                    Color(0xFFB09D71),
                    CircleShape)

        )
    }
}

//speech bubble
@Composable
fun SpeechBubble() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),

            shape = RoundedCornerShape(
                topStart = 80.dp,
                topEnd = 80.dp,
                bottomStart = 80.dp,
                bottomEnd = 80.dp
            ),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF7EBD8)
            ),

            border = BorderStroke(
                2.dp,
                Color(0xFFCBB18A)
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(
                        Color(0x22FFFFFF),
                        RoundedCornerShape(45.dp)
                    )
            )

        }


        Text(
            text = "Identity",
            fontSize = 27.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 100.dp,
                    y = 70.dp
                )
        )
        Text(
            text = "Voice",
            fontSize = 21.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 35.dp,
                    y = 45.dp
                )
        )
        Text(
            text = "ᱡᱚᱦᱟᱨ",
            fontSize = 23.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 185.dp,
                    y = 20.dp
                )
        )
        Text(
            text = "ᎣᏏᏲ",
            fontSize = 24.sp,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 45.dp,
                    y = 128.dp
                )
        )
        Text(
            text = "Kia ora",
            fontSize = 20.sp,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 220.dp,
                    y = 90.dp
                )
        )
        Text(
            text = "Roots",
            fontSize = 18.sp,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 140.dp,
                    y = 120.dp
                )
        )
        Text(
            text = "ᐊᐃᓐᓇ",
            fontSize = 16.sp,
            color = Color(0xFF5A4635),
            modifier = Modifier
                .offset(
                    x = 260.dp,
                    y = 140.dp
                )
        )


        Box(
            modifier = Modifier
                .offset(
                    x = 60.dp,
                    y = 200.dp
                )
                .size(27.dp)
                .background(
                    Color(0xFFF7EBD8),
                    CircleShape
                )
                .border(
                    2.dp,
                    Color(0xFFCBB18A),
                    CircleShape
                )
        )


        Box(
            modifier = Modifier
                .offset(
                    x = 50.dp,
                    y = 230.dp
                )
                .size(16.dp)
                .background(
                    Color(0xFFF7EBD8),
                    CircleShape
                )
                .border(
                    2.dp,
                    Color(0xFFCBB18A),
                    CircleShape
                )
        )

    }
}

@Composable
fun StatCard(
    number: String,
    title: String,
    subtitle: String
) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(140.dp),
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 20.dp,
            bottomStart = 20.dp,
            bottomEnd = 20.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFCFBFA3)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = number,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                fontSize = 12.sp,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
fun Bar(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color(0xFF806A52))
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "LinguArchiac",
            fontSize = 22.sp,
            color = Color(0xFFF7EBD8),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "Home",
            fontSize = 14.sp,
            color = Color(0xFFF7EBD8),
            modifier = Modifier.clickable {
                navController.navigate("language")
            }
        )
        Spacer(
            modifier = Modifier.width(20.dp)
        )
        Text(
            text = "Toto",
            fontSize = 14.sp,
            color = Color(0xFFF7EBD8),
            modifier = Modifier.clickable {
                navController.navigate("toto")
            }
        )
        Spacer(
            modifier = Modifier.width(20.dp)
        )
        Text(
            text = "Ainu",
            fontSize = 14.sp,
            color = Color(0xFFF7EBD8),
            modifier = Modifier.clickable {
                navController.navigate("ainu")
            }
        )
        Spacer(
            modifier = Modifier.width(20.dp)
        )
        Text(
            text = "Myaamia",
            fontSize = 14.sp,
            color = Color(0xFFF7EBD8),
            modifier = Modifier.clickable {
                navController.navigate("myaamia")
            }
        )

    }
}


@Composable
fun PreviewCard(
    title: String,
    subtitle: String,
    navController: NavController,
    route: String
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(150.dp)
            .clickable {
                navController.navigate(route)
            },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE0D5C4)
        ),
        border = BorderStroke(
            1.dp,
            Color(0xFFB8A48A)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)

            )
            Spacer(
                modifier = Modifier.height(5.dp)
            )
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color(0xFF6B5745)
            )
        }
    }
}


//ainu
@Composable
fun StoryScreen(
    navController: NavController,
    title: String,
    description: String,
    image: Int,
    engText: String,
    ogText: String,
    audio: Int
) {
    var selectedLanguage by remember { mutableStateOf("English") }
    var showFullStory by remember { mutableStateOf(false) }
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(
            context,
            audio
        )
    }
    mediaPlayer.setVolume(1.0f, 1.0f)
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    top = 100.dp,
                    bottom = 40.dp
                )
        ) {

            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = description,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    color = Color(0xFF5A4635)
                )

                Image(
                    painter = painterResource(image),
                    contentDescription = "Story Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // LISTEN CARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (isPlaying) {
                            mediaPlayer.pause()
                            isPlaying = false
                        } else {
                            mediaPlayer.start()
                            isPlaying = true
                        }
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE2DACB)
                ),
                shape = RoundedCornerShape(14.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = if (isPlaying) "⏸" else "▶",
                        fontSize = 25.sp
                    )

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column {

                        Text(
                            text = "Listen",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF5A4635)
                        )

                        Text(
                            text = "Original Ainu recording",
                            fontSize = 13.sp,
                            color = Color(0xFF6B5745)
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Text(
                text = "Translation",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE2DACB))
            ) {
                Text(
                    text = "日本語",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "Japanese") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },

                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "Japanese"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "Japanese") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )
                Text(
                    text = "English",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "English") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },

                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "English"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "English") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            Text(
                if (selectedLanguage == "Japanese") {
                    ogText.take(100) + "..."
                } else {
                    engText.take(100) + "..."
                },
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = Color(0xFF5A4635),
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(
                modifier = Modifier.height(18.dp)
            )
            Text(
                text = if (showFullStory) {
                    "Show less ↑"
                } else {
                    "Read Story →"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showFullStory = !showFullStory
                    }
                    .padding(vertical = 8.dp)
            )
            if (showFullStory) {
                Text(
                    text = if (selectedLanguage == "Japanese") {
                        ogText
                    } else {
                        engText
                    },
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = Color(0xFF5A4635),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Text(
                text = "Source",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "A Glossed Audio Corpus of Ainu Folklore — NINJAL",
                fontSize = 13.sp,
                color = Color(0xFF6B5745),
                lineHeight = 20.sp
            )

        }
    }
}

@Composable
fun MyaamiaStoryScreen(
    navController: NavController,
    title: String,
    description: String,
    image: Int,
    engText: String,
    ogText: String
) {
    var selectedLanguage by remember { mutableStateOf("English") }
    var showFullStory by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    top = 100.dp,
                    bottom = 40.dp
                )
        ) {

            // STORY TITLE

            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            // DESCRIPTION + IMAGE

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = description,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    color = Color(0xFF5A4635)
                )

                Image(
                    painter = painterResource(image),
                    contentDescription = "Story Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Text(
                text = "Translation",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE2DACB))
            ) {

                Text(
                    text = "Myaamia",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "Myaamia") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },
                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "Myaamia"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "Myaamia") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )

                Text(
                    text = "English",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "English") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },
                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "English"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "English") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            Text(
                text = if (selectedLanguage == "Myaamia") {
                    ogText.take(100) + "..."
                } else {
                    engText.take(100) + "..."
                },
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = Color(0xFF5A4635),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = if (showFullStory) {
                    "Show less ↑"
                } else {
                    "Read Story →"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showFullStory = !showFullStory
                    }
                    .padding(vertical = 8.dp)
            )

            if (showFullStory) {
                Text(
                    text = if (selectedLanguage == "Myaamia") {
                        ogText
                    } else {
                        engText
                    },
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = Color(0xFF5A4635),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Text(
                text = "Source",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Myaamia",
                fontSize = 13.sp,
                color = Color(0xFF6B5745),
                lineHeight = 20.sp
            )
        }
    }
}


@Composable
fun BengaliStoryScreen(
    navController: NavController,
    title: String,
    description: String,
    image: Int,
    engText: String,
    ogText: String,
    audio: Int
) {
    var selectedLanguage by remember { mutableStateOf("English") }
    var showFullStory by remember { mutableStateOf(false) }
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayer = remember {
        MediaPlayer.create(
            context,
            audio
        )
    }
    mediaPlayer.setVolume(1.0f, 1.0f)
    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.map_bg),
            contentDescription = "map background",
            contentScale = ContentScale.Crop,
            alpha = 0.35f,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99E2DACB))
        )

        Bar(navController)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    top = 100.dp,
                    bottom = 40.dp
                )
        ) {

            Text(
                text = title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = description,
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    color = Color(0xFF5A4635)
                )

                Image(
                    painter = painterResource(image),
                    contentDescription = "Story Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            // LISTEN CARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (isPlaying) {
                            mediaPlayer.pause()
                            isPlaying = false
                        } else {
                            mediaPlayer.start()
                            isPlaying = true
                        }
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE2DACB)
                ),
                shape = RoundedCornerShape(14.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = if (isPlaying) "⏸" else "▶",
                        fontSize = 25.sp
                    )

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Column {

                        Text(
                            text = "Listen",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF5A4635)
                        )

                        Text(
                            text = "Toto Bible Teachings",
                            fontSize = 13.sp,
                            color = Color(0xFF6B5745)
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Text(
                text = "Translation",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE2DACB))
            ) {
                Text(
                    text = "টোটো",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "Bengali") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },

                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "Bengali"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "Bengali") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )
                Text(
                    text = "English",
                    fontSize = 15.sp,
                    fontWeight = if (selectedLanguage == "English") {
                        FontWeight.Bold
                    } else {
                        FontWeight.Medium
                    },

                    color = Color(0xFF5A4635),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedLanguage = "English"
                            showFullStory = false
                        }
                        .background(
                            if (selectedLanguage == "English") {
                                Color(0xFFCBBBA6)
                            } else {
                                Color.Transparent
                            }
                        )
                        .padding(vertical = 12.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            Text(
                if (selectedLanguage == "Bengali") {
                    ogText.take(100) + "..."
                } else {
                    engText.take(100) + "..."
                },
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = Color(0xFF5A4635),
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(
                modifier = Modifier.height(18.dp)
            )
            Text(
                text = if (showFullStory) {
                    "Show less ↑"
                } else {
                    "Read Story →"
                },
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showFullStory = !showFullStory
                    }
                    .padding(vertical = 8.dp)
            )
            if (showFullStory) {
                Text(
                    text = if (selectedLanguage == "Bengali") {
                        ogText
                    } else {
                        engText
                    },
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = Color(0xFF5A4635),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Text(
                text = "Source",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5A4635)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Evangeline",
                fontSize = 13.sp,
                color = Color(0xFF6B5745),
                lineHeight = 20.sp
            )

        }
    }
}
