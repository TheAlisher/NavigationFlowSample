package com.alish.navigationflowsample.presentation.ui.fragments.sign.`in`

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.navigationflowsample.R
import com.alish.navigationflowsample.data.local.UserData
import com.alish.navigationflowsample.databinding.FragmentSignInBinding
import com.alish.navigationflowsample.presentation.extensions.activityNavController
import com.alish.navigationflowsample.presentation.extensions.navigateSafely

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        clickSignIn()
        clickSignUp()
    }

    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            UserData.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
    }

    private fun clickSignUp() {
        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
}