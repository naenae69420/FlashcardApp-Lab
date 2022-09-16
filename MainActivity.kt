package com.example.flashcardnewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.flashcard_question).setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.INVISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.VISIBLE
        }
        findViewById<View>(R.id.flashcard_answer).setOnClickListener {
            findViewById<View>(R.id.flashcard_question).visibility = View.VISIBLE
            findViewById<View>(R.id.flashcard_answer).visibility = View.INVISIBLE
        }
        findViewById<View>(R.id.flashcard_answertwo).setOnClickListener {
            findViewById<View>(R.id.flashcard_answertwo).setBackgroundColor(getResources().getColor(R.color.my_red_color, null))
        }
        findViewById<View>(R.id.flashcard_answerthree).setOnClickListener {
            findViewById<View>(R.id.flashcard_answerthree).setBackgroundColor(getResources().getColor(R.color.my_red_color, null))
        }
        findViewById<View>(R.id.flashcard_answerfour).setOnClickListener {
            findViewById<View>(R.id.flashcard_answerfour).setBackgroundColor(getResources().getColor(R.color.my_green_color, null))
        }






    }
}