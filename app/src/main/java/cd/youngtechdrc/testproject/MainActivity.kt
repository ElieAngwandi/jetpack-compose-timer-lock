package cd.youngtechdrc.testproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cd.youngtechdrc.testproject.ui.theme.TestProjectTheme
import java.util.concurrent.TimeUnit
import androidx.core.content.edit

class MainActivity : ComponentActivity() {

    private val prefsName = "app_prefs"
    private val lastLaunchTimeKey = "last_launch_time"
    private val oneHourInMillis = TimeUnit.HOURS.toMillis(1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(prefsName, MODE_PRIVATE)
        val lastLaunchTime = sharedPreferences.getLong(lastLaunchTimeKey, 0)
        val currentTime = System.currentTimeMillis()

        var showUpdateScreen = false

        if (lastLaunchTime == 0L) {
            // First launch
            sharedPreferences.edit {
                putLong(lastLaunchTimeKey, currentTime)
            }
        } else {
            // Subsequent launches
            if (currentTime - lastLaunchTime > oneHourInMillis) {
                showUpdateScreen = true
            }
        }

        setContent {
            TestProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (showUpdateScreen) {
                        UpdateScreen()
                    } else {
                        WelcomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the App!",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun UpdateScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App Update Required",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "A mandatory update is required to continue using the app.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = { /* Dummy action */ },
        ) {
            Text("Update Now")
        }
    }
}

@Preview(showBackground = true, name = "Welcome Screen Preview")
@Composable
fun WelcomeScreenPreview() {
    TestProjectTheme {
        WelcomeScreen()
    }
}

@Preview(showBackground = true, name = "Update Screen Preview")
@Composable
fun UpdateScreenPreview() {
    TestProjectTheme {
        UpdateScreen()
    }
}
