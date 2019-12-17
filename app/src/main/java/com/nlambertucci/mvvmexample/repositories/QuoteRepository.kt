package com.nlambertucci.mvvmexample.repositories

import com.nlambertucci.mvvmexample.databases.FakeQuoteDao
import com.nlambertucci.mvvmexample.models.Quotes

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(quotes: Quotes){
        quoteDao.addQuote(quotes)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao)= instance ?: synchronized(this){
            instance ?: QuoteRepository(quoteDao).also { instance = it }
        }
    }
}