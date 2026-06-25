package edu.ucne.planetsapi.domain.repository

import edu.ucne.planetsapi.domain.model.Planet
import kotlinx.coroutines.flow.Flow
import edu.ucne.planetsapi.data.remote.Resource

interface PlanetRepository {
    fun getPlanets(
        page: Int,
        limit: Int,
        name: String?
    ): Flow<Resource<List<Planet>>>

    fun getPlanetDetail(id: Int): Flow<Resource<Planet>>
}