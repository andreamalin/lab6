package com.example.labo5.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


class QuestionsViewModel: ViewModel()  {
    // The list of words - the front of the list is the next word to guess
    private var addedQuestions = ArrayList<String>()
    private var questionsList = ArrayList<String>()

    fun defaultQuestions(){
        questionsList.add("¿Tiene algún comentario o sugerencia?")
        questionsList.add("¿Qué le pareció nuestro servicio?")
        /*
        for (question in addedQuestions){
            questionsList.add(question)
        }
        */
        Log.i("QuestionsViewModel", "List created!")
    }

    //Moves to the next question in the list
    fun nextQuestion(): String {
        var question = ""
        //Select and remove a word from the list
        if (questionsList.isNotEmpty()) {
            question = questionsList.removeAt(0)
        }
        return question
    }
    //Add question
    fun addQuestion(newQuestion: String) {
        addedQuestions.add(newQuestion)

        Log.i("QuestionsViewModel", "Question created!")
    }
    //Returns question list
    fun getQuestionList(): ArrayList<String>{

        return questionsList
    }

}