package tr.com.kutluoglu.tennisgame

import android.graphics.fonts.FontStyle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tr.com.kutluoglu.tennisgame.ui.theme.TennisGameTheme

/**
 * Created by F.K. on 14.09.2022.
 *
 */

@RequiresApi(Build.VERSION_CODES.N)
@Preview(name = "Light Mode")
@Composable
fun TennisScreen() {
    TennisGameTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Greeting("Tennis Game Scoring!!!")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h3
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TennisGameTheme {
        Greeting("Tennis Game Scoring!!!")
    }
}