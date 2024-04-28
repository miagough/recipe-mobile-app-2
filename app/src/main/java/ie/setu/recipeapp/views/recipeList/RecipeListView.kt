package ie.setu.recipeapp.views.recipeList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import ie.setu.recipeapp.R
import ie.setu.recipeapp.adapters.RecipeAdapter
import ie.setu.recipeapp.adapters.RecipeListener
import ie.setu.recipeapp.databinding.ActivityRecipeListBinding
import ie.setu.recipeapp.main.MainApp
import ie.setu.recipeapp.models.RecipeModel
import ie.setu.recipeapp.views.recipeList.RecipeListPresenter

class RecipeListView : AppCompatActivity(), RecipeListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityRecipeListBinding
    lateinit var presenter: RecipeListPresenter
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar.title = title
        setSupportActionBar(binding.topAppBar)
        presenter = RecipeListPresenter(this)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        loadRecipes()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> { presenter.doAddRecipe() }
            R.id.item_map -> { presenter.doShowRecipesMap() }
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onRecipeClick(recipe: RecipeModel, position: Int) {
        this.position = position
        presenter.doEditRecipe(recipe, this.position)
    }

    private fun loadRecipes() {
        binding.recyclerView.adapter = RecipeAdapter(presenter.getRecipes(), this)
        onRefresh()
    }

    fun onRefresh() {
        val recipeAdapter = binding.recyclerView.adapter as RecipeAdapter
        // if the recipes in the store have been updated, refresh the adapter
        recipeAdapter.updateItems(presenter.getRecipes())
    }

    fun onDelete(position : Int) {
        binding.recyclerView.adapter?.notifyItemRemoved(position)
    }
}




