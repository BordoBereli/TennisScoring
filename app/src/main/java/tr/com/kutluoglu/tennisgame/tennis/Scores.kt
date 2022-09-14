package tr.com.kutluoglu.tennisgame.tennis

/**
 * Created by F.K. on 12.09.2022.
 *
 */
enum class Scores(val score: Int, val title: String) {
    LOVE(0,"love"), FIFTEEN(1, "15"),
    THIRTY(2, "30"), FORTY(3, "40");
}