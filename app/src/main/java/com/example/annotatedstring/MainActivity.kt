package com.example.annotatedstring

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Transition()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Transition() {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) {
        val urbanText = buildAnnotatedString {
            pushStyle(
                SpanStyle(
                    color = Color.Magenta,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            append("Urban")
        }

        val universityText = buildAnnotatedString {
            pushStyle(
                SpanStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            append("University")
        }

        Row {
            Text(
                text = urbanText,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        val intent = Intent(context, FirstActivity::class.java)
                        context.startActivity(intent)
                    }
            )

            Text(
                text = universityText,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

