package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var wordToGuess: String
    var guesses = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fourLetterGuess  = findViewById<TextView>(R.id.fourLetterGuess)



        val guessOneAnswer = findViewById<TextView>(R.id.guessOneAnswer)
        val guessOneAnswerCheck = findViewById<TextView>(R.id.guessOneAnswerCheck)

        val guessTwoAnswer = findViewById<TextView>(R.id.guessTwoAnswer)
        val guessTwoAnswerCheck = findViewById<TextView>(R.id.guessTwoAnswerCheck)

        val guessThreeAnswer = findViewById<TextView>(R.id.guessThreeAnswer)
        val guessThreeAnswerCheck = findViewById<TextView>(R.id.guessThreeAnswerCheck)

        val enterFourLetterGuess = findViewById<EditText>(R.id.enterFourLetterGuess)
        val submitGuess = findViewById<Button>(R.id.submitGuess)




        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }


        wordToGuess = FourLetterWordList.getRandomFourLetterWord()


        submitGuess.setOnClickListener {
            guesses++
            when (guesses) {
                1 -> {
                    guessOneAnswer.text = enterFourLetterGuess.text.toString().uppercase()
                    guessOneAnswerCheck.text = checkGuess(guessOneAnswer.text.toString())
                    enterFourLetterGuess.onEditorAction(EditorInfo.IME_ACTION_DONE)
                }
                2 -> {
                    guessTwoAnswer.text = enterFourLetterGuess.text.toString().uppercase()
                    guessTwoAnswerCheck.text = checkGuess(guessTwoAnswer.text.toString())
                    enterFourLetterGuess.onEditorAction(EditorInfo.IME_ACTION_DONE)
                }
                3 -> {
                    guessThreeAnswer.text = enterFourLetterGuess.text.toString().uppercase()
                    guessThreeAnswerCheck.text = checkGuess(guessThreeAnswer.text.toString())
                    enterFourLetterGuess.onEditorAction(EditorInfo.IME_ACTION_DONE)
                }
                else -> {
                    enterFourLetterGuess.onEditorAction(EditorInfo.IME_ACTION_DONE)
                    fourLetterGuess.text = wordToGuess
                    submitGuess.text = getString(R.string.reset_text)
                    submitGuess.isEnabled = false
                    Toast.makeText(
                        applicationContext, "You have exceeded your number of guesses",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }


        }

    }

    }








