package me.ahch.fleetlist_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import me.ahch.core.utils.Resource
import me.ahch.core_ui.UiEvent
import me.ahch.core_ui.UiText
import me.ahch.fleetlist_domain.model.Bounds
import me.ahch.fleetlist_domain.use_case.GetFleetListUseCase
import javax.inject.Inject

@HiltViewModel
class FleetListViewModel @Inject constructor(
    val getFleetListUseCase: GetFleetListUseCase
) : ViewModel() {

    var state by mutableStateOf(FleetListState())
        private set

    init {
        getFleetList()
        println("")

    }

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onEvent(event: FleetListEvent) {
        when (event) {
            is FleetListEvent.OnItemClick -> {
                state.fleetList.forEach { it.isSelected = false }
                state.fleetList[state.fleetList.indexOf(event.item)].isSelected=true
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.Success)
                }

            }

        }
    }

    fun getFleetList() {
        viewModelScope.launch {
            getFleetListUseCase(Bounds(
                53.694865f,
                9.757589f,
                53.394655f,
                10.099891f
            )).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state = state.copy(
                            fleetList = result.data ?: emptyList(),
                            isLoading = false,
                            errorMessage = "",
                        )
                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true,
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            fleetList = emptyList(),
                            isLoading = false,
                            errorMessage = result.message
                        )
                        _uiEvent.send(
                            UiEvent.ShowSnackbar(
                                if (result.message.isNullOrEmpty()){
                                    UiText.StringResource(R.string.error_something_went_wrong)
                                }else{
                                    UiText.DynamicString(result.message)
                                }
                            ))

                    }
                }
            }.launchIn(this)
        }


    }
}