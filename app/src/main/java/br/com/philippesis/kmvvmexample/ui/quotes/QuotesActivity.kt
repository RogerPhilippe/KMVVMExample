package br.com.philippesis.kmvvmexample.ui.quotes

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.philippesis.kmvvmexample.R
import br.com.philippesis.kmvvmexample.data.Quote
import br.com.philippesis.kmvvmexample.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        setupUI()
    }

    private fun setupUI() {

        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

    }

}
