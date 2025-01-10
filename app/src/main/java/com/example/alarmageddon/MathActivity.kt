package com.example.alarmageddon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MathActivity : AppCompatActivity() {

    private var correctAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        val questionText = findViewById<TextView>(R.id.questionText)
        val answerInput = findViewById<EditText>(R.id.answerInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        generateQuestion(questionText)

        submitButton.setOnClickListener {
            val userAnswer = answerInput.text.toString().toIntOrNull()
            if (userAnswer == correctAnswer) {
                Toast.makeText(this, "Richtig! Alarm deaktiviert.", Toast.LENGTH_SHORT).show()
                finish() // Beendet die Aktivität
            } else {
                Toast.makeText(this, "Falsch! Versuche es erneut.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun generateQuestion(questionText: TextView) {
        val num1 = (1..10).random()
        val num2 = (1..10).random()
        correctAnswer = num1 + num2
        questionText.text = "Was ist $num1 + $num2?"
    }
}

