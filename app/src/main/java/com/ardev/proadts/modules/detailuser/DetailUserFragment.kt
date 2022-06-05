package com.ardev.proadts.modules.detailuser

import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseFragment
import com.ardev.proadts.component.loading.LoadingDefault
import com.ardev.proadts.modules.detailuser.states.EventStateDetailUser
import com.ardev.proadts.modules.detailuser.states.PageStateDetailUser
import com.ardev.proadts.modules.detailuser.viewmodel.DetailUserViewModel
import com.ardev.proadts.shared.extension.show
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [DetailUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DetailUserFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.fragment_detail_user

    private var loadingView: LoadingDefault? =null
    private var btnFollowers: Button? =null
    private var btnFollowing: Button? =null
    private var btnRepository: Button? =null

    private val mViewModel: DetailUserViewModel by lazy {
        ViewModelProvider(this)[DetailUserViewModel::class.java]
    }

    override fun setupView() {
        loadingView = getmView()?.findViewById(R.id.loadingView)
        btnFollowers = getmView()?.findViewById(R.id.btnFollowers)
        btnFollowing = getmView()?.findViewById(R.id.btnFollowing)
        btnRepository = getmView()?.findViewById(R.id.btnRepository)
    }

    override fun registerEvent() {
        btnFollowing!!.setOnClickListener {
            mViewModel.onClickEvent(EventStateDetailUser.OnClickFollowing("10"))
        }
        btnFollowers!!.setOnClickListener {
            mViewModel.onClickEvent(EventStateDetailUser.OnClickFollowers("20"))
        }
        btnRepository!!.setOnClickListener {
            mViewModel.onClickEvent(EventStateDetailUser.OnClickRepository("30"))
        }
    }


    override fun initializeViewModelEvent() {
        mViewModel.getPageState.observe(this){
            when (it) {
                is PageStateDetailUser.Loading -> showLoading()
                is PageStateDetailUser.HasData -> showHasData(it.data)
                is PageStateDetailUser.Failure -> showFailure(it.message)
                is PageStateDetailUser.NoInternetConnection -> showInternetConnection(it.message)
                else -> {}
            }
        }
    }

    private fun showLoading(){
        loadingView!!.show()
    }

    private fun showHasData(data: String){
    }

    private fun showFailure(message: String){

    }

    private fun showInternetConnection(message: String){

    }


}