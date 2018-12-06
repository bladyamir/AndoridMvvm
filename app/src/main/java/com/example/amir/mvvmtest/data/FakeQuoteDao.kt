package com.example.amir.mvvmtest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList= mutableListOf<Quote>();
    private val qutes= MutableLiveData<List<Quote>>();

    init {
        qutes.value=quoteList;
    }

    fun addQuote(quote:Quote){
        quoteList.add(quote);
        qutes.value=quoteList;
    }

    fun getQuets()=qutes as LiveData<List<Quote>>;
}