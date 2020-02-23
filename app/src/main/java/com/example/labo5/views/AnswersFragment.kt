package com.example.labo5.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.ViewModelProviders
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.labo5.viewmodels.QuestionsViewModel
import com.example.labo5.R
import com.example.labo5.viewmodels.ResultsViewModel
import com.example.labo5.databinding.FragmentAnswersBinding


class AnswersFragment : Fragment() {
    private lateinit var binding: FragmentAnswersBinding
    private lateinit var viewModel: QuestionsViewModel
    private lateinit var viewModelResults: ResultsViewModel
    private var showResults = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_answers, container, false
        )

        binding.ratingBar.setVisibility(View.GONE)

        // Get the viewModel
        viewModel = ViewModelProviders.of(this).get(QuestionsViewModel::class.java)
        viewModelResults = ViewModelProviders.of(this).get(ResultsViewModel::class.java)

        //Keyboard
        getActivity()?.getWindow()
            ?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        updateQuestion()
        val questionsList = viewModel.getQuestionList()

        //Next questions
        binding.buttonNextQuestion.setOnClickListener {
            updateQuestion()

            if (showResults) {
                viewModelResults.setRating(binding.ratingBar.rating)

                Log.i("RatingAnswersFragment", "Rating" + binding.ratingBar.rating)
                view!!.findNavController().navigate(R.id.action_answersFragment_to_resultsFragment)

            } else if (questionsList.isEmpty()) { //Shows rating
                showResults = true
                binding.editTextAnswer.setVisibility(View.GONE)
                binding.ratingBar.setVisibility(View.VISIBLE)
            } else {
                viewModel.nextQuestion()
            }
        }
        return binding.root
    }

    private fun updateQuestion() {
        binding.textViewQuestion.text = viewModel.word

    }


}
