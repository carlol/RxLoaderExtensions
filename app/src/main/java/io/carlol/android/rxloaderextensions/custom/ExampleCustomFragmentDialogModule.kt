package io.carlol.android.rxloaderextensions.custom

import androidx.fragment.app.FragmentActivity
import com.example.rxloaderextensions.module.FragmentDialogRxLoaderModule
import io.carlol.android.rxloaderextensions.R

/**
 * Created on 2019-10-02.
 */
class ExampleCustomFragmentDialogModule(fragmentActivity: FragmentActivity): FragmentDialogRxLoaderModule(fragmentActivity, R.layout.dialog_fragment_wrapper_loader_example_external_lib)