package com.example.lunchwallet.kitchenstaff.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentKitchenStaffDashboardBinding

class KitchenStaffDashBoardFragment : Fragment(R.layout.fragment_admin_upload_meal_recycler_view) {

    private var _binding: FragmentKitchenStaffDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKitchenStaffDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
