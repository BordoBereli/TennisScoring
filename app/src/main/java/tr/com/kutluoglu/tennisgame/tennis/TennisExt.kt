package tr.com.kutluoglu.tennisgame.tennis

/**
 * Created by F.K. on 14.09.2022.
 *
 */

fun playerScore(points: Int): String = when(points) {
    0 -> Scores.LOVE.title
    1 -> Scores.FIFTEEN.title
    2 -> Scores.THIRTY.title
    3 -> Scores.FORTY.title
    else -> points.toString()
}