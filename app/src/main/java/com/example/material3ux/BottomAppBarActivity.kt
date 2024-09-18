package com.example.material3ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.material3ux.ui.theme.Material3UXTheme

class BottomAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomAppBarM3()
        }
    }
}

// Bottom app bar should be only used if you will have 3 or more actions in it
// If there are more than 3 actions then same rules apply as the top app bar
// that we should use pop-up menu for the most prominent action

@Composable
fun BottomAppBarM3() {
    Material3UXTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomAppBar(
                    actions = {
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search a contact"
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share the contact"
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "Mark as favourite"
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "E-mail the contact"
                            )
                        }
                    },
                    floatingActionButton = {
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call the contact"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun BottomAppBarM3Preview() {
    BottomAppBarM3()
}