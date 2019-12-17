package com.nlambertucci.mvvmexample.databases

class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
        private set

    companion object{
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance()= instance ?: synchronized(this){
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}