package me.ahch.fleetlist_data.repository

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import me.ahch.core.utils.Resource
import me.ahch.fleetlist_data.remote.FleetApi
import me.ahch.fleetlist_data.remote.malformedFleetListResponse
import me.ahch.fleetlist_data.remote.validFleetListResponse
import me.ahch.fleetlist_domain.model.Bounds
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FleetRepositoryImplTest {

    private lateinit var repository: FleetRepositoryImpl
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: FleetApi

    private val validMockResponse=MockResponse()
        .setResponseCode(200)
        .setBody(validFleetListResponse)

    private val invalidMockResponse=
        MockResponse()
            .setResponseCode(403)
            .setBody(validFleetListResponse)

    private val malformedMockResponse=
        MockResponse()
            .setBody(malformedFleetListResponse)


    private val sampleBounds=Bounds(53.694865f,
        9.757589f,
        53.394655f,
        10.099891f)

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(FleetApi::class.java)
        repository = FleetRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get fleet list, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(validMockResponse)

        val result = repository.getFleetList(sampleBounds)

        assertThat(result is Resource.Success<*>).isTrue()
    }

    @Test
    fun `Get fleet list, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(invalidMockResponse)

        val result = repository.getFleetList(sampleBounds)

        assertThat(result is Resource.Error).isTrue()
    }

    @Test
    fun `Get fleet list, malformed response, returns failure`() = runBlocking {
        mockWebServer.enqueue(malformedMockResponse)

        val result = repository.getFleetList(sampleBounds)

        assertThat(result is Resource.Error).isTrue()
    }

}