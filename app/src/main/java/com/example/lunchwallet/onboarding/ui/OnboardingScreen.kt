package com.example.lunchwallet.onboarding.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager.widget.ViewPager
import com.example.lunchwallet.MainActivity
import com.example.lunchwallet.R
import com.example.lunchwallet.foodbeneficiary.ui.main.MainViewModel
import com.example.lunchwallet.onboarding.adapter.SliderAdapter
import com.example.lunchwallet.onboarding.model.OnBoardingData

class onboardingScreen : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var onBoardingAdapter: SliderAdapter
    var onBoardingViewPager: ViewPager? = null
    var nextButton: Button? = null
    var skipButton: Button? = null
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }
        }
        setContentView(R.layout.activity_onboarding_screen)



        nextButton = findViewById(R.id.next_button)
        skipButton = findViewById(R.id.skip_button)

        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Choose Food", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?", R.drawable.onboarding_screen_one))
        onBoardingData.add(OnBoardingData("Scan QR Code", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?", R.drawable.onboarding_screen_two))
        onBoardingData.add(OnBoardingData("Enjoy Your Meal", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?", R.drawable.onboarding_screen_three))

        onBoardingAdapter = SliderAdapter(this, onBoardingData)
        setOnboardingViewPagerAdapter(onBoardingData)


        position = onBoardingViewPager!!.currentItem

        skipButton?.setOnClickListener {
            if (position == onBoardingAdapter.count - 3){
                onBoardingViewPager!!.currentItem = onBoardingData.size - 1
                nextButton!!.text = "Explore"
                skipButton!!.text = ""
            }
        }

        nextButton?.setOnClickListener {
            if(position < onBoardingAdapter.count - 1){
                position++
                onBoardingViewPager!!.currentItem = position
            }

            if (position == onBoardingAdapter.count - 1){
                nextButton!!.text = "Explore"
                skipButton!!.text = ""
            }
        }

//        if (onBoardingViewPager!!.currentItem == 0){
//            nextButton!!.text = "Next"
//            skipButton!!.text = "Skip"
//        }
//
//        if (onBoardingViewPager!!.currentItem == 1){
//            nextButton!!.text = "Next"
//            skipButton!!.text = "Skip"
//        }

    }

    private fun setOnboardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){
        onBoardingViewPager = findViewById(R.id.viewPager)
        onBoardingAdapter = SliderAdapter(this, onBoardingData)

        onBoardingViewPager!!.adapter = onBoardingAdapter
    }
}