package com.example.sundmadnepal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.sundmadnepal.data.Datasource

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

        val questionText = view.findViewById<TextView>(R.id.quizQuestion)

        val questionImage = view.findViewById<ImageView>(R.id.questionImage)

        val yesButton = view.findViewById<Button>(R.id.yesButton)
        val noButton = view.findViewById<Button>(R.id.noButton)
        val nextButton = view.findViewById<Button>(R.id.nextButton)

        val resultText = view.findViewById<TextView>(R.id.resultText)

        val currQuestion = questions.random()



    }
}