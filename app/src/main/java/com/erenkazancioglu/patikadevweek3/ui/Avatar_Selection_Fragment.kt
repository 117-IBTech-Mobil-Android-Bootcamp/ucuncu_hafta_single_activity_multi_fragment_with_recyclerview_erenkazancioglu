package com.erenkazancioglu.patikadevweek3.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.viewmodel.AvatarViewModel
import kotlinx.android.synthetic.main.fragment_avatar_selection.*
import androidx.lifecycle.ViewModelProviders
import com.erenkazancioglu.patikadevweek3.adapter.AvatarRecyclerAdapter


class Avatar_Selection_Fragment : Fragment() {

    private  lateinit var avatarViewModel: AvatarViewModel
    private var avatarAdapter=AvatarRecyclerAdapter(arrayListOf())

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.window?.statusBarColor = resources.getColor(R.color.avatar_bg)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_avatar_selection,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarViewModel= ViewModelProviders.of(this).get(AvatarViewModel::class.java)
        avatarViewModel.getAvatarData()

        val layoutManager = GridLayoutManager(requireContext(),3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when(position){
                    0 -> 3
                    else -> 1
                }
            }

        }
        recycler_view.layoutManager= layoutManager
        recycler_view.adapter = avatarAdapter
        observeLiveData()
    }

    private fun observeLiveData() {
        avatarViewModel.avatarDataSet.observe(viewLifecycleOwner, Observer { item->
            item?.let {
                avatarAdapter.invokeAvatarList(it)
            }

        })
    }



}