package com.example.labo5.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.labo5.R
import com.example.labo5.dataBase.SurveyDataBase
import com.example.labo5.databinding.FragmentSeeResultsBinding
import com.example.labo5.viewmodels.QuestionsViewModel

/**
 * A simple [Fragment] subclass.
 */
class SeeResultsFragment : Fragment() {

    private lateinit var binding: FragmentSeeResultsBinding
    private lateinit var viewModelQuestion: QuestionsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_see_results, container, false)

        //Db
        val db = SurveyDataBase(context)
        val answers = db.readAnswers()
        var text = ""
        //Gets all the parameters for survey
        for (i in 0..(answers.size-1)){
            text  += "\n" + answers.get(i)+"\n"
        }
        //Shows results on text view
        binding.surveysResults = text


        return binding.root
    }


}
