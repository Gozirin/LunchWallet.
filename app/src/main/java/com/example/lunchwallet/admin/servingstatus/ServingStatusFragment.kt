package com.example.lunchwallet.admin.servingstatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentServingStatusBinding

class ServingStatusFragment : Fragment() {

    private var _binding: FragmentServingStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentServingStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Change Status Brunch Button
        binding.servingStatusButton.setOnClickListener {
            findNavController().navigate(R.id.action_servingStatusFragment_to_optionStatusScreenFragment)
        }
        // Change Status Dinner Button
        binding.servingStatusButton2.setOnClickListener {
            findNavController().navigate(R.id.action_servingStatusFragment_to_optionStatusScreenFragment)
        }
        // Back Button
        binding.servingStatusBackarrowIV.setOnClickListener {
            findNavController().navigate(R.id.action_servingStatusFragment_to_dashboardFragment)
        }
        // Floating Action Button To Navigation Drawer
        binding.navFloatingButton.setOnClickListener {
            // findNavController().navigate(R.id.action_dashboardFragment_to_navigationStatusFragment)
        }
    }
}






