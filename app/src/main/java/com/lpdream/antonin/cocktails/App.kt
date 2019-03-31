package com.lpdream.antonin.cocktails

import android.app.Application
import com.lpdream.antonin.cocktails.data.Cocktail
import com.lpdream.antonin.cocktails.data.CocktailRepository

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val cocktails = listOf(
            Cocktail(id = 1, title = "Mojito", description = "Cocktail célèbre au citron et a la menthe", ingredients = "Menthe, Citron, Eau pétillante, Rhum"),
            Cocktail(id = 2, title = "Jack miel coca", description = "Cocktail préféré de Jul", ingredients = "Jack Daniel's Honey, Coca Cola")
        )
        CocktailRepository.cocktails.addAll(cocktails)
    }
}
