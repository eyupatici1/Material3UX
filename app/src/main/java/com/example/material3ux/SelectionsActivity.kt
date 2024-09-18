package com.example.material3ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.material3ux.ui.theme.Material3UXTheme

class SelectionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3UXTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        Checkboxes()
                    }
                }
            }
        }
    }
}

data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
private fun Checkboxes() {
    val checkboxes = remember {
        mutableStateListOf(
            ToggleableInfo(
                false,
                "Photos"
            ),
            ToggleableInfo(
                false,
                "Videos"
            ),
            ToggleableInfo(
                false,
                "Audio"
            )
        )
    }

    checkboxes.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = info.isChecked,
                onCheckedChange = { isChecked ->
                    checkboxes[index] = info.copy(isChecked = isChecked)
                }
            )
            Text(
                text = info.text
            )
        }
    }
}