package me.ahch.fleetlist_presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import me.ahch.core.model.Fleet
import me.ahch.core_ui.UiEvent
import me.ahch.fleetlist_presentation.components.FleetItem

@Composable
fun FleetListScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModel: FleetListViewModel,
    navigateToFleetMapScreen: (fleetList: List<Fleet>) -> Unit
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> {
                    navigateToFleetMapScreen(viewModel.state.fleetList)
                }
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context = context)
                    )
                }
                else -> Unit
            }
        }
    }
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.fleetList) { fleet ->
                FleetItem(fleet = fleet) {
                    viewModel.onEvent(FleetListEvent.OnItemClick(fleet))
                }
            }
        }
    }


}


