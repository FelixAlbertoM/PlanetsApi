package edu.ucne.planetsapi.presentation.details

import edu.ucne.planetsapi.domain.model.Planet

data class PlanetDetailUiState(
    val isLoading: Boolean = false,
    val planet: Planet? = null,
    val error: String? = null
)