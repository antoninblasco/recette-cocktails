package com.lpdream.antonin.cocktails.ui.cocktails.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.lpdream.antonin.cocktails.R
import com.lpdream.antonin.cocktails.data.Cocktail
import com.lpdream.antonin.cocktails.data.CocktailRepository
import kotlinx.android.synthetic.main.activity_detail_cocktails.*

class DetailCocktailActivity : AppCompatActivity() {

    private var cocktail: Cocktail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cocktails)

        cocktail = CocktailRepository.cocktails.firstOrNull { it.id == intent.getIntExtra("id", 0) }

        setupToolbar()
        setupViews()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        title = cocktail?.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupViews() {
        cocktail?.let { cocktail ->
            description.text = cocktail.description

            ingredients.text = cocktail.ingredients
        }
    }
}
