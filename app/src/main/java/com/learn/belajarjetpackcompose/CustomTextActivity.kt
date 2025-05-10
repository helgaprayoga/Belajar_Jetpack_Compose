package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class CustomTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    CustomText()
                    CustomText2()
                    CustomText3()
                    TextSelection()
                }
            }
        }
    }
}

@Composable
fun CustomText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(30.dp)
            .fillMaxWidth()
            .background(Color.DarkGray), // penempatan background setelah padding maka background akan dapat di padding
        color = Color.White,
        fontSize = 25.sp,
        style = MaterialTheme.typography.headlineLarge,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.End
    )
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )) {
                    append("A")
                }
                append("B")
                append("C")
                append("D")
        }, modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun CustomText3() {
    Text(text = "Hello World".repeat(20), maxLines = 3, overflow = TextOverflow.Visible)
}

@Composable
fun TextSelection() {
    SelectionContainer {
        Column {
            Text(text = "Bisa diseleksi misal di copy!")
            DisableSelection {
                Text(text = "Tidak bisa diseleksi")
            }
            Text(text = "Bisa diseleksi misal di copy")
        }
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    normalFontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    normalColor: Color = MaterialTheme.colorScheme.tertiary,
    superText: String,
    superFontSize: TextUnit = MaterialTheme.typography.headlineSmall.fontSize,
    superColor: Color = Color.Red,
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = normalColor,
                    fontSize = normalFontSize,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    color = superColor,
                    fontSize = superFontSize,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append(superText)
            }
        }
    )
}

@Composable
fun SubScriptText(normalText: String, subText: String) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.ExtraBold,
                    baselineShift = BaselineShift.Subscript
                )
            ) {
                append(subText)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextActivityPreview() {
    BelajarJetpackComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomText()
            CustomText2()
            CustomText3()
            TextSelection()
            SuperScriptText(normalText = "2 derajat = 2", superText = "2", normalColor = MaterialTheme.colorScheme.inversePrimary, superColor = Color.Yellow)
            SubScriptText(normalText = "ini adalah subscript = 2", subText = "2")
        }
    }
}