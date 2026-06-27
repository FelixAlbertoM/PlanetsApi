package edu.ucne.planetsapi.presentation.characters.list

import edu.ucne.planetsapi.domain.model.Character

data class CharacterListUiState(
    val isLoading: Boolean = false,
    val allCharacters: List<Character> = emptyList(),
    val characters: List<Character> = emptyList(),
    val error: String? = null,
    val filterName: String = "",
    val filterGender: String = "",
    val filterRace: String = ""
)