package com.example.labo5.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


class QuestionsViewModel: ViewModel()  {
    // The current word
    var word = ""

    // The list of words - the front of the list is the next word to guess
    private var defaultQuestions = MutableLiveData<String>()
    private var questionsList = ArrayList<String>()



    fun defaultQuestions(){
        questionsList.add("¿Tiene algún comentario o sugerencia?")
        questionsList.add("¿Qué le pareció nuestro servicio?")


        Log.i("QuestionsViewModel", "List created!")
    }

    //Moves to the next question in the list
    fun nextQuestion() {
        //Select and remove a word from the list
        if (questionsList.isNotEmpty()) {
            word = questionsList.removeAt(0)
        }
    }

    //Add question
    fun addQuestion(newQuestion: String) {
        questionsList.add(newQuestion)

        Log.i("QuestionsViewModel", "Question created!")
    }

    fun getQuestionList(): LiveData<String>{
        defaultQuestions()
        return defaultQuestions
    }



}