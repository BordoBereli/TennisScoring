package tr.com.kutluoglu.tennisgame.tennis

/**
 * Created by F.K. on 14.09.2022.
 *
 */
enum class GameStatues(val statue: String) {
    DEUCE("deuce"), ADVANTAGE("advantage"),
    PLAYER1WON("Player1 won"), PLAYER2WON("Player2 won"),
    PLAYING("");
}