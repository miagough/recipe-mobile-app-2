package ie.setu.recipeapp.main

import android.app.Application
import android.os.Bundle
import ie.setu.recipeapp.models.RecipeJSONStore
import ie.setu.recipeapp.models.RecipeMemStore
import ie.setu.recipeapp.models.RecipeModel
import ie.setu.recipeapp.models.RecipeSQLStore
import ie.setu.recipeapp.models.RecipeStore
import timber.log.Timber
import timber.log.Timber.i
class MainApp : Application() {

    lateinit var recipes: RecipeStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        recipes = RecipeSQLStore(applicationContext)  //SQLite approach
        i("Recipe started")
    }

}