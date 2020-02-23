package com.example.labo5.viewmodels;
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel: ViewModel(){
    var rating = MutableLiveData<Float>()
    var quantity = MutableLiveData<Int>()
    var answers = MutableLiveData<ArrayList<String>>()
    var answersList = ArrayList<String>()

    init {
        rating.value = 0.0F
        quantity.value = 0
        answersList.add("Default")
    }
    //Setters
    fun setRating(actualRating: Float){
        val actualRate = getSurveyRating().value!! + actualRating
        val actualQuantity = getSurveyQuantity().value!! + 1


        rating.value = actualRate
        quantity.value = actualQuantity
        answers.value = answersList
        Log.i("RatingViewModel", "Rating" + actualRate)
    }
    fun setAnswers(answer: String){
        answersList.add(answer)
    }
    //Getters
    fun getSurveyRating(): MutableLiveData<Float>{
        return rating
    }
    fun getSurveyQuantity(): MutableLiveData<Int>{
        return quantity
    }
    fun getAllResults(): MutableLiveData<ArrayList<String>>{
        return answers
    }
}
