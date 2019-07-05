package br.com.philippesis.kmvvmexample.utilities

import br.com.philippesis.kmvvmexample.data.FakeDatabase
import br.com.philippesis.kmvvmexample.data.QuoteRepository
import br.com.philippesis.kmvvmexample.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quotaDao)
        return QuotesViewModelFactory(quoteRepository)

    }

}