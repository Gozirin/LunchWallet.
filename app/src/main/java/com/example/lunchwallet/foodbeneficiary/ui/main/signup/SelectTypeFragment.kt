package com.example.lunchwallet.foodbeneficiary.ui.main.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.databinding.FragmentSelectTypeBinding
import com.example.lunchwallet.util.validation.observeClicks

class SelectTypeFragment : Fragment() {

    private var _binding: FragmentSelectTypeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arr = arrayListOf<View?>(binding.selectTypeFragmentFoodBeneficiaryTv, binding.selectTypeFragmentAdminTv, binding.selectTypeFragmentKitchenStaffTv)

        binding.selectTypeFragmentFoodBeneficiaryTv.observeClicks(arr)
        binding.selectTypeFragmentKitchenStaffTv.observeClicks(arr)
        binding.selectTypeFragmentAdminTv.observeClicks(arr)
    }
}
