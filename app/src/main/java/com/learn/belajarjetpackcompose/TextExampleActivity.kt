package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class TextExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                Column {
                    JustText()
                    SpaceLine()
                    StyleText()
                    SpaceLine()
                    FontText()
                    SpaceLine()
                    TextOverflow()
                    SpaceLine()
                    TextAlignFun()
                    SpaceLine()
                    TextLineHeight()
                    SpaceLine()
                    TextWithClick()
                    SpaceLine()
                    TextSpanRange()
                    SpaceLine()
                    TextSpanRangeClick()
                    SpaceLine()
                    TextSelectionExample()
                    SpaceLine()
                    TextInCenter()
                }
            }
        }
    }
}

@Composable
fun SpaceLine() {
    Spacer(Modifier.padding(vertical = 5.dp).height(1.dp).fillMaxWidth().background(Color.Black))
}

@Composable
fun JustText() {
    Text(text = "Hello World!")
}

@Composable
fun StyleText() {
    Text(text = "Hello World",
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun FontText() {
    Text(
        text = "Hello World",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 10.sp
        )
    )
}

@Composable
fun TextOverflow() {
    Text(
        text = "Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun TextAlignFun() {
    Text(
        text = "Hello World",
        color = Color.Red,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.End
    )

    Spacer(Modifier.padding(3.dp))

    Text(
        text = "Hello World",
        color = Color.Green,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextLineHeight() {
    Text(
        text = "Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World Hello World",
        style = MaterialTheme.typography.bodySmall,
        lineHeight = 40.sp
    )
}

@Composable
fun TextWithClick() {
    val context = LocalContext.current

    Column {
        Text(
            text = "Hello World",
            modifier = Modifier
                .padding(10.dp)
                .clickable {
                Toast
                    .makeText(context, "Ganti Text", Toast.LENGTH_SHORT)
                    .show()
            }
        )

        Spacer(modifier = Modifier.padding(3.dp))

        Text(
            text = "Hello World",
            modifier = Modifier
                .clickable {
                Toast
                    .makeText(context, "Ganti Text", Toast.LENGTH_SHORT)
                    .show()
            }.padding(10.dp)
        )
    }
}

@Composable
fun TextSpanRange() {
    Text(
        buildAnnotatedString {
            append("Hello World")

            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                append("Hello Hello")
            }
            append("")
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.ExtraBold)) {
                append("World World")
            }
        }
    )
}

@Composable
fun TextSpanRangeClick() {
    val context = LocalContext.current

    val spanRangeClickText = buildAnnotatedString {
        append("Hello World")
        pushStringAnnotation(
            tag = "tag",
            annotation = "Hello Hello Hello"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("World World World")
        }
        pop()
    }

    ClickableText(
        text = spanRangeClickText,
        onClick = { offset ->
            spanRangeClickText.getStringAnnotations(
                tag = "tag",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                Toast
                    .makeText(context, "Hello World", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    )
}

@Composable
fun TextSelectionExample() {
    SelectionContainer {
        Text(
            text = "Hello World",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TextInCenter() {
    Box(
      modifier = Modifier.size(width = 200.dp, height = 100.dp).background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun TextExamplePreview() {
    BelajarJetpackComposeTheme {
        Column {
            JustText()
            SpaceLine()
            StyleText()
            SpaceLine()
            FontText()
            SpaceLine()
            TextOverflow()
            SpaceLine()
            TextAlignFun()
            SpaceLine()
            TextLineHeight()
            SpaceLine()
            TextWithClick()
            SpaceLine()
            TextSpanRange()
            SpaceLine()
            TextSpanRangeClick()
            SpaceLine()
            TextSelectionExample()
            SpaceLine()
            TextInCenter()
        }
    }
}