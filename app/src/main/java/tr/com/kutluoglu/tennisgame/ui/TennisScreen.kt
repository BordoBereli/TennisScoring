package tr.com.kutluoglu.tennisgame

import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ComponentRegistry
import coil.ImageLoader
import coil.decode.Decoder
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.glide.GlideImage
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
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello\n $name!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.fillMaxSize())
    }
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
        Greeting("Tennis Game Scoring!!!")
    }
}