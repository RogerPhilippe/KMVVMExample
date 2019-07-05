package br.com.philippesis.kmvvmexample.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    // A fake database tabel
    private val quotaList = mutableListOf<Quote>()
    // Live data
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        quotes.value = quotaList
    }

    fun addQuote(quote: Quote) {
        quotaList.add(quote)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        quotes.value = quotaList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuotes() = quotes as LiveData<List<Quote>>

}