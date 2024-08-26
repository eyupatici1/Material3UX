package com.example.material3ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.material3ux.ui.theme.Material3UXTheme

class TextFieldsActivity : ComponentActivity() {
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
                            .padding(it),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var filledText by remember {
                            mutableStateOf("")
                        }
                        TextField(
                            value = filledText,
                            onValueChange = { filledText = it },
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Right
                            ),
                            label = {
                                Text(text = "Enter your weight")
                            },
                            /* placeholder = {
                                Text(text = "Weight")
                            } */                        // Use label or placeholder depending on the need
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.MonitorWeight,
                                    contentDescription = "Weight"
                                )
                            },
                            /* trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Weight"
                                )
                            } */                        // Use leadingIcon or trailingIcon depending on the need
                            /* prefix = {
                                Text(text = "kg")
                            }, */                        // Use prefix or suffix depending on the need
                            suffix = {
                                Text(text = "kg")
                            },
                            supportingText = {
                                Text(text = "*required")
                            },
                            isError = false,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions {
                                println("Next")         // For logging purposes
                            }
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        var outlinedText by remember {
                            mutableStateOf("")
                        }
                        OutlinedTextField(
                            value = outlinedText,
                            onValueChange = { outlinedText = it },
                            textStyle = LocalTextStyle.current.copy(
                                textAlign = TextAlign.Right
                            ),
                            label = {
                                Text(text = "Enter your height")
                            },
                            /* placeholder = {
                                Text(text = "Weight")
                            } */                        // Use label or placeholder depending on the need
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Height,
                                    contentDescription = "Height"
                                )
                            },
                            /* trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Weight"
                                )
                            } */                        // Use leadingIcon or trailingIcon depending on the need
                            /* prefix = {
                                Text(text = "cm")
                            }, */                        // Use prefix or suffix depending on the need
                            suffix = {
                                Text(text = "cm")
                            },
                            supportingText = {
                                Text(text = "*required")
                            },
                            isError = false,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions {
                                println("Next")         // For logging purposes
                            }
                        )
                    }
                }
            }
        }
    }
}