package me.ahch.core.model

data class Fleet(
    val coordinate: Coordinate,
    val fleetType: String,
    val heading: Double,
    val id: Int,
    var isSelected: Boolean
)  {

    data class Coordinate(
        val latitude: Double,
        val longitude: Double
    )
}
