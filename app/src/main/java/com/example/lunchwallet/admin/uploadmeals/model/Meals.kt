package com.example.lunchwallet.admin.uploadmeals.model
import androidx.annotation.DrawableRes
data class Meals(
    @DrawableRes val image: Int,
    val name: String,
    val timeServing: String,
    val kitchen: String,
) {
    companion object {
        val listOfMeals = arrayListOf<Meals>(
//            Meals(R.drawable.chicken, "Jollof rice & chicken", "12.15PM (Brunch)", "Uno kitchen"),
//            Meals(R.drawable.jellofrice, "Rice & egg sauce", "12.15PM (Brunch)", "Fara park kitchen"),
//            Meals(R.drawable.egusi_soup, "Egusi soup & semo", "12.15PM (Dinner)", "Uno kitchen"),
//            Meals(R.drawable.eforiro, "Efo riro & semo", "12.15PM (Dinner)", "Fara park kitchen")
        )
    }
}
