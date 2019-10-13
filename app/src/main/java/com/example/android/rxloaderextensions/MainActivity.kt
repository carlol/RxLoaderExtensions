package com.example.android.rxloaderextensions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.rxloaderextensions.custom.ExampleCustomFragmentDialogModule
import io.carlol.rxloaderextensions.manageLoading
import io.carlol.rxloaderextensions.module.FragmentDialogRxLoaderModule
import io.carlol.rxloaderextensions.module.ViewRxLoaderModule
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var disposables: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposables = CompositeDisposable()

        btnLoaderTriggerView_1.setOnClickListener {
            disposables.add(
                Single.timer(5, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .manageLoading(
                        FragmentDialogRxLoaderModule(
                            this,
                            R.layout.dialog_fragment_wrapper_loader_example
                        )
                    )
                    .subscribe()
            )
        }

        btnLoaderTriggerView_2.setOnClickListener {
            disposables.add(
                Single.timer(5, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .manageLoading(ExampleCustomFragmentDialogModule(this))
                    .subscribe()
            )
        }

        btnLoaderTriggerView_3.setOnClickListener {
            disposables.add(
                Single.timer(5, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .manageLoading(ViewRxLoaderModule(customLoaderView))
                    .subscribe()
            )
        }
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

}
