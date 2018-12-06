package com.example.amir.mvvmtest.data

class QuoteRepository private  constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote)=quoteDao.addQuote(quote);
    fun getQuote()=quoteDao.getQuets();
    companion object {
        @Volatile private var instance:QuoteRepository?=null;
        fun getInstance(quoteDao: FakeQuoteDao)=
                instance?: synchronized(lock = this){
                    instance?: QuoteRepository(quoteDao).also { it }
                }
    }
}