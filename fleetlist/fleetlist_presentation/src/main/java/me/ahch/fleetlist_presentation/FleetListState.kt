package me.ahch.fleetlist_presentation

import me.ahch.core.model.Fleet

data class FleetListState(
    var fleetList: List<Fleet> = emptyList(),
    var isLoading: Boolean = false,
    var errorMessage: String = "",
){

}