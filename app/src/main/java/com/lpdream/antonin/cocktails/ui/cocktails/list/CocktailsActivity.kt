package com.lpdream.antonin.cocktails.ui.cocktails.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lpdream.antonin.cocktails.R
import com.lpdream.antonin.cocktails.data.Cocktail
import com.lpdream.antonin.cocktails.data.CocktailRepository
import com.lpdream.antonin.cocktails.extension.startAnimatedActivity
import com.lpdream.antonin.cocktails.ui.cocktails.create.CreateCocktailActivity
import com.lpdream.antonin.cocktails.ui.cocktails.detail.DetailCocktailActivity
import kotlinx.android.synthetic.main.activity_cocktails.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noButton
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.yesButton

class CocktailsActivity : AppCompatActivity() {

    private var cocktailsAdapter = CocktailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktails)

        setupAdapter()
        setupFab()
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        cocktailsAdapter.replaceData(CocktailRepository.cocktails.sortedBy { it.title })
    }

    private fun setupAdapter() {
        cocktailsAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<DetailCocktailActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    private fun setupFab() {
        fab.onClick { startAnimatedActivity(intentFor<CreateCocktailActivity>()) }
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@CocktailsActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@CocktailsActivity)
            adapter = cocktailsAdapter
        }
    }

    private fun showDeletePopup(cocktail: Cocktail) {
        alert("Voulez vous vraiment supprimer ce cocktail ?") {
            yesButton {
                CocktailRepository.cocktails.remove(cocktail)
                cocktailsAdapter.replaceData(CocktailRepository.cocktails.sortedBy { it.title })
            }
            noButton { }
        }.show()
    }
}
