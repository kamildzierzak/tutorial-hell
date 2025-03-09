package com.example.thelearntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thelearntogether.ui.theme.TheLearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheLearnTogetherTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun ArticleImage(modifier: Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun ArticleText(
    title: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = firstParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = secondParagraph,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    Column(modifier = Modifier) {
        ArticleImage(Modifier.fillMaxWidth())
        ArticleText(
            stringResource(R.string.title),
            stringResource(R.string.firstParagraph),
            stringResource(R.string.secondParagraph),
            modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheLearnTogetherTheme {
        Article()
    }
}