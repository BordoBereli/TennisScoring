package tr.com.kutluoglu.tennisgame

import io.kotest.core.spec.style.stringSpec
import io.kotest.matchers.shouldBe
import tr.com.kutluoglu.tennisgame.tennis.GameScore
import tr.com.kutluoglu.tennisgame.tennis.TennisGame
import tr.com.kutluoglu.tennisgame.tennis.TennisPlayer

/**
 * Created by F.K. on 13.09.2022.
 *
 */

fun gameScoreTest() = stringSpec {
    lateinit var gameScore: GameScore
    lateinit var game: TennisGame
    lateinit var player1: TennisPlayer
    lateinit var player2: TennisPlayer
    beforeTest {
        println("Before every spec/test case")
        player1 = TennisPlayer(0)
        player2 = TennisPlayer(0)
        game = TennisGame(player1, player2)
        gameScore = GameScore()
    }

    "should GameScore.show() return love-love when player points are 0" {
        gameScore.show(game) shouldBe "love-love"
    }

    "should GameScore.show() return 15-love when player1 score 1 point" {
        game.updatePlayer1ScoreBy()
        gameScore.show(game) shouldBe "15-love"
    }

    "should GameScore.show() return 30-love when player1 score 2 points" {
        game.updatePlayer1ScoreBy(2)
        gameScore.show(game) shouldBe "30-love"
    }

    "should GameScore.show() return 40-love when player1 score 3 points" {
        game.updatePlayer1ScoreBy(3)
        gameScore.show(game) shouldBe "40-love"
    }

    "should GameScore.show() return love-15 when player2 score 1 point" {
        game.updatePlayer2ScoreBy()
        gameScore.show(game) shouldBe "love-15"
    }

    "should GameScore.show() return love-30 when player2 score 2 points" {
        game.updatePlayer2ScoreBy(2)
        gameScore.show(game) shouldBe "love-30"
    }

    "should GameScore.show() return love-40 when player2 score 3 points" {
        game.updatePlayer2ScoreBy(3)
        gameScore.show(game) shouldBe "love-40"
    }

    "should GameScore.show() return 40-30 when player1 score 3 points and player2 score 2 points" {
        game.updatePlayer1ScoreBy(3)
        game.updatePlayer2ScoreBy(2)
        gameScore.show(game) shouldBe "40-30"
    }

    "should GameScore.show() return 'deuce' when players score 3 points and above and points are equal" {
        game.updatePlayer1ScoreBy(4)
        game.updatePlayer2ScoreBy(4)
        gameScore.show(game) shouldBe "deuce"
    }

    "should GameScore.show() return 'advantage' when any player scores more than 3 points and one has one point lead" {
        game.updatePlayer1ScoreBy(6)
        game.updatePlayer2ScoreBy(5)
        gameScore.show(game) shouldBe "advantage"
    }

    "should GameScore.show() return Player1 won when player1 have 4 or more points and has more than 2 points differ" {
        game.updatePlayer1ScoreBy(6)
        game.updatePlayer2ScoreBy(4)
        gameScore.show(game) shouldBe "Player1 won"
    }

    "should GameScore.show() return Player2 won when player2 have 4 or more points and has more than 2 points differ" {
        game.updatePlayer1ScoreBy(2)
        game.updatePlayer2ScoreBy(4)
        gameScore.show(game) shouldBe "Player2 won"
    }
}