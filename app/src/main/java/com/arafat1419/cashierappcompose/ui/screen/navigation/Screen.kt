package com.arafat1419.cashierappcompose.ui.screen.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object Transaction : Screen("transaction")
    object History : Screen("history")
    object Settings : Screen("settings")
    object SignOut : Screen("sign_out")
}