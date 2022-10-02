package com.example.lunchwallet.common.logout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLogoutConfirmationBinding

class LogoutConfirmationFragmentDialog : DialogFragment() {
    private var binding: FragmentLogoutConfirmationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLogoutConfirmationBinding.inflate(inflater, container, false)
        return binding!!.root
    }

//    Logout Confirmation yes
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.logoutBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_logoutConfirmationFragment_to_loginFragment)
        }
    binding?.dismissLogoutBtn?.setOnClickListener {
        findNavController().navigate(R.id.action_logoutConfirmationFragment_to_dashboardFragment2)}
    }

}
