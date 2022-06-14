package me.ahch.fleetmap_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import me.ahch.core.model.Fleet
import javax.inject.Inject

@HiltViewModel
class FleetMapViewModel @Inject constructor(
): ViewModel() {

    var state by mutableStateOf(FleetMapState())

}