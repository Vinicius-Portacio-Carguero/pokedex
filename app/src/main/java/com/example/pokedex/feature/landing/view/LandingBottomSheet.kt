package com.example.pokedex.feature.landing.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding.inflate
import com.example.pokedex.databinding.LandingBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import net.nuvem.mobile.carguero.presentation.view.BaseDialogFragmentBottomSheet

class LandingBottomSheet: BaseDialogFragmentBottomSheet() {
    override val cancelable = false
    override val transparentBackground = true
    override val fullscreen = true


    private var _binding: LandingBottomsheetBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = LandingBottomsheetBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun setupViews(view: View) {

        binding.btnSignin.setOnClickListener {
            dismiss()
        }

    }

    override fun getViewBottomSheet(): View = View
        .inflate(context, R.layout.landing_bottomsheet, null)


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}