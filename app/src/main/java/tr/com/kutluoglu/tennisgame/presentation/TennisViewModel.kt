package tr.com.kutluoglu.tennisgame.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tr.com.kutluoglu.tennisgame.tennis.GameScore
import tr.com.kutluoglu.tennisgame.tennis.GameStatues
import tr.com.kutluoglu.tennisgame.tennis.TennisGame
import tr.com.kutluoglu.tennisgame.tennis.TennisPlayer
import tr.com.kutluoglu.tennisgame.ui.TennisScoreState
import javax.inject.Inject

@HiltViewModel
class TennisViewModel @Inject constructor(): ViewModel() {
    private var _tennisScoreState = mutableStateOf(TennisScoreState())
    val tennisScoreState: State<TennisScoreState> = _tennisScoreState

    fun initPlayTennisGame() {
        val player1 = TennisPlayer()
        val player2 = TennisPlayer()
        val tennisGame = TennisGame(player1, player2)
        val gameScore = GameScore()
        viewModelScope.launch(Dispatchers.IO) {
            refreshGameScore(tennisGame, gameScore)
        }
        viewModelScope.launch(Dispatchers.IO) {
            updateGameScore(tennisGame, gameScore)
        }
    }

    private suspend fun refreshGameScore(tennisGame: TennisGame, gameScore: GameScore) {
        _tennisScoreState.value = TennisScoreState(gameScore.show(tennisGame))
        when(tennisGame.gameStatue) {
            GameStatues.PLAYER1WON, GameStatues.PLAYER2WON -> {
                    reStart()
            }
            else -> {}
        }
    }

    private suspend fun reStart() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(10000)
            initPlayTennisGame()
        }
    }

    private suspend fun updateGameScore(tennisGame: TennisGame, gameScore: GameScore) {
        while (!(tennisGame.isPlayer1Won() || tennisGame.isPlayer2Won())) {
            println("Game Score: ${gameScore.show(tennisGame)}")
            when(System.nanoTime().toInt() % 3) {
                0 -> {
                    delay(2000)
                    tennisGame.updatePlayer1ScoreBy()
                    refreshGameScore(tennisGame, gameScore) }
                1 -> {
                    delay(2000)
                    tennisGame.updatePlayer2ScoreBy()
                    refreshGameScore(tennisGame, gameScore) }
                else -> { delay(1000) }
            }
        }
    }
}
