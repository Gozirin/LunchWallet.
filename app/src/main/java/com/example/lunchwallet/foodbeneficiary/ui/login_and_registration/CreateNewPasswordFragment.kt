package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCreateNewPasswordBinding
import com.example.lunchwallet.databinding.FragmentLoginBinding

class CreateNewPasswordFragment : Fragment(R.layout.fragment_create_new_password) {

    private var _binding: FragmentCreateNewPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNewPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createNewPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_createNewPasswordFragment_to_successModalFragment)
        }
    }
}
