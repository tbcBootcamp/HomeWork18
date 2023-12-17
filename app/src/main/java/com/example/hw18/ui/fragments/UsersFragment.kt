package com.example.hw18.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw18.adapter.UsersAdapter
import com.example.hw18.base.BaseFragment
import com.example.hw18.databinding.FragmentUsersBinding
import kotlinx.coroutines.launch


class UsersFragment : BaseFragment<FragmentUsersBinding>(FragmentUsersBinding::inflate) {
    private val viewModel: UsersViewModel by viewModels()
    private val usersAdapter = UsersAdapter()

    override fun setUp() {
        binding.rvUsers.adapter = usersAdapter
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect { pagingData ->
                    usersAdapter.submitData(pagingData)
                }
            }
        }
    }
}

