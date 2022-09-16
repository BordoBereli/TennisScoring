package tr.com.kutluoglu.tennisgame.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import tr.com.kutluoglu.tennisgame.presentation.TennisViewModel
import tr.com.kutluoglu.tennisgame.ui.TennisScoreState
import tr.com.kutluoglu.tennisgame.ui.theme.TennisGameTheme

/**
 * Created by F.K. on 14.09.2022.
 *
 */

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TennisScreen(
    viewModel: TennisViewModel
) {
    TennisGameTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            TennisPlayingAnimation()
            Greeting(viewModel.tennisScoreState)
        }
    }
}

@Composable
fun Greeting(uiState: State<TennisScoreState>) {
    val score = uiState.value.score
    Text(
        text = "Game Score: $score",
        color = Color.Companion.White,
        style = MaterialTheme.typography.h4,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
}

@Composable
fun TennisPlayingAnimation() {
    GlideImage(
        imageModel = "https://c.tenor.com/UqXeu2y66gIAAAAC/kitty-table-tennis.gif",
        imageOptions = ImageOptions(
            contentScale = ContentScale.FillBounds
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TennisGameTheme {
//        Greeting(TennisScoreState("Hello Tennis Game Scoring!"))
    }
}