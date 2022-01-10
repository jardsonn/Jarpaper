package com.jcs.jarpaper.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun <A, T> performGetOperation(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> DataResource<A>,
    deleteSavedData: suspend () -> Unit,
    saveCallResult: suspend (A) -> Unit
): LiveData<DataResource<T>> =
    liveData(Dispatchers.IO) {
        emit(DataResource.loading())
        val source = databaseQuery.invoke().map { DataResource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        deleteSavedData.invoke()

        if (responseStatus.status == DataResource.Status.SUCCESS) {
            responseStatus.data?.let {
                saveCallResult(it)
            }
        }
        else if (responseStatus.status == DataResource.Status.ERROR) {
            emit(DataResource.error(responseStatus.message!!))
            emitSource(source)
        }
    }