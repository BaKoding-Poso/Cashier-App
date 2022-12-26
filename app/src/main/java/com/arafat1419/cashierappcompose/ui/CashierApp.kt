package com.arafat1419.cashierappcompose.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.screen.dashboard.DashboardScreen
import com.arafat1419.cashierappcompose.ui.screen.history.HistoryScreen
import com.arafat1419.cashierappcompose.ui.screen.navigation.NavigationItem
import com.arafat1419.cashierappcompose.ui.screen.navigation.Screen
import com.arafat1419.cashierappcompose.ui.screen.settings.SettingsScreen
import com.arafat1419.cashierappcompose.ui.screen.transaction.TransactionScreen
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun CashierApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) {

    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        Row(modifier = modifier) {
            AnimatedVisibility(
                visible = true,
                modifier = modifier
            ) {
                CashierNavigationRail(
                    navController = navController,
                    onSignOutClicked = {
                        Toast.makeText(context, R.string.sign_out, Toast.LENGTH_SHORT).show()
                    },
                )
            }
            NavHost(
                navController = navController,
                startDestination = Screen.Dashboard.route,
                modifier = modifier
                    .padding(innerPadding)
                    .background(colorResource(id = R.color.white_background))
            ) {
                composable(Screen.Dashboard.route) {
                    DashboardScreen()
                }
                composable(Screen.Transaction.route) {
                    TransactionScreen()
                }
                composable(Screen.History.route) {
                    HistoryScreen()
                }
                composable(Screen.Settings.route) {
                    SettingsScreen()
                }
            }
        }
    }
}

@Composable
fun CashierNavigationRail(
    navController: NavController,
    modifier: Modifier = Modifier,
    onSignOutClicked: () -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = stringResource(R.string.dashboard),
            icon = Icons.Outlined.Dashboard,
            screen = Screen.Dashboard,
            position = 0,
        ),
        NavigationItem(
            title = stringResource(R.string.transaction),
            icon = Icons.Outlined.PointOfSale,
            screen = Screen.Transaction,
            position = 0,
        ),
        NavigationItem(
            title = stringResource(R.string.history),
            icon = Icons.Outlined.History,
            screen = Screen.History,
            position = 0,
        ),
        NavigationItem(
            title = stringResource(R.string.settings),
            icon = Icons.Outlined.Settings,
            screen = Screen.Settings,
            position = 1,
        ),
        NavigationItem(
            title = stringResource(R.string.sign_out),
            icon = Icons.Outlined.ExitToApp,
            screen = null,
            position = 1,
        ),
    )

    NavigationRail(
        header = {
            Card(
                modifier = modifier
                    .size(64.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

            }
        },
        containerColor = colorResource(id = R.color.white),
        modifier = modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
            .padding(top = 16.dp, end = 8.dp, bottom = 16.dp, start = 8.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 32.dp))

        val navigationRailItemColors = NavigationRailItemDefaults.colors(
            selectedIconColor = colorResource(id = R.color.white),
            selectedTextColor = colorResource(id = R.color.white),
            indicatorColor = colorResource(id = R.color.orange_500),
            unselectedIconColor = colorResource(id = R.color.dark_gray),
            unselectedTextColor = colorResource(id = R.color.dark_gray)
        )

        navigationItems
            .sortedBy { it.position }
            .mapIndexed { index, item ->
                if (index > 0 && navigationItems[index].position != navigationItems[index - 1].position) {
                    Spacer(modifier = Modifier.weight(1f))
                }

                NavigationRailItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                        )
                    },
                    alwaysShowLabel = false,
                    selected = currentRoute == item.screen?.route,
                    onClick = {
                        if (item.screen != null) {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        } else {
                            onSignOutClicked()
                        }
                    },
                    colors = navigationRailItemColors,
                    modifier = modifier.padding(bottom = 8.dp),
                )
            }
    }
}

@Preview(showSystemUi = true, device = Devices.NEXUS_10)
@Composable
private fun NavigationPreview() {
    CashierAppComposeTheme {
        CashierApp()
    }
}