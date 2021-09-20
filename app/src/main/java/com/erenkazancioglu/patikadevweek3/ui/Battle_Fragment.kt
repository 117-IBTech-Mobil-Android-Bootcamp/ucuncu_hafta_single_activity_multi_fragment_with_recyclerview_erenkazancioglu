package com.erenkazancioglu.patikadevweek3.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.base.BaseFragment

class Battle_Fragment : BaseFragment() {
    override fun getLayoutID(): Int = R.layout.fragment_battle


    override fun onAttach(context: Context) {
        super.onAttach(context)
        backgroundColorChange(R.color.yellow_bg)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exitDialogShow()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}