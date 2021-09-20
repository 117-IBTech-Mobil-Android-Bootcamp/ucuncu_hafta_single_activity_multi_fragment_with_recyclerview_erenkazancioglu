package com.erenkazancioglu.patikadevweek3.base

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.erenkazancioglu.patikadevweek3.MainActivity
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.R.color.title_text_color

abstract class BaseFragment:Fragment(), IBaseFragment {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()

        val baseActivity = activity as MainActivity
        if (isNavigationbarVisible())
            baseActivity.showNavigation()
        else
            baseActivity.hideNavigation()
    }

    override fun exitDialogShow() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alert= AlertDialog.Builder(requireContext())
                alert.setTitle("Uyarı")
                alert.setMessage("Çıkmak istediğinizden emin misiniz ?")
                alert.setCancelable(false)
                alert.setNegativeButton("Hayır"){ dialog, which ->
                    dialog.cancel()
                }
                alert.setPositiveButton("Evet"){dialog,which ->
                    activity?.finish()
                }.show()
            }
        })
    }

    override fun backgroundColorChange(id: Int) {
        activity?.window?.statusBarColor = resources.getColor(id)
    }

    abstract fun getLayoutID(): Int

}