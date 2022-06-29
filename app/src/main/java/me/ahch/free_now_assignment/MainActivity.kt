package me.ahch.free_now_assignment

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import me.ahch.core.model.Fleet
import me.ahch.fleetlist_presentation.FleetListScreen
import me.ahch.fleetmap_presentation.FleetMapScreen
import me.ahch.free_now_assignment.navigation.Argument.FLEET_LIST_ARGUMENT
import me.ahch.free_now_assignment.navigation.Route
import me.ahch.free_now_assignment.ui.theme.FreeNowAssignmentTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FreeNowAssignmentTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                var currentTopAppBar by remember {
                    mutableStateOf("")
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,

                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = if (currentTopAppBar == Route.FLEET_LIST) getString(
                                        R.string.fleet_list_screen_title
                                    ) else getString(
                                        R.string.fleet_map_screen_title
                                    )
                                )
                            },
                            navigationIcon = if (currentTopAppBar == Route.FLEET_MAP) {
                                {
                                    IconButton(
                                        modifier = Modifier.testTag("back_btn"),
                                        onClick = { navController.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = getString(R.string.top_bar_back_content_description)
                                        )
                                    }
                                }
                            } else {
                                null
                            }
                        )
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.FLEET_LIST
                    ) {
                        composable(
                            route = Route.FLEET_LIST
                        ) {
                            FleetListScreen(
                                scaffoldState = scaffoldState,
                                viewModel = hiltViewModel(),
                                navigateToFleetMapScreen = { fleetList ->
                                    val jsonFleetList = Uri.encode(Gson().toJson(fleetList))
                                    navController.navigate(Route.FLEET_MAP + "/${jsonFleetList}")
                                }
                            )
                            currentTopAppBar = Route.FLEET_LIST
                        }
                        composable(
                            route = Route.FLEET_MAP + "/{$FLEET_LIST_ARGUMENT}",
                            arguments = listOf(
                                navArgument(FLEET_LIST_ARGUMENT) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val listType = object : TypeToken<List<Fleet>>() {}.type
                            val fleetList = Gson().fromJson<List<Fleet>>(
                                it.arguments?.getString(FLEET_LIST_ARGUMENT)!!,
                                listType
                            )
                            FleetMapScreen(fleetList, viewModel = hiltViewModel())
                            currentTopAppBar = Route.FLEET_MAP
                        }
                    }
                }
            }
        }
    }
}
