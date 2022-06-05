package com.ardev.proadts.component.appbar

import android.content.Context
import android.util.AttributeSet
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseToolbar

class AppBarSearchUser : BaseToolbar {
    override fun getLayoutId(): Int = R.layout.appbar_search_user

    constructor(context: Context) : super(context, null) {
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet, 0) {
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    override fun initUI() {

    }
}