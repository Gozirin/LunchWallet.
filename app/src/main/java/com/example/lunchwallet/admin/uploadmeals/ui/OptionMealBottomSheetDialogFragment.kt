package com.example.lunchwallet.admin.uploadmeals.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentOptionMealBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import java.io.IOException

class OptionMealBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentOptionMealBinding? = null
    private val binding get() = _binding!!
    private var selectedImageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionMealBinding.inflate(inflater, container, false)
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

        binding.optionMealFragmentUploadImage.setOnClickListener {
            imageChooser()
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
            if (!focused) {
                binding.uploadMealFragmentTitleOfMealContainer.helperText
            }
        }
    }

    private fun serveTimeFocusListener() {
        binding.optionMealFragmentAddTimeET.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.optionMealFragmentAddTimeContainer.helperText
            }
        }
    }
    private fun kitchenFocusListener() {
        binding.kitchenAutoView.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.optionMealFragmentSelectContainer.helperText
            }
        }
    }

    private fun imageChooser() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        launchSomeActivity.launch(i)
    }

    private var launchSomeActivity =
        registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                // do your operation from here....
                if (data != null &&
                    data.data != null
                ) {
                    selectedImageUri = data.data
                    try {
                        Picasso
                            .get()
                            .load(selectedImageUri)
                            .resize(300, 200)
                            .centerCrop()
                            .into(binding.optionMealFragmentUploadImage)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
}
