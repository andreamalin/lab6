package com.example.labo5.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.labo5.viewmodels.QuestionsViewModel
import com.example.labo5.R
import com.example.labo5.viewmodels.ResultsViewModel
import com.example.labo5.databinding.FragmentAnswersBinding
import kotlinx.android.synthetic.main.fragment_answers.*


class AnswersFragment : Fragment() {
    private lateinit var binding: FragmentAnswersBinding
    private lateinit var viewModel: QuestionsViewModel
    private lateinit var viewModelResults: ResultsViewModel
    private var showResults = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_answers, container, false)
        binding.ratingBar.setVisibility(View.GONE)

        // Get the viewModel
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        viewModelResults = activity.let {
            ViewModelProvider(this).get(ResultsViewModel::class.java)
        }
        viewModel.defaultQuestions()

        //Keyboard
        getActivity()?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)


        val questionsList = viewModel.getQuestionList() //Get questions
        updateQuestion()

        //Next questions
        binding.buttonNextQuestion.setOnClickListener {

            if (showResults) {
                viewModelResults.setRating(binding.ratingBar.rating)

                Log.i("RatingAnswersFragment", "Rating" + binding.ratingBar.rating)
                view!!.findNavController().navigate(R.id.action_answersFragment_to_resultsFragment)

            } else if (questionsList.size == 1) { //Shows rating
                showResults = true
                binding.editTextAnswer.setVisibility(View.GONE)
                binding.ratingBar.setVisibility(View.VISIBLE)
            } else {
                updateQuestion()
            }
            getAnswer()
        }
        return binding.root
    }
    //Update questions
    private fun updateQuestion() {
        binding.question = viewModel.nextQuestion()
    }
    //Get answers
    private fun getAnswer(){
        viewModelResults = ViewModelProvider(this).get(ResultsViewModel::class.java)
        //Get answer from edit text
        val lastAnswer = editTextAnswer.getText().toString()

        viewModelResults.setAnswers(lastAnswer)

        editTextAnswer.getText().clear()
    }


}
