package com.lpdream.antonin.cocktails.data

import java.util.*

data class Cocktail(

    var id: Int = CocktailRepository.cocktails.size + 1,

    var title: String = "Sans titre",

    var description: String = "Lorem Ipsum",

    var ingredients: String = "Lorem, Ipsum, Lorem"

)