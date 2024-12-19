package com.fitsport.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavViewModel : ViewModel() {
    private val _navigateToFragment = MutableLiveData<Int>()
    val navigateToFragment: LiveData<Int> get() = _navigateToFragment

    fun navigateTo(fragmentId: Int) {
        _navigateToFragment.value = fragmentId
    }

    fun navigationComplete() {
        _navigateToFragment.value = null // Сбрасываем значение после навигации
    }
}

