package tr.com.kutluoglu.tennisgame.tennis

class GameScore {
    fun show(game: TennisGame): String {
        return when(game.gameStatue) {
            GameStatues.DEUCE -> GameStatues.DEUCE.statue
            GameStatues.ADVANTAGE -> GameStatues.ADVANTAGE.statue
            GameStatues.PLAYER1WON -> GameStatues.PLAYER1WON.statue
            GameStatues.PLAYER2WON -> GameStatues.PLAYER2WON.statue
            else -> "${player1Score(game)}-${player2Score(game)}"
        }
    }
    private fun player1Score(game: TennisGame) = playerScore(game.player1Points())
    private fun player2Score(game: TennisGame) = playerScore(game.player2Points())
}
