package me.ahch.fleetlist_data.repository

import me.ahch.fleetlist_data.mapper.toFleet
import me.ahch.fleetlist_data.remote.FleetApi
import me.ahch.core.model.Fleet
import me.ahch.core.utils.Resource
import me.ahch.fleetlist_domain.model.Bounds
import me.ahch.fleetlist_domain.repository.FleetRepository
import java.lang.Exception

class FleetRepositoryImpl(
    private val api: FleetApi
) : FleetRepository {

    override suspend fun getFleetList(
        bounds: Bounds
    ): Resource<List<Fleet>> {
        return try {
            val fleetListResponse = api.getFleetList(bounds.p1Lat,bounds.p1Lng,bounds.p2Lat,bounds.p2Lng)
            if (fleetListResponse.isSuccessful) {
                Resource.Success(fleetListResponse.body()!!.fleetList.map { it.toFleet() })
            } else {
                Resource.Error(fleetListResponse.errorBody().toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.localizedMessage ?: "some error happened")
        }
    }
}