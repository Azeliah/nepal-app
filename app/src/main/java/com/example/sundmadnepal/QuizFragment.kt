package com.example.sundmadnepal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import com.example.sundmadnepal.data.Datasource
import com.example.sundmadnepal.model.QuizQuestion

class QuizFragment : Fragment() {

    private val questions = Datasource().loadQuestions()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var questionText = view.findViewById<TextView>(R.id.quizQuestion)

        val questionImage = view.findViewById<ImageView>(R.id.questionImage)

        val yesButton = view.findViewById<Button>(R.id.yesButton)
        val noButton = view.findViewById<Button>(R.id.noButton)
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        nextButton.visibility = View.INVISIBLE

        val resultText = view.findViewById<TextView>(R.id.resultText)
        resultText.visibility = View.INVISIBLE

        var currQuestion = questions.random()

        if(currQuestion.imageResourceId != null){
            questionImage.visibility = View.VISIBLE
            questionImage.setImageResource(currQuestion.imageResourceId!!)
        }
        else{
            questionImage.visibility = View.INVISIBLE
        }

        yesButton.setOnClickListener{
            resultText.visibility = View.VISIBLE
            yesButton.visibility = View.INVISIBLE
            noButton.visibility = View.INVISIBLE
            if(currQuestion.answer){
                resultText.text = "Correct"
                resultText.setTextColor(getResources().getColor(R.color.green))
            }
            else{
                resultText.text = "Wrong"
                resultText.setTextColor(getResources().getColor(R.color.red))
            }

            nextButton.visibility = View.VISIBLE
        }

        noButton.setOnClickListener{
            resultText.visibility = View.VISIBLE
            yesButton.visibility = View.INVISIBLE
            noButton.visibility = View.INVISIBLE
            if(!currQuestion.answer){
                resultText.text = "Correct"
                resultText.setTextColor(getResources().getColor(R.color.green))
            }
            else{
                resultText.text = "Wrong"
                resultText.setTextColor(getResources().getColor(R.color.red))
            }

            nextButton.visibility = View.VISIBLE
        }

        nextButton.setOnClickListener{
            resultText.visibility = View.INVISIBLE
            yesButton.visibility = View.VISIBLE
            noButton.visibility = View.VISIBLE
            nextButton.visibility = View.INVISIBLE

            currQuestion = questions.random()

            questionText.text = currQuestion.question

            if(currQuestion.imageResourceId != null){
                questionImage.visibility = View.VISIBLE
                questionImage.setImageResource(currQuestion.imageResourceId!!)
            }
            else{
                questionImage.visibility = View.INVISIBLE
            }

        }

    }
}