package tr.com.kutluoglu.tennisgame.tennis

import kotlin.math.abs

class TennisGame(private val player1: TennisPlayer, private val player2: TennisPlayer) {
    var gameStatue: GameStatues = GameStatues.PLAYING

    fun isPlayer1HasAtLeast4Points(): Boolean = player1.points >= 4

    fun updatePlayer1ScoreBy(score: Int = 1) {
        player1.points += score
        updateGameScore()
    }

    fun isPlayer1HasAtLeast2OrMorePointsThanTheOpponent(): Boolean =
        player1.points - player2.points >= 2

    fun updatePlayer2ScoreBy(score: Int = 1) {
        player2.points += score
        updateGameScore()
    }

    fun isPlayer2HasAtLeast4Points(): Boolean = player2.points >= 4

    fun isPlayer2HasAtLeast2OrMorePointsThanTheOpponent(): Boolean =
        player2.points - player1.points >= 2

    fun isPlayer1Won(): Boolean {
        val won = isPlayer1HasAtLeast4Points() && isPlayer1HasAtLeast2OrMorePointsThanTheOpponent()
        if (won) gameStatue = GameStatues.PLAYER1WON
        return won
    }

    fun isPlayer2Won(): Boolean {
        val won = isPlayer2HasAtLeast4Points() && isPlayer2HasAtLeast2OrMorePointsThanTheOpponent()
        if (won) gameStatue = GameStatues.PLAYER2WON
        return won
    }

    fun eachPlayerScoresAtLeast3Points(): Boolean = player1.points >= 3 && player2.points >= 3

    fun isScoreEqual(): Boolean = player1.points == player2.points

    fun isDeuce(): Boolean {
        val isDeuce = eachPlayerScoresAtLeast3Points() && isScoreEqual()
        if (isDeuce) gameStatue = GameStatues.DEUCE
        return isDeuce
    }

    fun isAdvantage(): Boolean {
        val isAdvantage = eachPlayerScoresAtLeast3Points() && abs(player1.points - player2.points) == 1
        if (isAdvantage) gameStatue = GameStatues.ADVANTAGE
        return isAdvantage
    }

    fun player1Points(): Int = player1.points

    fun player2Points(): Int = player2.points

    private fun updateGameScore() {
        isDeuce()
        isAdvantage()
        isPlayer1Won()
        isPlayer2Won()
    }
}
