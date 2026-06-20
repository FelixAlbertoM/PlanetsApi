package edu.ucne.planetsapi.domain.repository

import edu.ucne.planetsapi.domain.model.Planet

interface PlanetRepository {
    suspend fun getPlanets(): List<Planet>
    suspend fun getPlanetById(id: Int): Planet
}