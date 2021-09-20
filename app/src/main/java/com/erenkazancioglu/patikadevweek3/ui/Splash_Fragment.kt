package com.erenkazancioglu.patikadevweek3.ui

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.R.color.yellow_bg
import com.erenkazancioglu.patikadevweek3.utils.gone
import kotlinx.android.synthetic.main.fragment_splash.*


class Splash_Fragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.window?.statusBarColor = resources.getColor(R.color.splash_bg_color)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myProgressBar : ProgressBar
        var myCountTimer : CountDownTimer
        var i : Int = 0
        myProgressBar = progressBar
        myProgressBar.setProgress(i)

        myCountTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                progressBar.gone()
                findNavController().navigate(R.id.action_splashFragment_to_battleFragment)
            }
        }
        myCountTimer.start()
    }
}