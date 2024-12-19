package com.fitsport.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.fragment.app.Fragment

class MainViewModel : ViewModel() {

    // LiveData для текущего фрагмента
    private val _currentFragment = MutableLiveData<Fragment>()
    val currentFragment: LiveData<Fragment> get() = _currentFragment

    // Метод для выбора фрагмента
    fun selectFragment(fragment: Fragment) {
        _currentFragment.value = fragment
    }
}
