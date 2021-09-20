package com.erenkazancioglu.patikadevweek3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.data.Avatar
import com.erenkazancioglu.patikadevweek3.utils.recyclerImageField
import com.erenkazancioglu.patikadevweek3.utils.recyclerTextField

class AvatarRecyclerAdapter (var avatarList: ArrayList<Avatar>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var selectedItemPos = -1
    var lastItemSelectedPos = -1
    lateinit var viewHolder:RecyclerView.ViewHolder

    private inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var messageText: TextView = itemView.findViewById(R.id.textview_avatar)
        fun bind(position: Int) {
            messageText.text = avatarList[position].text
        }
    }

    private inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView = itemView.findViewById(R.id.rw_image_avatar)
        val avatarSelection: ImageView = itemView.findViewById(R.id.rw_avatar_choose_button)

        init {
            itemView.setOnClickListener {
                selectedItemPos = adapterPosition
                lastItemSelectedPos = if (lastItemSelectedPos == -1)
                    selectedItemPos
                else {
                    notifyItemChanged(lastItemSelectedPos)
                    selectedItemPos
                }
                notifyItemChanged(selectedItemPos)
            }
        }

        fun bind(position: Int) {
            val recyclerViewModel = avatarList[position]
            recyclerViewModel.image?.let {
                avatar.setImageResource(it)
            }
        }

        fun defaultSelected() {
            avatarSelection.setImageResource(R.drawable.im_not_selected)
        }
        fun selected() {
            avatarSelection.setImageResource(R.drawable.im_selected)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            recyclerTextField ->viewHolder = TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_avatar_selection_text, parent, false))
            recyclerImageField ->viewHolder = ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_avatar_selection, parent, false))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == recyclerTextField && holder is TextViewHolder) {
            holder.bind(position)
        } else {
            (holder as ImageViewHolder).bind(position)
            if (position == selectedItemPos)
                holder.selected()
            else
                holder.defaultSelected()
        }
    }

    override fun getItemViewType(position: Int)=avatarList[position].type
    override fun getItemCount(): Int = avatarList.size

    fun invokeAvatarList(newAvatarList: List<Avatar>) {
        avatarList.clear()
        avatarList.addAll(newAvatarList)
        notifyDataSetChanged()
    }
}