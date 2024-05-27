package dog.snow.composemviarchitecture.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import dog.snow.composemviarchitecture.ui.components.ErrorDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun <State, Effect, Contract : BaseScreenContract<State, Effect>> BaseScreen(
    contract: Contract,
    onEffect: (Effect) -> Unit,
    content: @Composable (state: State) -> Unit,
) {
    val state = contract.viewState.collectAsState()

    Box {
        content(state.value)

        val error = contract.errorState.collectAsState().value
        if (error != null) {
            when (error.type) {
                ErrorDialogType.COMMON -> ErrorDialog(error)
            }
        }
    }

    LaunchedEffect(Unit) {
        contract.effect.onEach(onEffect).launchIn(this)
    }
}