package br.com.luanadev.wordsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        initRecyclerDetail()
    }

    private fun initRecyclerDetail() {
        val letterId = "A"
        binding.recyclerViewDetail.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDetail.adapter = WordAdapter(letterId, this)
    }
}