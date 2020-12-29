package com.mertdurkaya.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.Button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        Toast.makeText(this, "Dice Rolled !", Toast.LENGTH_SHORT).show()
        val resultTextView: TextView = findViewById(R.id.textView)
        val myFirstDice = Dice(6)
        val rolledDiceNumber = myFirstDice.roll()
        if (rolledDiceNumber>4) Toast.makeText(this, "İyisin !", Toast.LENGTH_SHORT).show()
        resultTextView.text = rolledDiceNumber.toString()
        
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (rolledDiceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rolledDiceNumber.toString()
    }
}