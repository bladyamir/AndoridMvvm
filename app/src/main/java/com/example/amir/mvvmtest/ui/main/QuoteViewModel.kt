package com.example.amir.mvvmtest.ui.main

import androidx.lifecycle.ViewModel
import com.example.amir.mvvmtest.data.Quote
import com.example.amir.mvvmtest.data.QuoteRepository

class QuoteViewModel (private val quoteRepository: QuoteRepository)
    : ViewModel() {
    fun getQuotes()=quoteRepository.getQuote()

    fun addQuotes(quote: Quote)=quoteRepository.addQuote(quote)
}