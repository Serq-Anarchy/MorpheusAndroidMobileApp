package ru.sedooj.morpheus.navigation

import ru.sedooj.morpheus.R

enum class Screens(val route: String, val pageName: String, val icon: Int) {

    MAIN_PAGE("MAIN_PAGE", "Главная", icon = R.drawable.home),
    ACCOUNT_PAGE("ACCOUNT_PAGE", "Аккаунт", icon = R.drawable.person)

}