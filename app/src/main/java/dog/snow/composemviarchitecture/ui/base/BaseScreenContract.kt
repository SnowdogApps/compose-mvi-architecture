package dog.snow.composemviarchitecture.ui.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface BaseScreenContract<State, Effect> {
    val viewState: StateFlow<State>
    val effect: Flow<Effect>

    val errorState: StateFlow<ErrorState?>
        get() = MutableStateFlow<ErrorState?>(null)
}