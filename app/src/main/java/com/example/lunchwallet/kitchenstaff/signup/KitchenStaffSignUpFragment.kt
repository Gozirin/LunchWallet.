package com.example.lunchwallet.kitchenstaff.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentKitchenStaffSignUpBinding

class KitchenStaffSignUpFragment : Fragment() {
    private lateinit var binding: FragmentKitchenStaffSignUpBinding

    companion object {
        fun newInstance() = KitchenStaffSignUpFragment()
    }

    private lateinit var viewModel: KitchenStaffSignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKitchenStaffSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[KitchenStaffSignUpViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationDropDown()
    }

    private fun locationDropDown() {
        val location = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(requireContext(), R.layout.location_list, location)
        adapter.setNotifyOnChange(true)
        with(binding.signUpLocationDropdown) {
            setAdapter(adapter)
//            setOnItemClickListener { adapterView, view, i, l ->
//
//            }
        }
    }

}