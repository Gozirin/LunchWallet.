package com.example.lunchwallet.foodbeneficiary.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.MainActivity
import com.example.lunchwallet.databinding.FragmentFoodBeneficiaryDashboardBinding

class FoodBeneficiaryDashboardFragment : Fragment() {
    private lateinit var binding: FragmentFoodBeneficiaryDashboardBinding

    companion object {
        fun newInstance() = FoodBeneficiaryDashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodBeneficiaryDashboardBinding.inflate(layoutInflater)

        (requireActivity() as MainActivity).apply {
            setStatusBarColor(Color.WHITE)
            setToolBar()
        }

        return binding.root
    }
}
