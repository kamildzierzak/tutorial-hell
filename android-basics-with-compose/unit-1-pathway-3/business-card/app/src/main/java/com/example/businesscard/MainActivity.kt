package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun MainInfo() {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 160.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.minimal_moon),
                    contentDescription = null,
                    Modifier.width(100.dp),
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Blue Cloud",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Light,
                )
                Text(
                    text = "Cool guy!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun DetailsInfo(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "📞",
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "+11 111 111 111"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "🌐",
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "@BlueCloud"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "✉️",
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "blue.cloud@example.com"
                )
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp),
        Arrangement.SpaceBetween,
        Alignment.CenterHorizontally
    ) {
        MainInfo()
        DetailsInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}