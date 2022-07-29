package com.example.lunchwallet.foodbeneficiary.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentDashBoardLunchWalletBinding

class DashBoardLunchWalletFragment : Fragment(R.layout.fragment_dash_board_lunch_wallet) {

    private lateinit var binding: FragmentDashBoardLunchWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardLunchWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userUploadMealIv.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardLunchWalletFragment_to_uploadMealFragment)
        }
    }
}
