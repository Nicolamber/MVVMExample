package com.nlambertucci.mvvmexample.databases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nlambertucci.mvvmexample.models.Quotes

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quotes>()

    // we will observe this quotes from repository
    private val quotes = MutableLiveData<List<Quotes>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quotes){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quotes>>
}