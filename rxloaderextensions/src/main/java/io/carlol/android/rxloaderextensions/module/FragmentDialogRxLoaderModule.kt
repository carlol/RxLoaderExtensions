package io.carlol.rxloaderextensions.module

import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import io.carlol.rxloaderextensions.module.interfaces.IRxLoaderModule
import io.carlol.rxloaderextensions.module.ui.WrapperLoaderDialogFragment

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