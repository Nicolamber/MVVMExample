package com.nlambertucci.mvvmexample.models

data class Quotes(val quoteText: String,val author: String){
    
    override fun toString(): String {
        return "$quoteText - $author"
    }
}