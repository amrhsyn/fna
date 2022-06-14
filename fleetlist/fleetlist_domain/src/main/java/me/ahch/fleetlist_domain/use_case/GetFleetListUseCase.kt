package me.ahch.fleetlist_domain.use_case

import me.ahch.core.model.Fleet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.ahch.core.utils.Resource
import me.ahch.fleetlist_domain.model.Bounds
import me.ahch.fleetlist_domain.repository.FleetRepository
import javax.inject.Inject

class GetFleetListUseCase @Inject constructor(
    private val repository: FleetRepository
) {
    operator fun invoke(bounds: Bounds): Flow<Resource<List<Fleet>>> = flow {
        emit(Resource.Loading)
        val result = repository.getFleetList(bounds)
        emit(result)
    }
}