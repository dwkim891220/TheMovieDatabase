package pr.dwkim.themoviedatabase.util

import io.reactivex.rxjava3.core.Single

fun <T> Single<T>.with(schedulerProvider: SchedulerProvider): Single<T> =
    observeOn(schedulerProvider.ui())
        .subscribeOn(schedulerProvider.io())
