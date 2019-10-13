package com.example.rxloaderextensions.module

import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import com.example.rxloaderextensions.module.interfaces.IRxLoaderModule
import com.example.rxloaderextensions.module.ui.WrapperLoaderDialogFragment

/**
 * Created on 2019-10-02.
 */
open class FragmentDialogRxLoaderModule(
    protected val fragmentActivity: FragmentActivity
    , @LayoutRes protected val layoutResId: Int
) : IRxLoaderModule {

    override fun startLoader() {
        WrapperLoaderDialogFragment.show(fragmentActivity, layoutResId)
    }

    override fun stopLoader() {
        WrapperLoaderDialogFragment.dismiss(fragmentActivity)
    }

}