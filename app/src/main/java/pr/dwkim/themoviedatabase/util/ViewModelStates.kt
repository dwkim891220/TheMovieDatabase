package pr.dwkim.themoviedatabase.util

/**
 * Abstract ViewModel State
 */
open class ViewModelState

/**
 * Generic Loading ViewModel State
 */
object LoadingState : ViewModelState()

/**
 * Generic Error ViewModel State
 * @param error - caught error
 */
open class ErrorState(val error: Throwable) : ViewModelState()

data class ShowToast(val message: String?) : ViewModelState()

data class ShowDialog(val message: String?) : ViewModelState()