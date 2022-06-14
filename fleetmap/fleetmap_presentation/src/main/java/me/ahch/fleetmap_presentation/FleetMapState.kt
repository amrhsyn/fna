package me.ahch.fleetmap_presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import me.ahch.fleetmap_presentation.utils.MapStyle

data class FleetMapState(
    val properties: MapProperties = MapProperties(mapStyleOptions = MapStyleOptions(MapStyle.json)),
)
