package com.ardev.proadts.modules.userlist

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardev.proadts.R
import com.ardev.proadts.base.BaseFragment
import com.ardev.proadts.component.loading.LoadingDefault
import com.ardev.proadts.component.recyclerview.RecyclerListUsers
import com.ardev.proadts.models.response.user.UserResponse
import com.ardev.proadts.middleware.adapter.UserListRecyclerViewAdapter
import com.ardev.proadts.modules.userlist.states.PageStateUserList
import com.ardev.proadts.modules.userlist.viewmodel.UserListViewModel
import com.ardev.proadts.shared.extension.hide
import com.ardev.proadts.shared.extension.show
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [UserListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class UserListFragment : BaseFragment(), UserListRecyclerViewAdapter.CallBack {
    override fun layoutId(): Int = R.layout.fragment_user_list

    private var rvListUser: RecyclerListUsers? = null
    private lateinit var adapter: UserListRecyclerViewAdapter
    private var loadingView: LoadingDefault? = null

//    private var btnToSearchUserPage: Button? =null

    private val mViewModel: UserListViewModel by lazy {
        ViewModelProvider(this)[UserListViewModel::class.java]
    }

    override fun setupView() {
        rvListUser = getmView()?.findViewById(R.id.rv_list_user)
        loadingView = getmView()?.findViewById(R.id.loadingView)
//        btnToSearchUserPage = getmView()?.findViewById(R.id.btnToSearchUserPage)
    }

    private fun setupUsersListing(totalColumn: Int = 1, usersList: List<UserResponse>) {
        rvListUser!!.layoutManager = when {
            totalColumn <= 1 -> LinearLayoutManager(getmView()?.context)
            else -> GridLayoutManager(getmView()?.context, totalColumn)
        }
        adapter = UserListRecyclerViewAdapter(getmView()?.context, usersList, this)
        rvListUser!!.adapter = adapter
    }

    override fun registerEvent() {
//        btnToSearchUserPage?.setOnClickListener {
//            navigateToSearchUserPage()
//        }
        mViewModel.fetchListUsers()
    }

    override fun initializeViewModelEvent() {
        mViewModel.getPageState.observe(this) {
            when (it) {
                is PageStateUserList.Loading -> showLoading()
                is PageStateUserList.HasData -> showHasData(it.listUsers)
                is PageStateUserList.Failure -> showFailure(it.message)
                is PageStateUserList.NoInternetConnection -> showNoInternetConnection(it.message)
            }
        }
    }

    private fun navigateToSearchUserPage() {
//        navigate(R.id.action_userListFragment_to_searchUserFragment)
    }

    private fun navigateToDetailUserPage() {
        navigate(R.id.action_userListFragment_to_detailUserFragment)
    }

    private fun showLoading() {
        loadingView!!.show()
    }

    private fun showHasData(listUsers: List<UserResponse>?) {
        loadingView!!.hide()
        setupUsersListing(
            usersList = listUsers ?: listOf()
        )
        rvListUser!!.show()
    }

    private fun showFailure(message: String) {
        printInfo(message = "Show Failure")
    }

    private fun showNoInternetConnection(message: String) {
        printInfo(message = "Show No Internet Connection")
    }

    override fun onItemSelected(user: UserResponse) {
        navigateToDetailUserPage()
    }

}