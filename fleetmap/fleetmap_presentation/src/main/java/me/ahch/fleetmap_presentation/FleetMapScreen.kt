package me.ahch.fleetmap_presentation

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import me.ahch.core.model.Fleet
import me.ahch.fleetmap_presentation.utils.bitmapDescriptor


@Composable
fun FleetMapScreen(
    fleetList: List<Fleet>,
    viewModel: FleetMapViewModel
) {
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }


    var targetLocation: LatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(targetLocation, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = viewModel.state.properties,
        uiSettings = uiSettings,
        cameraPositionState = cameraPositionState,
    ) {
        fleetList.forEach {
            Marker(
                position = LatLng(it.coordinate.latitude, it.coordinate.longitude),
                title = it.id.toString(),
                icon =
                if (it.fleetType == "TAXI") {
                    bitmapDescriptor(LocalContext.current,R.drawable.ic_taxi_top)
                } else {
                    bitmapDescriptor(LocalContext.current,R.drawable.ic_car_top)
                },
                rotation = it.heading.toFloat(),

            )
            LaunchedEffect(key1 = true) {
                if (it.isSelected) {
                    targetLocation = LatLng(it.coordinate.latitude, it.coordinate.longitude)
                    cameraPositionState.position =
                        CameraPosition.fromLatLngZoom(targetLocation, 15f)

                }
            }


        }

    }
}

