package tr.com.kutluoglu.tennisgame

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.shouldBe
import tr.com.kutluoglu.tennisgame.tennis.TennisGame
import tr.com.kutluoglu.tennisgame.tennis.TennisPlayer

/**
 * Created by F.K. on 12.09.2022.
 *
 */

class TennisGameTest : StringSpec({
    isolationMode = IsolationMode.InstancePerTest
    include(tennisGameTest())
})

fun tennisGameTest() = stringSpec {
    val player1 = TennisPlayer(0)
    val player2 = TennisPlayer(0)
    val game = TennisGame(player1, player2)

    "should TennisGame.updatePlayer1Score() updates player1 score by 1 points" {
        game.updatePlayer1ScoreBy()
        player1.points shouldBe 1
    }

    "should TennisGame.isPlayer1HasAtLeast4Points() return false" {
        game.isPlayer1HasAtLeast4Points() shouldBe false
    }

    "should TennisGame.isPlayer1HasAtLeast4Points() return true" {
        game.updatePlayer1ScoreBy(4)
        game.isPlayer1HasAtLeast4Points() shouldBe true
    }

    "should TennisGame.isPlayer1HasAtLeast2OrMorePointsThanTheOpponent return false" {
        game.isPlayer1HasAtLeast2OrMorePointsThanTheOpponent() shouldBe false
    }

    "should TennisGame.isPlayer1HasAtLeast2OrMorePointsThanTheOpponent return true" {
        game.updatePlayer1ScoreBy(2)
        game.isPlayer1HasAtLeast2OrMorePointsThanTheOpponent() shouldBe true
    }

    "should TennisGame.isPlayer1Won() return false when player1 does not have 4 or more points" {
        game.updatePlayer1ScoreBy(2)
        game.isPlayer1Won() shouldBe false
    }

    "should TennisGame.isPlayer1Won() return false when player1 have 4 or more points but has less than 2 points differ" {
        game.updatePlayer1ScoreBy(5)
        game.updatePlayer2ScoreBy(4)
        game.isPlayer1Won() shouldBe false
    }

    "should TennisGame.isPlayer1Won() return true when player1 have 4 or more points and has more than 2 points differ" {
        game.updatePlayer1ScoreBy(4)
        game.updatePlayer2ScoreBy(2)
        game.isPlayer1Won() shouldBe true
    }

    "should TennisGame.updatePlayer2Score() updates player2 score by 1 points" {
        game.updatePlayer2ScoreBy(1)
        player2.points shouldBe 1
    }

    "should TennisGame.isPlayer2HasAtLeast4Points() return false" {
        game.isPlayer2HasAtLeast4Points() shouldBe false
    }

    "should TennisGame.isPlayer2HasAtLeast4Points() return true" {
        game.updatePlayer2ScoreBy(4)
        game.isPlayer2HasAtLeast4Points() shouldBe true
    }

    "should TennisGame.isPlayer2HasAtLeast2OrMorePointsThanTheOpponent return false" {
        game.isPlayer2HasAtLeast2OrMorePointsThanTheOpponent() shouldBe false
    }

    "should TennisGame.isPlayer2HasAtLeast2OrMorePointsThanTheOpponent return true" {
        game.updatePlayer2ScoreBy(2)
        game.isPlayer2HasAtLeast2OrMorePointsThanTheOpponent() shouldBe true
    }

    "should TennisGame.isPlayer2Won() return false when player2 does not have 4 or more points" {
        game.updatePlayer2ScoreBy(2)
        game.isPlayer2Won() shouldBe false
    }

    "should TennisGame.isPlayer2Won() return false when player2 have 4 or more points but has less than 2 points differ" {
        game.updatePlayer1ScoreBy(4)
        game.updatePlayer2ScoreBy(5)
        game.isPlayer2Won() shouldBe false
    }

    "should TennisGame.isPlayer2Won() return true when player2 have 4 or more points and has more than 2 points differ" {
        game.updatePlayer1ScoreBy(2)
        game.updatePlayer2ScoreBy(4)
        game.isPlayer2Won() shouldBe true
    }

    "should TennisGame.eachPlayerScoresAtLeast3Points return false when any player less than 3 points" {
        game.eachPlayerScoresAtLeast3Points() shouldBe false
    }

    "should TennisGame.eachPlayerScoresAtLeast3Points return true when each player more than 3 points" {
        game.updatePlayer1ScoreBy(3)
        game.updatePlayer2ScoreBy(4)
        game.eachPlayerScoresAtLeast3Points() shouldBe true
    }

    "should TennisGame.isScoreEqual() return false" {
        game.updatePlayer1ScoreBy(3)
        game.updatePlayer2ScoreBy(4)
        game.isScoreEqual() shouldBe false
    }

    "should TennisGame.isScoreEqual() return true" {
        game.isScoreEqual() shouldBe true
    }

    "should TennisGame.isDeuce() return false when any player scores less than 3 points" {
        game.isDeuce() shouldBe false
    }

    "should TennisGame.isDeuce() return true when any player scores more than 3 points and score is equal" {
        game.updatePlayer1ScoreBy(4)
        game.updatePlayer2ScoreBy(4)
        game.isDeuce() shouldBe true
    }

    "should TennisGame.isAdvantage() return false any player scores less than 3 points" {
        game.isAdvantage() shouldBe false
    }

    "should TennisGame.isAdvantage() return true any player scores more than 3 points and one has one point lead" {
        game.updatePlayer1ScoreBy(4)
        game.updatePlayer2ScoreBy(3)
        game.isAdvantage() shouldBe true
    }

    "should TennisGame.player1Points return Player1 points 0" {
        game.player1Points() shouldBe player1.points
    }

    "should TennisGame.player1Points return Player1 points as 1" {
        game.updatePlayer1ScoreBy()
        game.player1Points() shouldBe player1.points
    }

    "should TennisGame.player1Points return Player1 points as 2" {
        game.updatePlayer1ScoreBy(2)
        game.player1Points() shouldBe player1.points
    }

    "should TennisGame.player2Points return Player2 points 0" {
        game.player2Points() shouldBe player2.points
    }

    "should TennisGame.player2Points return Player2 points as 1" {
        game.updatePlayer2ScoreBy()
        game.player2Points() shouldBe player2.points
    }

    "should TennisGame.player2Points return Player2 points as 2" {
        game.updatePlayer2ScoreBy(2)
        game.player2Points() shouldBe player2.points
    }
}