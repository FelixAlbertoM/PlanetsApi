package edu.ucne.planetsapi.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.planetsapi.domain.usecase.GetPlanetDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import edu.ucne.planetsapi.data.remote.Resource
import edu.ucne.planetsapi.presentation.navigation.Screen

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    private val getPlanetDetailUseCase: GetPlanetDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(PlanetDetailUiState())
    val state = _state.asStateFlow()

    init {
        val args = savedStateHandle.toRoute<Screen.PlanetDetail>()
        loadPlanet(args.planetId)
    }

    private fun loadPlanet(id: Int) {
        viewModelScope.launch {
            getPlanetDetailUseCase(id).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }
                    is Resource.Success -> _state.update { it.copy(isLoading = false, planet = result.data) }
                    is Resource.Error -> _state.update {
                        it.copy(isLoading = false, error = result.message)
                    }
                }
            }
        }
    }
}