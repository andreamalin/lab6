package com.example.labo5.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.labo5.R
import com.example.labo5.viewmodels.ResultsViewModel
import com.example.labo5.databinding.FragmentResultsBinding

/**
 * A simple [Fragment] subclass.
 */
class ResultsFragment : Fragment() {
    private lateinit var binding: FragmentResultsBinding
    private lateinit var viewModelResults: ResultsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_results, container, false)
        //Next questions
        binding.buttonNewSurvey.setOnClickListener(){
            newSurvey()
        }
        viewModelResults = ViewModelProviders.of(this).get(ResultsViewModel::class.java)

        binding.resultsAverage = viewModelResults.getSurveyRating()
        binding.surveysQuantity = viewModelResults.getSurveyQuantity()

        return binding.root
    }

    private fun newSurvey(){
        view!!.findNavController().navigate(R.id.action_resultsFragment_to_nav_home)
    }


}
