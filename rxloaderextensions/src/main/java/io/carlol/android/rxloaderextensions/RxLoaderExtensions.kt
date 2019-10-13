package io.carlol.rxloaderextensions

import io.carlol.rxloaderextensions.module.interfaces.IRxLoaderModule
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created on 2019-10-02.
 */

fun Completable.manageLoading(module: IRxLoaderModule): Completable {
    return doOnSubscribe { module.startLoader() }
        .doOnDispose { module.stopLoader() }
        .doOnError { module.stopLoader() }
        .doOnComplete { module.stopLoader() }
}

fun <T> Single<T>.manageLoading(module: IRxLoaderModule): Single<T> {
    return doOnSubscribe { module.startLoader() }
        .doOnDispose { module.stopLoader() }
        .doOnError { module.stopLoader() }
        .doOnSuccess { module.stopLoader() }
}

fun <T> Maybe<T>.manageLoading(module: IRxLoaderModule): Maybe<T> {
    return doOnSubscribe { module.startLoader() }
        .doOnDispose { module.stopLoader() }
        .doOnError { module.stopLoader() }
        .doOnSuccess { module.stopLoader() }
}

fun <T> Observable<T>.manageLoading(module: IRxLoaderModule, stopOnNext: Boolean = false): Observable<T> {
    return doOnSubscribe { module.startLoader() }
        .doOnDispose { module.stopLoader() }
        .doOnError { module.stopLoader() }
        .doOnNext { if (stopOnNext) module.stopLoader() }
        .doOnComplete { module.stopLoader() }
}