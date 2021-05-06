package br.com.luanadev.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.luanadev.wordsapp.databinding.ActivityMainBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecyclerWord()
    }

    private fun initRecyclerWord() {
        binding.recyclerViewWord.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewWord.adapter = LetterAdapter()
    }
}