package ie.setu.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.recipeapp.databinding.ActivityRecipeBinding
import timber.log.Timber
import timber.log.Timber.i

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        i("Recipe Activity started..")

        binding.btnAdd.setOnClickListener() {
            val recipeTitle = binding.recipeTitle.text.toString()
            if (recipeTitle.isNotEmpty()) {
                i("add Button Pressed")
            } else {
                Snackbar
                    .make(it, "Please enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}


