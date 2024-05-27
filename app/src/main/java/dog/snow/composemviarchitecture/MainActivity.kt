package dog.snow.composemviarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dog.snow.composemviarchitecture.ui.account.UserAccountScreen
import dog.snow.composemviarchitecture.ui.account.UserAccountViewModel
import dog.snow.composemviarchitecture.ui.theme.ComposemviarchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposemviarchitectureTheme {
                val viewModel: UserAccountViewModel by viewModels()
                UserAccountScreen(contract = viewModel, goBack = {})
            }
        }
    }
}