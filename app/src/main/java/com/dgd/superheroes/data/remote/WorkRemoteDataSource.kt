package com.dgd.superheroes.data.remote

import com.dgd.superheroes.app.Either
import com.dgd.superheroes.app.ErrorApp
import com.dgd.superheroes.app.left
import com.dgd.superheroes.app.right
import com.dgd.superheroes.data.remote.api.WorkApiModel
import com.dgd.superheroes.data.remote.api.WorkApiService
import com.dgd.superheroes.data.remote.api.toModel
import com.dgd.superheroes.domain.Work
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeoutException

class WorkRemoteDataSource {
    private val baseUrl="https://dam.sitehub.es/api-curso/superheroes/"

    suspend fun getWork(id: Int): Either<ErrorApp, Work>{
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

        val service: WorkApiService = retrofit.create(WorkApiService::class.java)

        return try{
            val repos: Response<WorkApiModel> = service.getWork(id)

            if(repos.isSuccessful){
                repos.body()!!.toModel().right()
            }else{
                ErrorApp.NetworkError.left()
            }
        }catch (ex: TimeoutException) {
            ErrorApp.NetworkError.left()
        }catch (ex: UnknownError) {
            ErrorApp.NetworkError.left()
        }catch (ex: Exception){
            ErrorApp.NetworkError.left()
        }
    }
}