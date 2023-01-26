package com.example.jetpackcomposedisabledissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedisabledissue.ui.theme.JetpackComposeDisabledIssueTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDisabledIssueTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val enabled: MutableState<Boolean> = remember { mutableStateOf(true) }

                    val onClick = {

                        enabled.value = !enabled.value
                    }

                    Box(
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            modifier = Modifier
                                .wrapContentSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {


                            val value: MutableState<String> = remember { mutableStateOf("") }

                            OutlinedTextField(
                                value = value.value,
                                onValueChange = {

                                    value.value = it
                                },
                                enabled = enabled.value
                            )

                            Divider(modifier = Modifier.padding(64.dp))

                            Button(onClick) {

                                val text = if (enabled.value) "Disable Text" else "Enable Text"

                                Text(text)
                            }
                        }
                    }
                }
            }
        }
    }
}