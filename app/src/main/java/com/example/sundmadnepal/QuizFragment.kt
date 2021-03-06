package com.example.sundmadnepal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.sundmadnepal.data.loadQuestions

class QuizFragment : Fragment() {

    // Get questions for the quiz
    private var questions = loadQuestions()

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

        // Link to all the elements of the fragment
        var questionText = view.findViewById<TextView>(R.id.quizQuestion)

        val questionImage = view.findViewById<ImageView>(R.id.questionImage)

        val yesButton = view.findViewById<Button>(R.id.yesButton)
        val noButton = view.findViewById<Button>(R.id.noButton)
        val nextButton = view.findViewById<Button>(R.id.nextButton)

        val resultText = view.findViewById<TextView>(R.id.resultText)

        // Make nextButton and resultText invisible
        resultText.visibility = View.INVISIBLE
        nextButton.visibility = View.INVISIBLE

        // Set the current questions text
        var currQuestion = questions.random()

        questions.remove(currQuestion)

        // Set the text of the first question
        questionText.text = view.context.getString(currQuestion.question)

        // Set the image for the question, if it has an image
        if (currQuestion.imageResourceId != null) {
            questionImage.visibility = View.VISIBLE
            questionImage.setImageResource(currQuestion.imageResourceId!!)
        } else {
            questionImage.visibility = View.INVISIBLE
        }

        // Add functionality to the yesButton
        yesButton.setOnClickListener {

            resultText.visibility = View.VISIBLE
            yesButton.visibility = View.INVISIBLE
            noButton.visibility = View.INVISIBLE

            // Check if the answer is correct, and set the text and color of the resultText
            if (currQuestion.answer) {
                resultText.text = resources.getText(R.string.correct)
                resultText.setTextColor(resources.getColor(R.color.green))
            } else {
                resultText.text = resources.getText(R.string.wrong)
                resultText.setTextColor(resources.getColor(R.color.red))
            }

            nextButton.visibility = View.VISIBLE
        }

        // Check if the answer is correct, and set the text and color of the resultText
        noButton.setOnClickListener {
            resultText.visibility = View.VISIBLE
            yesButton.visibility = View.INVISIBLE
            noButton.visibility = View.INVISIBLE
            if (!currQuestion.answer) {
                resultText.text = resources.getText(R.string.correct)
                resultText.setTextColor(resources.getColor(R.color.green))
            } else {
                resultText.text = resources.getText(R.string.wrong)
                resultText.setTextColor(resources.getColor(R.color.red))
            }

            nextButton.visibility = View.VISIBLE
        }

        // Add functionality to the nextButton
        nextButton.setOnClickListener {
            resultText.visibility = View.INVISIBLE
            nextButton.visibility = View.INVISIBLE
            yesButton.visibility = View.VISIBLE
            noButton.visibility = View.VISIBLE

            // Pick a new random question
            if (questions.count() > 0) {
                currQuestion = questions.random()
            } else {
                questions = loadQuestions()
                currQuestion = questions.random()
            }

            questions.remove(currQuestion)

            // Update the question text and image
            questionText.text = view.context.getString(currQuestion.question)

            if (currQuestion.imageResourceId != null) {
                questionImage.visibility = View.VISIBLE
                questionImage.setImageResource(currQuestion.imageResourceId!!)
            } else {
                questionImage.visibility = View.INVISIBLE
            }
        }
    }
}
