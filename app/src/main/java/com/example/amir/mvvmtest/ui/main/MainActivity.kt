package com.example.amir.mvvmtest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.amir.mvvmtest.R
import com.example.amir.mvvmtest.data.Quote
import com.example.amir.mvvmtest.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUI();
    }

    private fun initializeUI() {
        val factory=InjectorUtils.provideViewModelFactory();
        val viewModel=ViewModelProviders.of(this,factory)
            .get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes->
            val stringBuillder=StringBuilder()
            quotes.forEach { quote->
                stringBuillder.append("$quote\n\n")
            }
            textView_quotes.text=stringBuillder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote=Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
