package pr.dwkim.themoviedatabase.util

import io.reactivex.rxjava3.core.Single

fun <T> Single<T>.with(schedulerProvider: ScheduleProvider): Single<T> =
    observeOn(schedulerProvider.ui())
        .subscribeOn(schedulerProvider.io())
