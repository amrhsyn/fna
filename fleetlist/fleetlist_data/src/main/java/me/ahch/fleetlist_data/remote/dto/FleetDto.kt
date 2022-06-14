package me.ahch.fleetlist_data.remote.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class FleetDto(
    @SerializedName("coordinate")
    val coordinate: Coordinate,
    @SerializedName("fleetType")
    val fleetType: String,
    @SerializedName("heading")
    val heading: Double,
    @SerializedName("id")
    val id: Int
) {
    @Keep
    data class Coordinate(
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("longitude")
        val longitude: Double
    )
}