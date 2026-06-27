package edu.ucne.planetsapi.data.remote

import edu.ucne.planetsapi.data.remote.dto.PlanetDto
import edu.ucne.planetsapi.data.remote.dto.PlanetResponseDto
import edu.ucne.planetsapi.data.remote.dto.CharacterResponseDto
import edu.ucne.planetsapi.data.remote.dto.CharacterDto
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

    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("name") name: String?,
        @Query("gender") gender: String?,
        @Query("race") race: String?
    ): Response<CharacterResponseDto>

    @GET("characters/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: Int
    ): Response<CharacterDto>
}