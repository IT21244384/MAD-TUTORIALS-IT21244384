package com.example.tutorial04

import androidx.annotation.ColorRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Shared ViewModel: MenuFragment writes the clicked value, MainActivity observes it.
 * It also remembers the Cycling background colour so it survives fragment
 * replacement and screen rotation.
 */
class MainActivityData : ViewModel() {

    private val _clickedValue = MutableLiveData<Int>().apply { value = 0 }

    val clickedvalue: LiveData<Int> = _clickedValue

    fun setCountValue(value: Int) {
        _clickedValue.value = value
    }

    /** Background colour resource chosen in CyclingFragment (0 = not changed yet). */
    @ColorRes
    var cyclingBackground: Int = 0
}
