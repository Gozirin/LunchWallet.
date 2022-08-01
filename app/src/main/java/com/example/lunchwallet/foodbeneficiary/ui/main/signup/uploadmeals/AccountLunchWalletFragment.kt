package com.example.lunchwallet.foodbeneficiary.ui.main.signup.uploadmeals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentAccountLunchWalletBinding

class AccountLunchWalletFragment : Fragment(R.layout.fragment_account_lunch_wallet) {
    private lateinit var binding: FragmentAccountLunchWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAccountLunchWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add Meal Button
        binding.accountLunchWalletAddMealButton.setOnClickListener {
            //    findNavController().navigate(R.id.action_messageAlertFragment_to)
        }
    }
}
