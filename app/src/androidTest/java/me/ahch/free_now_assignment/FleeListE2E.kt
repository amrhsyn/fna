package me.ahch.free_now_assignment

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import me.ahch.core.model.Fleet
import me.ahch.fleetlist_domain.use_case.GetFleetListUseCase
import me.ahch.fleetlist_presentation.FleetListScreen
import me.ahch.fleetlist_presentation.FleetListViewModel
import me.ahch.fleetmap_presentation.FleetMapScreen
import me.ahch.fleetmap_presentation.FleetMapViewModel
import me.ahch.free_now_assignment.navigation.Argument.FLEET_LIST_ARGUMENT
import me.ahch.free_now_assignment.navigation.Route
import me.ahch.free_now_assignment.repository.FleetRepositoryFake
import me.ahch.free_now_assignment.ui.theme.FreeNowAssignmentTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalComposeUiApi
@HiltAndroidTest
class FleeListE2E {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var repositoryFake: FleetRepositoryFake
    private lateinit var getFleetListUseCase: GetFleetListUseCase
    private lateinit var fleetListViewModel: FleetListViewModel
    private lateinit var fleetMapViewModel: FleetMapViewModel

    private lateinit var navController: NavHostController


    @Before
    fun setUp() {

        repositoryFake = FleetRepositoryFake()
        getFleetListUseCase = GetFleetListUseCase(repositoryFake)
        fleetListViewModel = FleetListViewModel(getFleetListUseCase)
        fleetMapViewModel= FleetMapViewModel()

        composeRule.setContent {
            FreeNowAssignmentTheme {
                val scaffoldState = rememberScaffoldState()
                navController = rememberNavController()
                var currentTopAppBar by remember {
                    mutableStateOf("")
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,

                    topBar = {
                        TopAppBar(
                            title = { Text(text = if (currentTopAppBar ==Route.FLEET_LIST) "Fleet List" else "Fleet Map") },
                            navigationIcon = if (currentTopAppBar ==Route.FLEET_MAP) {
                                {
                                    IconButton(modifier=Modifier.testTag("back_btn"),onClick = { navController.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = "Back"
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
                                viewModel = fleetListViewModel,
                                navigateToFleetMapScreen = { fleetList ->
                                    val jsonFleetList = Uri.encode(Gson().toJson(fleetList))
                                    navController.navigate(Route.FLEET_MAP + "/${jsonFleetList}")
                                }

                            )
                            currentTopAppBar = Route.FLEET_LIST
                        }
                        composable(
                            route = Route.FLEET_MAP + "/{${FLEET_LIST_ARGUMENT}}",
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
                            FleetMapScreen(fleetList, viewModel = fleetMapViewModel)
                            currentTopAppBar = Route.FLEET_MAP
                        }
                    }
                }
            }



        }
    }

    @Test
    fun getFleetList_ClickOnItem_PressBackButton(){
        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.FLEET_LIST)
        ).isTrue()

        composeRule
            .onNodeWithText("Fleet List")
            .assertExists()


        composeRule
            .onAllNodesWithText("POOLING")
            .onFirst()
            .assertIsDisplayed()

        composeRule
            .onAllNodesWithText("TAXI")
            .onFirst()
            .assertIsDisplayed()

        composeRule
            .onAllNodesWithText("Check on the map")
            .onFirst()
            .assertIsDisplayed()

        composeRule
            .onAllNodesWithText("Check on the map")
            .onFirst()
            .performClick()

        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.FLEET_MAP)
        ).isTrue()

        composeRule
            .onNodeWithTag("back_btn")
            .performClick()

        assertThat(
            navController
                .currentDestination
                ?.route
                ?.startsWith(Route.FLEET_LIST)
        ).isTrue()
    }
}