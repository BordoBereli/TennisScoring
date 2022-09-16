package tr.com.kutluoglu.tennisgame

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import dagger.hilt.android.AndroidEntryPoint
import tr.com.kutluoglu.tennisgame.presentation.TennisViewModel
import tr.com.kutluoglu.tennisgame.ui.TennisScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val tennisViewModel: TennisViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TennisScreen(tennisViewModel)
        }
        tennisViewModel.initPlayTennisGame()
    }
}