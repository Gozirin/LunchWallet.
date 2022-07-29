package com.example.lunchwallet.foodbeneficiary.ui.main.signup.uploadmeals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentUploadMealBinding

class UploadMealFragment : Fragment(R.layout.fragment_upload_meal) {

    private lateinit var binding: FragmentUploadMealBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUploadMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add Meal Button
        binding.uploadMealFragmentAddMealButton.setOnClickListener {
            findNavController().navigate(R.id.action_uploadMealFragment_to_optionMealFragment)
        }
    }
}
