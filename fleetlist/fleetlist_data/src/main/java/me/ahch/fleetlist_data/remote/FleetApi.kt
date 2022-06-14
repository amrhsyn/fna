package me.ahch.fleetlist_data.remote

import me.ahch.fleetlist_data.remote.dto.GetFleetListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FleetApi {

    @GET("/")
    suspend fun getFleetList(
        @Query("p1Lat") latitude1: Float,
        @Query("p1Lon") longitude1: Float,
        @Query("p2Lat") latitude2: Float,
        @Query("p2Lon") longitude2: Float
    ): Response<GetFleetListResponse>

    companion object {
        const val BASE_URL = "https://fake-poi-api.mytaxi.com/"
    }
}