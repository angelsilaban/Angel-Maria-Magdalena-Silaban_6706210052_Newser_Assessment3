package org.d3if0052.newser.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0052.newser.model.Berita
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/angelsilaban/newser.json/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BeritaApiService {
    @GET("berita.json")
    suspend fun getBerita(): ArrayList<Berita>
}

object BeritaApi {
    val service: BeritaApiService by lazy {
        retrofit.create(BeritaApiService::class.java)
    }
}