package com.nlambertucci.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nlambertucci.mvvmexample.R
import com.nlambertucci.mvvmexample.models.Quotes
import com.nlambertucci.mvvmexample.utils.InjectorUtils
import com.nlambertucci.mvvmexample.viewmodels.QuotesViewModel
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI()
    }

    private fun initializeUI(){
        /**
         * Here all of the dependencies will be created
         */
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)

        /**
         * Here we are going to observe the LiveData from the ViewModel
         */
        viewModel.getQuotes().observe(this, Observer{ quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text= stringBuilder.toString()
        })

        button_add_quote.setOnClickListener{
            val quote = Quotes(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
