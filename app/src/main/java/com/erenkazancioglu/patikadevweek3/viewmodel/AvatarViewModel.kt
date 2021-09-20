package com.erenkazancioglu.patikadevweek3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erenkazancioglu.patikadevweek3.R
import com.erenkazancioglu.patikadevweek3.data.Avatar
import com.erenkazancioglu.patikadevweek3.utils.recyclerImageField
import com.erenkazancioglu.patikadevweek3.utils.recyclerTextField

class AvatarViewModel: ViewModel() {

        val avatarDataSet= MutableLiveData<List<Avatar>>()

        fun getAvatarData()
        {
            val text = Avatar(recyclerTextField,"Size uygun avatar seçin",null,null)
            val avatar1 = Avatar(recyclerImageField,null, R.drawable.img_avatar_1,R.drawable.im_not_selected)
            val avatar2 = Avatar(recyclerImageField,null, R.drawable.img_avatar_2,R.drawable.im_not_selected)
            val avatar3 = Avatar(recyclerImageField,null, R.drawable.img_avatar_3,R.drawable.im_not_selected)
            val avatar4 = Avatar(recyclerImageField,null, R.drawable.img_avatar_4,R.drawable.im_not_selected)
            val avatar5 = Avatar(recyclerImageField,null, R.drawable.img_avatar_5,R.drawable.im_not_selected)
            val avatar6 = Avatar(recyclerImageField,null, R.drawable.img_avatar_6,R.drawable.im_not_selected)
            val avatar7 = Avatar(recyclerImageField,null, R.drawable.img_avatar_7,R.drawable.im_not_selected)
            val avatar8 = Avatar(recyclerImageField,null, R.drawable.img_avatar_8,R.drawable.im_not_selected)
            val avatar9 = Avatar(recyclerImageField,null, R.drawable.img_avatar_9,R.drawable.im_not_selected)
            val avatar10 = Avatar(recyclerImageField,null, R.drawable.img_avatar_1,R.drawable.im_not_selected)
            val avatar11 = Avatar(recyclerImageField,null, R.drawable.img_avatar_2,R.drawable.im_not_selected)
            val avatar12 = Avatar(recyclerImageField,null, R.drawable.img_avatar_3,R.drawable.im_not_selected)
            val avatar13 = Avatar(recyclerImageField,null, R.drawable.img_avatar_8,R.drawable.im_not_selected)
            val avatar14 = Avatar(recyclerImageField,null, R.drawable.img_avatar_9,R.drawable.im_not_selected)
            val avatar15 = Avatar(recyclerImageField,null, R.drawable.img_avatar_5,R.drawable.im_not_selected)
            val avatar16 = Avatar(recyclerImageField,null, R.drawable.img_avatar_6,R.drawable.im_not_selected)
            val avatar17 = Avatar(recyclerImageField,null, R.drawable.img_avatar_1,R.drawable.im_not_selected)
            val avatar18 = Avatar(recyclerImageField,null, R.drawable.img_avatar_2,R.drawable.im_not_selected)

            val list = arrayListOf(text,avatar1,avatar2,avatar3,avatar4,avatar5,avatar6,avatar7,avatar8,avatar9,
                avatar10,avatar11,avatar12,avatar13,avatar14,avatar15,avatar16,avatar17,avatar18)

            avatarDataSet.value=list
        }
}
