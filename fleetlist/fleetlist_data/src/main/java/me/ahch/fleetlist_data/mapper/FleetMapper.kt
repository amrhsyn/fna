package me.ahch.fleetlist_data.mapper

import me.ahch.fleetlist_data.remote.dto.FleetDto
import me.ahch.core.model.Fleet

fun FleetDto.toFleet(): Fleet = Fleet(
    coordinate = Fleet.Coordinate(this.coordinate.latitude, this.coordinate.longitude),
    fleetType = this.fleetType,
    heading = this.heading,
    id = this.id,
    isSelected = false
)