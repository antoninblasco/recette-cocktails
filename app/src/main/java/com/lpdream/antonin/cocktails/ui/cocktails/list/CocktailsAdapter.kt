package com.lpdream.antonin.cocktails.ui.cocktails.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lpdream.antonin.cocktails.R
import com.lpdream.antonin.cocktails.data.Cocktail
import kotlinx.android.synthetic.main.item_cocktail.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class CocktailsAdapter: RecyclerView.Adapter<CocktailsAdapter.MovieViewHolder>() {

    var onClick: ((item: Cocktail) -> Unit)? = null
    var onLongClick: ((item: Cocktail) -> Unit)? = null

    private var data = listOf<Cocktail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cocktail,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(data[position], object:
            OnCocktailClickListener {
            override fun onItemClick(cocktail: Cocktail) {
                onClick?.invoke(cocktail)
            }

            override fun onItemLongClick(cocktail: Cocktail) {
                onLongClick?.invoke(cocktail)
            }
        })
    }

    fun replaceData(newData: List<Cocktail>) {
        this.data = newData
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(cocktail: Cocktail, onCocktailClickListener: OnCocktailClickListener) {
            itemView.title.text = cocktail.title
            itemView.description.text = cocktail.description
        }
    }

    interface OnCocktailClickListener {

        fun onItemClick(cocktail: Cocktail)

        fun onItemLongClick(cocktail: Cocktail)

    }
}