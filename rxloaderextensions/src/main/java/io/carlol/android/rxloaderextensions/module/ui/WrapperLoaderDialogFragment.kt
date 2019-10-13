package io.carlol.rxloaderextensions.module.ui

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

open class WrapperLoaderDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "WrapperLoaderDialogFragment"

        private const val BUNDLE_LAYOUT_RES_ID = "bundle_layout_res_id"

        fun newInstance(@LayoutRes layoutResId: Int) = WrapperLoaderDialogFragment().apply {
            arguments = Bundle().apply {
                putInt(BUNDLE_LAYOUT_RES_ID, layoutResId)
            }
        }

        fun show(activity: FragmentActivity, @LayoutRes layoutResId: Int) = synchronized(activity) {
            retrieveDialogFragment(
                activity
            )?.dismissAllowingStateLoss()
            newInstance(layoutResId).show(
                activity.supportFragmentManager,
                TAG
            )
        }

        fun dismiss(activity: FragmentActivity) = synchronized(activity) {
            retrieveDialogFragment(
                activity
            )?.dismissAllowingStateLoss()
        }

        private fun retrieveDialogFragment(activity: FragmentActivity): DialogFragment? {
            return activity.supportFragmentManager.findFragmentByTag(TAG)
                ?.takeIf { it is DialogFragment }
                ?.let { it as DialogFragment }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(arguments!!.getInt(BUNDLE_LAYOUT_RES_ID), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window!!.apply {
            requestFeature(Window.FEATURE_NO_TITLE)
            setBackgroundDrawable(ColorDrawable(0))
            setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        isCancelable = false
        view.setOnTouchListener { _, _ -> true } // disable touch
    }

}