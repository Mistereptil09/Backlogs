package com.esgi_4al1_grp_9.backlogs.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun HomeScreen() {
    Scaffold(
        topBar = {
            Text(
                "Home Screen",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(20.dp),
            )
        },
        bottomBar = {
            NavigationBar {
                Text("Empty NavBar")
            }
        },
    ) {
            innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) { Text("content") }
    }
}