package edu.ucne.planetsapi.data.remote

import edu.ucne.planetsapi.data.remote.dto.PlanetDto
import edu.ucne.planetsapi.data.remote.dto.PlanetResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface DragonBallApi {

    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String?
    ): Response<PlanetResponseDto>


    @GET("planets/{id}")
    suspend fun getPlanetDetail(
        @Path("id") id: Int
    ):  Response<PlanetDto>
}