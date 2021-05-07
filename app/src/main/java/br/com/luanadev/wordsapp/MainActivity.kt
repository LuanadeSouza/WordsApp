package br.com.luanadev.wordsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.luanadev.wordsapp.databinding.ActivityMainBinding
import by.kirich1409.viewbindingdelegate.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        chooseLayout()
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            binding.recyclerViewWord.layoutManager = LinearLayoutManager(this)
        } else {
            binding.recyclerViewWord.layoutManager = GridLayoutManager(this, 4)
        }
        binding.recyclerViewWord.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
