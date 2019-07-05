package br.com.philippesis.kmvvmexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.philippesis.kmvvmexample.ui.quotes.QuotesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, QuotesActivity::class.java)
        startActivity(intent)
    }
}
