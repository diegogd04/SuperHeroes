package com.dgd.superheroes.data.remote

import com.dgd.superheroes.app.Either
import com.dgd.superheroes.app.ErrorApp
import com.dgd.superheroes.app.left
import com.dgd.superheroes.app.right
import com.dgd.superheroes.data.remote.api.HeroeApiModel
import com.dgd.superheroes.data.remote.api.HeroeApiService
import com.dgd.superheroes.data.remote.api.toModel
import com.dgd.superheroes.domain.Heroe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class HeroeRemoteDataSource {
    private val baseUrl = "https://dam.sitehub.es/api-curso/superheroes/"

    suspend fun getHeroes(): Either<ErrorApp, List<Heroe>>{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service: HeroeApiService = retrofit.create(HeroeApiService::class.java)

        try {
            val repos: Response<List<HeroeApiModel>> = service.getHeroes()

            return if(repos.isSuccessful){
                val heroes = repos.body()!!.map {
                    it.toModel()
                }
                return heroes.right()
            }else{
                ErrorApp.NetworkError.left()
            }
        }catch (ex: TimeoutException){
            return ErrorApp.NetworkError.left()
        }catch (ex: UnknownHostException){
            return ErrorApp.NetworkError.left()
        }catch (ex: Exception){
            return ErrorApp.NetworkError.left()
        }
    }
}
