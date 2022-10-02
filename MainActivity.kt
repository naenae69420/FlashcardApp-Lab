package com.example.flashcardnewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)

        flashcardQuestion.setOnClickListener {
            flashcardAnswer.visibility = View.VISIBLE
            flashcardQuestion.visibility = View.INVISIBLE
        }
        flashcardAnswer.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility = View.VISIBLE
        }

        findViewById<View>(R.id.flashcard_answertwo).setOnClickListener {
            findViewById<View>(R.id.flashcard_answertwo).setBackgroundColor(
                getResources().getColor(
                    R.color.my_red_color,
                    null
                )
            )
        }
        findViewById<View>(R.id.flashcard_answerthree).setOnClickListener {
            findViewById<View>(R.id.flashcard_answerthree).setBackgroundColor(
                getResources().getColor(
                    R.color.my_red_color,
                    null
                )
            )
        }
        findViewById<View>(R.id.flashcard_answerfour).setOnClickListener {
            findViewById<View>(R.id.flashcard_answerfour).setBackgroundColor(
                getResources().getColor(
                    R.color.my_green_color,
                    null
                )
            )
        }

        findViewById<View>(R.id.add_question_button).setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            startActivity(intent)
        }

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

                val data: Intent? = result.data
                if (data != null) {
                    val questionString = data.getStringExtra("QUESTION_KEY")
                    val answerString = data.getStringExtra("ANSWER_KEY")

                    flashcardQuestion.text = questionString
                    flashcardAnswer.text = answerString

                    Log.i("MainActivity", "question: $questionString")
                    Log.i("=MainActivity", "answer: $answerString")
                } else {
                    Log.i("=MainActivity", "Returned null data from AddCardActivity")
                }
            }

        val addQuestionButton = findViewById<ImageView>(R.id.add_question_button)
        addQuestionButton.setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)
        }


    }
}