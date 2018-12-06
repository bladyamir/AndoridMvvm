package com.example.amir.mvvmtest.utils

import com.example.amir.mvvmtest.data.FakeDataBase
import com.example.amir.mvvmtest.data.QuoteRepository
import com.example.amir.mvvmtest.ui.main.ViewModelFactory

object InjectorUtils {
    fun provideViewModelFactory():ViewModelFactory{
        val fakeQuoteDao=FakeDataBase.getInstance().quoteDao;
        val quoteRepository=QuoteRepository.getInstance(fakeQuoteDao);
        return ViewModelFactory(quoteRepository);
    }
}