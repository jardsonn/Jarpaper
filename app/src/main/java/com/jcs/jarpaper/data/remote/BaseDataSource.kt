package com.jcs.jarpaper.data.remote

import com.jcs.jarpaper.utils.DataResource
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): DataResource<T> {
        try{
            val response = call()
            if (response.isSuccessful){
                val body = response.body()
                if(body != null) return DataResource.success(body)
            }
            return error("${response.code()} ${response.message()}")
        }catch (e: Exception){
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): DataResource<T> {
        Timber.d(message)
        return DataResource.error("A chamada de rede falhou pelo seguinte motivo: $message")
    }
}