package com.example.lunchwallet.foodbeneficiary.ui.main.signup.ui.confirmMail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.databinding.FragmentConfrimMailFrgamentBinding

class ConfirmMailFragment : Fragment() {

    private var _binding: FragmentConfrimMailFrgamentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfrimMailFrgamentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}