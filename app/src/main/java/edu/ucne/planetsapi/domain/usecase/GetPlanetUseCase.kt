package edu.ucne.planetsapi.domain.usecase

import edu.ucne.planetsapi.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetUseCase @Inject constructor(
    private val repository: PlanetRepository
) {
    suspend operator fun invoke() = repository.getPlanets()
}