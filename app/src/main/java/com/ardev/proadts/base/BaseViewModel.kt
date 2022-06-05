package com.ardev.proadts.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ardev.proadts.shared.services.network.FailureStates
import kotlinx.coroutines.Job

abstract class BaseViewModel  : ViewModel() {

//    var failureState: MutableLiveData<FailureStates> = MutableLiveData()

//    var mJob: Job? = null

    override fun onCleared() {
        super.onCleared()
//        if (shouldCancelJob()) {
//            mJob?.cancel()
//        }
    }

    abstract fun handleFailure(failure: FailureStates?)
//    {
//        this.failureState.value = failure
//    }

    protected fun shouldCancelJob(): Boolean {
        return true
    }

    protected fun <K, V> lazyMap(initializer: (K) -> V): Map<K, V> {
        val map = mutableMapOf<K, V>()
        return map.withDefault { key ->
            val newValue = initializer(key)
            map[key] = newValue
            return@withDefault newValue
        }
    }

    open fun printInfo(message: String){
        Log.i("print_info", message)
    }
}