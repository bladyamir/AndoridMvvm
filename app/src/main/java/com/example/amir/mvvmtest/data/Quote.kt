package com.example.amir.mvvmtest.data

data class Quote(val quote:String,
                 var author: String) {
    override fun toString(): String {
        return "$quote-$author"
    }
}