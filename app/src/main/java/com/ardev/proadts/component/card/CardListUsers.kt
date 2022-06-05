package com.ardev.proadts.component.card

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseViewConstraint
import com.ardev.proadts.base.BaseViewLinear
import com.ardev.proadts.base.BaseViewRelative
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class CardListUsers : BaseViewConstraint{

    private var tvUserName: TextView? = null
    private var tvUserId: TextView? = null
    private var tvCompanyName: TextView? = null
    private var avatarPlaceholder: CircleImageView? =null

    constructor(context: Context) : super(context, null) {
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet, 0) {
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    override fun getLayoutId(): Int = R.layout.card_list_user

    override fun initUI() {
        tvUserName = getmView()!!.findViewById(R.id.tv_user_name)
        tvUserId = getmView()!!.findViewById(R.id.tv_user_id)
        tvCompanyName = getmView()!!.findViewById(R.id.tv_company_name)
        avatarPlaceholder = getmView()!!.findViewById(R.id.avatar_placeholder)
    }

    fun render(userId: String){
        tvUserId!!.text = userId
    }

}