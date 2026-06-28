package edu.ucne.planetsapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.planetsapi.presentation.navigation.PlanetNavHost
import edu.ucne.planetsapi.ui.theme.PlanetsApiTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlanetsApiTheme {
                val navController = rememberNavController()
                PlanetNavHost(navHostController = navController)
            }
        }
    }
}