package ie.setu.recipeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.setu.recipeapp.models.RecipeModel
import ie.setu.recipeapp.databinding.CardRecipeBinding


class RecipeAdapter constructor(private var recipes: List<RecipeModel>) :
    RecyclerView.Adapter<RecipeAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardRecipeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val recipe = recipes[holder.adapterPosition]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

    class MainHolder(private val binding : CardRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: RecipeModel) {
            binding.recipeTitle.text = recipe.title
            binding.recipeDescription.text = recipe.description
        }
    }
}