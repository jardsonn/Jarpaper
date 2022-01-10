package com.jcs.jarpaper.utils

/**
 * Created by Jardson Costa on 28/11/2021.
 */

data class DataResource<out T>(val status: Status, val data: T?, val message: String?){
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): DataResource<T> {
            return DataResource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): DataResource<T> {
            return DataResource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): DataResource<T> {
            return DataResource(Status.LOADING, data, null)
        }
    }
}