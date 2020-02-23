package com.example.labo5.viewmodels;
import android.util.Log
import androidx.lifecycle.ViewModel

class ResultsViewModel: ViewModel(){
    private var rating = 0.0
    private var quantity = 0
    private var answers = ""

    fun setRating(actualRating: Float){
        quantity ++ //New survey
        rating += actualRating //New rating value
        rating /= quantity //Average rating

        Log.i("RatingViewModel", "Rating " + actualRating)
    }
    fun getSurveyRating(): Double{
        Log.i("RatingViewModel", "Rating " + rating)
        return rating
    }
    fun getSurveyQuantity(): Int{
        return quantity
    }
}
