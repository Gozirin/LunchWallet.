package com.example.lunchwallet.admin.optionstatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lunchwallet.databinding.FragmentOptionStatusScreenBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OptionStatusScreenFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentOptionStatusScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOptionStatusScreenBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.optionStatusServingTV?.setOnClickListener() {
            //  findNavController().navigate(R.id.action_optionStatusScreenFragment)
        }
    }
}
