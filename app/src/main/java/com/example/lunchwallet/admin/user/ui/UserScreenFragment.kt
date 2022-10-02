package com.example.lunchwallet.admin.user.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.admin.user.adapter.UserScreenAdapter
import com.example.lunchwallet.admin.user.model.Users
import com.example.lunchwallet.databinding.FragmentAdminUserScreenBinding

class UserScreenFragment : Fragment() {
    private var _binding: FragmentAdminUserScreenBinding? = null
    private lateinit var userScreenAdapter: UserScreenAdapter
    private lateinit var userScreenRv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAdminUserScreenBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userScreenAdapter = UserScreenAdapter(Users.listOfUsers)
        userScreenRv = requireView().findViewById(R.id.user_screen_fragment_recyclerView)
        userScreenRv.adapter = userScreenAdapter
        userScreenRv.layoutManager = LinearLayoutManager(requireContext())

        if (userScreenAdapter.itemCount > 0) {
        }
        _binding?.userScreenBackarrowIV?.setOnClickListener() {
            findNavController().navigate(R.id.action_userScreenFragment_to_dashboardFragment)
        }
    }
}
