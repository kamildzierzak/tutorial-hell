package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryApp()
        }
    }
}

data class Artwork(
    val title: String,
    val artist: String,
    val year: String,
    val imageResource: Int
)

@Composable
fun Gallery() {
    val artworks = listOf(
        Artwork("Starry Night", "Vincent van Gogh", "1889", R.drawable.starry_night),
        Artwork("Mona Lisa", "Leonardo da Vinci", "1503", R.drawable.mona_lisa),
        Artwork("The Scream", "Edvard Munch", "1893", R.drawable.the_scream),
    )


    var currentIndex by remember { mutableIntStateOf(0) }

    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtworkWall(
            imageResource = currentArtwork.imageResource,
            modifier = Modifier
                .fillMaxWidth()
                .weight(8f)
                .padding(8.dp)
                .clip(RoundedCornerShape(10))
                .background(Color.White)
        )
        ArtworkDescriptor(
            title = currentArtwork.title,
            artist = currentArtwork.artist,
            year = currentArtwork.year,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .padding(8.dp)
        )
        DisplayController(
            onPrevious = { if (currentIndex > 0) currentIndex-- },
            onNext = { if (currentIndex < artworks.size - 1) currentIndex++ },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp)
        )
    }
}

@Composable
fun ArtworkWall(imageResource: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            painter = painterResource(imageResource),
            contentDescription = "",
        )
    }
}

@Composable
fun ArtworkDescriptor(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$artist ($year)",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun DisplayController(onPrevious: () -> Unit, onNext: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onPrevious, modifier = Modifier.weight(0.3f), shape = RectangleShape) {
            Text(
                text = stringResource(R.string.previous),
                fontSize = 16.sp
            )
        }
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Button(onClick = onNext, modifier = Modifier.weight(0.3f), shape = RectangleShape) {
            Text(
                text = stringResource(R.string.next),
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtGalleryApp() {
    Gallery()
}