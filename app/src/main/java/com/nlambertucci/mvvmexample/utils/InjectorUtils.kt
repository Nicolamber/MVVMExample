package com.nlambertucci.mvvmexample.utils

import com.nlambertucci.mvvmexample.databases.FakeDatabase
import com.nlambertucci.mvvmexample.repositories.QuoteRepository
import com.nlambertucci.mvvmexample.viewmodels.QuotesViewModelFactory

object InjectorUtils {

    /**
     * All of the dependencies for the view model factory are created right inside this line, so
     * if you want to change something or if you want to change the implementation you can do all of that
     * from this single function provideQuotesViewModelFactory()
     */
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}