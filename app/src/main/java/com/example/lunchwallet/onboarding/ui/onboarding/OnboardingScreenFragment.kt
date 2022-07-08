package com.example.lunchwallet.onboarding.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.lunchwallet.R
import com.example.lunchwallet.onboarding.adapter.SliderAdapter
import com.example.lunchwallet.onboarding.model.OnBoardingData


class OnboardingScreenFragment : Fragment() {

    private lateinit var onBoardingAdapter: SliderAdapter
    var onBoardingViewPager: ViewPager? = null
    var nextButton: Button? = null
    var skipButton: Button? = null
    var position = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton = view.findViewById(R.id.next_button)
        skipButton = view.findViewById(R.id.skip_button)

        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(
            OnBoardingData(
                "Choose Food",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_one
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Scan QR Code",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_two
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Enjoy Your Meal",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_three
            )
        )


        setOnboardingViewPagerAdapter(onBoardingData)


        position = onBoardingViewPager!!.currentItem

        skipButton?.setOnClickListener {
            if (position == onBoardingAdapter.count - 3) {
                onBoardingViewPager!!.currentItem = onBoardingData.size - 1
                nextButton!!.text = "Explore"
                skipButton!!.text = ""
            }
        }

        nextButton?.setOnClickListener {
            if (position < onBoardingAdapter.count - 1) {
                position++
                onBoardingViewPager!!.currentItem = position
            }

            if (position == onBoardingAdapter.count - 1) {
                nextButton!!.text = "Explore"
                skipButton!!.text = ""
            }
        }
    }

        private fun setOnboardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){
            onBoardingViewPager = view?.findViewById(R.id.viewPager)
            onBoardingAdapter = SliderAdapter(requireActivity(), onBoardingData)

            onBoardingViewPager!!.adapter = onBoardingAdapter
        }

}