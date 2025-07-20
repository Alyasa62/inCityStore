package com.example.incitystore.Activities.Dashboard

import android.R.attr.category
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.incitystore.Domain.CategoryModel
import com.example.incitystore.R

@Composable
fun CategorySection(
    categories: SnapshotStateList<CategoryModel>, showCategoryLoading: Boolean,
    modifier: Modifier = Modifier,
    onItemClick: (CategoryModel) -> Unit
) {
   Text(
       text= "Categories",
         fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
         modifier = Modifier.padding(horizontal =  16.dp)
       .padding(top = 24.dp)
   )

    if(showCategoryLoading){
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            CircularProgressIndicator(
                color = colorResource(id = R.color.blue),
                modifier = Modifier.size(50.dp)
            )
        }
    }
    else {
        val rows = categories.chunked(3)
        val context= LocalContext.current

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            rows.forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                ) {
                    row.forEachIndexed {
                        index, categoryModel ->
                        CategoryItem(
                            category = categoryModel,
                            modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                            OnItemClick = {
                                onItemClick(categoryModel)
                            }
                        )


                    }

                }
            }
        }
    }

}

@Composable
fun CategoryItem(
    category: CategoryModel,
    modifier: Modifier=Modifier,
    OnItemClick: () -> Unit

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.white),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = OnItemClick)
            .padding(8.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,

        ) {

        AsyncImage(
            model = category.imagePath,
            contentDescription = null,
            modifier = Modifier
                .size(65.dp)
        )

        Text(
            text = category.name,
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.black),
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
        )

    }



}