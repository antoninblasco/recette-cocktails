package com.lpdream.antonin.cocktails.ui.cocktails.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.lpdream.antonin.cocktails.R
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.lpdream.antonin.cocktails.data.CocktailRepository
import com.lpdream.antonin.cocktails.data.Cocktail

class CreateCocktailActivity : AppCompatActivity() {

    private var cocktail = Cocktail()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_cocktail)

        setupToolbar()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_create_cocktail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> {
            ActivityCompat.finishAfterTransition(this)
            true
        }
        R.id.confirm -> {
            CocktailRepository.cocktails.add(cocktail)
            ActivityCompat.finishAfterTransition(this)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
