package br.com.luanadev.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.luanadev.wordsapp.databinding.ActivityDetailBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class DetailActivity : AppCompatActivity() {

    private val binding by viewBinding {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val letterId = intent?.extras?.getString(LETTER).toString()
        binding.recyclerViewDetail.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDetail.adapter = WordAdapter(letterId, this)
        binding.recyclerViewDetail.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        title = getString(R.string.detail_prefix) + " " + letterId
    }

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}