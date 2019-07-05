package br.com.philippesis.kmvvmexample.ui.quotes

import androidx.lifecycle.ViewModel
import br.com.philippesis.kmvvmexample.data.Quote
import br.com.philippesis.kmvvmexample.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)

}