package com.example.lunchwallet.admin.user.model

data class Users(
    val userName: String,
    val userStack: String,
    val userLocation: String
) {
    companion object {
        val listOfUsers = arrayListOf<Users>(
            Users("Nonso John", "Python", "Farapark"),
            Users("Jonaz Ikpe", "Python", "Farapark"),
            Users("Nonso John", "Python", "Farapark"),
            Users("Jonaz Ikpe", "Python", "Farapark"),
            Users("Nonso John", "Python", "Farapark"),
            Users("Jonaz Ikpe", "Python", "Farapark"),
            Users("Nonso John", "Python", "Farapark"),
            Users("Jonaz Ikpe", "Python", "Farapark"),
            Users("Nonso John", "Python", "Farapark"),
            Users("Chigozie Anyaso", "Android", "Uno_park"),
            Users("Charles Darwin", "Android", "Uno_park"),
            Users("Chigozie Anyaso ", "Android", "Uno_park"),
            Users("Charles Darwin", "Android", "Uno_park"),
            Users("Chigozie Anyaso", "Android", "Uno_park"),
            Users("Charles Darwin", "Android", "Uno_ark"),
            Users("Chigozie Anyaso", "Android", "Uno_park"),
        )
    }
}
