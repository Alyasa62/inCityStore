package com.example.incitystore.Activities.Dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.incitystore.R
import com.example.incitystore.ui.theme.InCityStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           DashboardScreen()
        }
    }
}

@Composable
@Preview
fun DashboardScreen() {
        Scaffold(
            bottomBar = { BottomBarPreview() }
        ){ paddingValues ->
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.lightBlue))
                    .padding(paddingValues)
            ) {

            }
        }
}

