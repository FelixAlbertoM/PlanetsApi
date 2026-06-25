package edu.ucne.planetsapi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.planetsapi.presentation.list.ListPlanetScreen
import edu.ucne.planetsapi.presentation.details.PlanetDetailScreen

@Composable
fun PlanetsNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PlanetList
    ) {
        composable<Screen.PlanetList> {
            ListPlanetScreen(
                onPlanetClick = { id ->
                    navHostController.navigate(Screen.PlanetDetail(id))
                }
            )
        }
        composable<Screen.PlanetDetail> {
            val args = it.toRoute<Screen.PlanetDetail>()
            PlanetDetailScreen(
                onBack = {navHostController.navigateUp()}
            )
        }
    }
}