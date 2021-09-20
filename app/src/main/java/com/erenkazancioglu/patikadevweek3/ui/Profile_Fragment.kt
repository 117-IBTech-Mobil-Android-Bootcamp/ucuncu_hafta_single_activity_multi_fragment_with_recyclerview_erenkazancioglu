package com.erenkazancioglu.patikadevweek3.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class Profile_Fragment : BaseFragment() {

    override fun getLayoutID(): Int = R.layout.fragment_profile

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_edit.setOnClickListener{
            findNavController().navigate(R.id.action_profile_Fragment_to_avatar_Selection_Fragment)
        }
    }
}