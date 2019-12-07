package com.example.rollgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1 : ImageView
    lateinit var diceImage2 : ImageView
    var countClick :Int = 0

    var player1:Int = 0
    var player2:Int = 0

    lateinit var winScore:EditText
    val score = winScore.toString().toInt()

    lateinit var winner : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }
        diceImage1 = findViewById(R.id.image1)
        diceImage2 = findViewById(R.id.image2)

        winScore = findViewById(R.id.winScore)
        winner = findViewById(R.id.winner)

    }

    private fun rollDice() {
        val randomInt1 = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1

        val drawableResource1 = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)

        countClick++
        if(countClick %2 == 1)
            player1 += randomInt1+randomInt2
        else player2 += randomInt1+randomInt2

        if(player1 >= score)
            winner.setText("Player1 won!")
        if(player2 >= score)
            winner.setText("Player2 won!")
    }
}
