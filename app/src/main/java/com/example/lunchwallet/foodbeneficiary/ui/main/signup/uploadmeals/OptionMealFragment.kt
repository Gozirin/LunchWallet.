package com.example.lunchwallet.foodbeneficiary.ui.main.signup.uploadmeals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentOptionMealBinding

class OptionMealFragment : Fragment(R.layout.fragment_option_meal) {

    private lateinit var binding: FragmentOptionMealBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOptionMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kitchenDropDown()
        namedMealFocusListener()
        serveTimeFocusListener()
        kitchenFocusListener()
        binding.optionMealFragmentAddMealButton.setOnClickListener {
            findNavController().navigate(R.id.action_optionMealFragment_to_messageAlertFragment)
        }
    }

    private fun kitchenDropDown() {
        val kitchen = resources.getStringArray(R.array.kitchen)
        val adapter = ArrayAdapter(requireContext(), R.layout.kitchen_menu_list, kitchen)
        with(binding.kitchenAutoView) {
            setAdapter(adapter)
        }
    }

    private fun namedMealFocusListener() {
        binding.uploadMealFragmentTitleOfMealET.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.uploadMealFragmentTitleOfMealContainer.helperText
        }
    }

    private fun serveTimeFocusListener() {
        binding.optionMealFragmentAddTimeET.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.optionMealFragmentAddTimeContainer.helperText
        }
    }
    private fun kitchenFocusListener() {
        binding.kitchenAutoView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.optionMealFragmentSelectContainer.helperText
        }
    }
}
