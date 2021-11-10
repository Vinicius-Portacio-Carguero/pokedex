package com.example.pokedex.utils

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseDialogFragmentBottomSheet() : BottomSheetDialogFragment() {
    protected open val cancelable = false

    protected open val fullscreen = false

    protected open val transparentBackground = false

    protected abstract fun getViewBottomSheet(): View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = getViewBottomSheet()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        if (dialog.window == null) return dialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(cancelable)
        dialog.setOnShowListener { expandSheet(dialog as BottomSheetDialog) }

        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
    }

    protected abstract fun setupViews(view: View)

    private fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    private fun expandSheet(dialog: BottomSheetDialog) {
        val bottomSheet =
            dialog.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
                ?: return
        if (fullscreen) bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        if (transparentBackground) bottomSheet.setBackgroundResource(android.R.color.transparent)

        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.peekHeight = getScreenHeight()
        behavior.isHideable = false
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    interface BaseBottomSheetInteractor

    protected var callback: ((BaseBottomSheetInteractor) -> Unit)? = null

    fun onClicked(callback: (BaseBottomSheetInteractor) -> Unit) {
        this.callback = callback
    }
}