package edu.ucne.planetsapi.presentation.list

sealed interface ListPlanetUiEvent {
    data class UpdateFilters(
        val name: String
    ) : ListPlanetUiEvent

    data object Search : ListPlanetUiEvent
}