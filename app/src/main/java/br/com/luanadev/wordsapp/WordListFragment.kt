package br.com.luanadev.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.luanadev.wordsapp.databinding.FragmentWordListBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class WordListFragment : Fragment() {

    private lateinit var letterId: String
    private val binding by viewBinding {
        FragmentWordListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerViewWord.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewWord.adapter = WordAdapter(letterId, requireContext())
        binding.recyclerViewWord.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

}

