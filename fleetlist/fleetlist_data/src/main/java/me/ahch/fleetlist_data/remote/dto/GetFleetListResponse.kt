package me.ahch.fleetlist_data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GetFleetListResponse(
    @SerializedName("poiList")
    val fleetList: List<FleetDto>,
)