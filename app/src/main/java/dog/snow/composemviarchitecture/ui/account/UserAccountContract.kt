package dog.snow.composemviarchitecture.ui.account

import dog.snow.composemviarchitecture.ui.base.BaseScreenContract

interface UserAccountContract :
    BaseScreenContract<UserAccountContract.State, UserAccountContract.Effect> {
    data class State(val username: String, val points: Long) {
        companion object {
            fun createInitial() = State("", 0L)
        }
    }

    fun addPoints()
    fun subtractPoints()
    fun goBack()
    fun changeUsername(username: String)
    fun showError()

    sealed class Effect {
        data object GoBack : Effect()
    }
}