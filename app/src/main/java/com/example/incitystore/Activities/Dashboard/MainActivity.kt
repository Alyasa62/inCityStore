package com.example.incitystore.Activities.Dashboard

import DashboardRepository
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.incitystore.Domain.CategoryModel
import com.example.incitystore.R
import com.example.incitystore.ui.theme.InCityStoreTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

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
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = colorResource(id = R.color.blue))

    val viewModel = DashboardRepository()
    val categories = remember { mutableStateListOf<CategoryModel>() }

    var showCategoryLoading by remember { mutableStateOf(true) }

    LaunchedEffect  (Unit){
        viewModel.loadCategories().observeForever { categoryList ->
            if (categoryList != null) {
                categories.clear()
                categories.addAll(categoryList)
                showCategoryLoading = false
            } else {
                showCategoryLoading = true
            }
        }
    }


        Scaffold(
            bottomBar = { BottomBarPreview() }
        ){ paddingValues ->
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.lightBlue))
                    .padding(paddingValues)
            ) {
                item { TopBar() }
                item { CategorySection(categories, showCategoryLoading) { }
                }

            }
        }
}

