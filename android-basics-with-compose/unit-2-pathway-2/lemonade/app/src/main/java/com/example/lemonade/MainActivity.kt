package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SqueezeApp()
        }
    }
}

@Composable
fun ImageWithText(modifier: Modifier = Modifier) {
    var currentScene by remember { mutableIntStateOf(1) }
    var squeezesCounter by remember { mutableIntStateOf(1) }
    val imageResource = when (currentScene) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val imageDescription = when (currentScene) {
        1 -> stringResource(R.string.lemon_tree)
        2 -> stringResource(R.string.lemon)
        3 -> stringResource(R.string.glass_of_lemonade)
        else -> stringResource(R.string.empty_glass)
    }
    val labelResource = when (currentScene) {
        1 -> stringResource(R.string.tap_the_lemon)
        2 -> stringResource(R.string.keep_tapping)
        3 -> stringResource(R.string.tap_the_lemonade)
        else -> stringResource(R.string.tap_the_empty_glass)
    }
    val handleClick: () -> Unit = {
        when (currentScene) {
            1 -> currentScene++
            2 -> {
                val requiredSqueezes = (1..5).random()
                if (squeezesCounter < requiredSqueezes) {
                    squeezesCounter++
                } else {
                    currentScene++
                }
            }
            3 -> currentScene++
            4 -> {
                currentScene = 1
                squeezesCounter = 0
            }
        }
    }
    
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = handleClick,
            shape = RoundedCornerShape(25),
            colors = ButtonColors(
                containerColor = Color(195, 236, 210),
                disabledContainerColor = Color(120, 145, 130),
                contentColor = Color(195, 236, 210),
                disabledContentColor = Color(120, 145, 130),
            ),
        ) {
            Image(painter = painterResource(imageResource), contentDescription = imageDescription)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = labelResource,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SqueezeApp() {
    ImageWithText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}