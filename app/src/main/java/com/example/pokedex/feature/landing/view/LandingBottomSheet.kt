package com.example.pokedex.feature.landing.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.R
import com.example.pokedex.databinding.LandingBottomsheetBinding
import com.example.pokedex.utils.BaseDialogFragmentBottomSheet

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

    override fun setupViews(view: View) { binding.btnSignin.setOnClickListener { dismiss() } }

    override fun getViewBottomSheet(): View = View.inflate(context, R.layout.landing_bottomsheet, null)


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}