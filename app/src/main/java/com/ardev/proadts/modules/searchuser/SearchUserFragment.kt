package com.ardev.proadts.modules.searchuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseFragment
import com.ardev.proadts.modules.searchuser.viewmodel.SearchUserViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SearchUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SearchUserFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_search_user

    private val mViewModel: SearchUserViewModel by lazy {
        ViewModelProvider(this)[SearchUserViewModel::class.java]
    }



}