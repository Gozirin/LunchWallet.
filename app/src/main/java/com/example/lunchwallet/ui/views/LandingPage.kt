package com.example.lunchwallet.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.databinding.FragmentLandingPageBinding
import com.example.lunchwallet.ui.adapter.LandingPageMealsPagerAdapter

class LandingPage : Fragment() {
    private lateinit var binding: FragmentLandingPageBinding
    private lateinit var landingPageMealsRecyclerView: RecyclerView

    companion object {
        fun newInstance() = LandingPage()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingPageBinding.inflate(layoutInflater, container, false)

        landingPageMealsRecyclerView = binding.landingPageMealsRecyclerView
        landingPageMealsRecyclerView.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.HORIZONTAL, false)

        landingPageMealsRecyclerView.adapter = LandingPageMealsPagerAdapter()

        return binding.root
    }
}
