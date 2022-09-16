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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                TennisPlayingAnimation()
                Greeting(viewModel.tennisScoreState)
            }
        }
    }
}

@Composable
fun Greeting(uiState: State<TennisScoreState>) {
    val score = uiState.value.score
    Text(
        text = "Game Score: $score",
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(400.dp)
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