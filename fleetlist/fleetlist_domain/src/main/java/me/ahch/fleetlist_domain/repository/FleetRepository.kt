package me.ahch.fleetlist_domain.repository

import me.ahch.core.model.Fleet
import me.ahch.core.utils.Resource
import me.ahch.fleetlist_domain.model.Bounds

interface FleetRepository {

    suspend fun getFleetList(
        bounds: Bounds
    ): Resource<List<Fleet>>
}