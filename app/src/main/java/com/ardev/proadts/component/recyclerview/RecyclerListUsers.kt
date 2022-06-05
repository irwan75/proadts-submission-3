package com.ardev.proadts.component.recyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * TODO: document your custom view class.
 */
class RecyclerListUsers : RecyclerView{

    private lateinit var mGridLayoutManager: GridLayoutManager

    constructor(context: Context) : super(context, null) {
        initDefaultManager()
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet, 0) {
        initDefaultManager()
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ){
        initDefaultManager()
    }

    fun initDefaultManager(totalColumn: Int = 1) {
        setHasFixedSize(true)
        mGridLayoutManager =
            GridLayoutManager(context, totalColumn)
        this.layoutManager = mGridLayoutManager

    }


}