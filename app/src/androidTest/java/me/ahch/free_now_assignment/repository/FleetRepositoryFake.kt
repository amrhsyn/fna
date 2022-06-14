package me.ahch.free_now_assignment.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.ahch.core.model.Fleet
import me.ahch.core.utils.Resource
import me.ahch.fleetlist_domain.model.Bounds
import me.ahch.fleetlist_domain.repository.FleetRepository
import me.ahch.free_now_assignment.navigation.Route
import me.ahch.free_now_assignment.remote.validFleetListResponse

class FleetRepositoryFake : FleetRepository {

    var shouldReturnError = false

    override suspend fun getFleetList(
       bounds: Bounds
    ): Resource<List<Fleet>> {

        return if (shouldReturnError) {
            Resource.Error(Throwable().localizedMessage ?: "some error happened")
        } else {
            val listType = object : TypeToken<List<Fleet>>() {}.type
            val fleetList = Gson().fromJson<List<Fleet>>(validFleetListResponse, listType)
            Resource.Success(fleetList)
        }
    }

}
