package me.ahch.fleetlist_presentation

import me.ahch.core.model.Fleet


sealed class FleetListEvent {
    data class OnItemClick(val item: Fleet) : FleetListEvent()
}