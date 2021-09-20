package com.erenkazancioglu.patikadevweek3.base

interface IBaseFragment {
    fun isNavigationbarVisible() = true
    fun exitDialogShow()
    fun backgroundColorChange(id: Int)
}