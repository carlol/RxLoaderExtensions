package com.example.rxloaderextensions.module

import android.view.View
import com.example.rxloaderextensions.module.interfaces.IRxLoaderModule

/**
 * Created on 2019-10-02.
 */
open class ViewRxLoaderModule(protected val view: View) : IRxLoaderModule {

    override fun startLoader() {
        view.visibility = View.VISIBLE
    }

    override fun stopLoader() {
        view.visibility = View.GONE
    }

}