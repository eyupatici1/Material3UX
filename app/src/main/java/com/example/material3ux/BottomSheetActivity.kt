package com.example.material3ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.material3ux.ui.theme.Material3UXTheme

class BottomSheetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetM3()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetM3() {
    Material3UXTheme {

        val modalSheetState = rememberModalBottomSheetState()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ModalBottomSheet(
                sheetState = modalSheetState,
                onDismissRequest = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(R.drawable.kermit),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}