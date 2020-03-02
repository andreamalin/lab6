package com.example.labo5.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity class for poll table
@Entity(tableName = "answer_table")
class Answer{
    //Allows android to manage IDs
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "poll_id")
    var poll_id: Int = 0 //Poll id

    @ColumnInfo(name = "question_id")
    var question_id: Int = 0 //Question id

    @ColumnInfo(name = "answer_text")
    var answer_text: String = "" //Answer for strings

    @ColumnInfo(name = "answer_number")
    var answer_number: Float = 0.0f //Answer for rating/numbers

    @ColumnInfo(name = "questions_answered")
    var question: String = "" //Question answered

    //For String questions
    constructor(poll_id:Int, question_id: Int, text:String) {
        this.poll_id = poll_id
        this.question_id = question_id
        this.answer_text = text
    }
    //For int questions
    constructor(poll_id:Int, question_id: Int, number:Float) {
        this.poll_id = poll_id
        this.question_id = question_id
        this.answer_number = number
    }
}

