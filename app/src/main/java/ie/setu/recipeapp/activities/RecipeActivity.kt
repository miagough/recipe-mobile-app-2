package ie.setu.recipeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.recipeapp.activities.models.RecipeModel
import ie.setu.recipeapp.databinding.ActivityRecipeBinding
import timber.log.Timber
import timber.log.Timber.i

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding
    var recipe = RecipeModel()
    val recipes = ArrayList<RecipeModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        i("Recipe Activity started...")

        binding.btnAdd.setOnClickListener() {
            recipe.title = binding.recipeTitle.text.toString()
            recipe.description = binding.recipeDescription.text.toString()
            if (recipe.title.isNotEmpty()) {
                recipes.add(recipe.copy())
                i("add Button Pressed: ${recipe}")
                for (i in recipes.indices)
                { i("Recipe[$i]:${this.recipes[i]}") }
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}


