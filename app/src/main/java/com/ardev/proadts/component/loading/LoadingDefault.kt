package com.ardev.proadts.component.loading

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseViewConstraint
import com.ardev.proadts.base.BaseViewLinear

class LoadingDefault : BaseViewLinear {

    constructor(context: Context) : super(context, null) {
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet, 0) {
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    override fun getLayoutId() = R.layout.loading_default

    override fun initUI() {
        this.visibility = View.GONE
    }

}