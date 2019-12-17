package com.nlambertucci.mvvmexample.viewmodels

import androidx.lifecycle.ViewModel
import com.nlambertucci.mvvmexample.models.Quotes
import com.nlambertucci.mvvmexample.repositories.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quotes){
        quoteRepository.addQuote(quote)
    }
}