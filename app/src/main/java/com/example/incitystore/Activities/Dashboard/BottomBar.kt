package com.example.incitystore.Activities.Dashboard

import android.util.Printer
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.incitystore.R

@Composable
@Preview
fun BottomBarPreview() {
    val BottomMenuItemList = prepareBottomMenu()
    val context = androidx.compose.ui.platform.LocalContext.current
    var selected by remember { mutableStateOf("Home") }

    BottomAppBar(
        backgroundColor  = colorResource(R.color.white),
        elevation = 3.dp,
        contentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
    ) {
        BottomMenuItemList.forEach { bottomMenuItem ->
            BottomNavigationItem(
                selected = selected == bottomMenuItem.title,
                onClick = {
                    selected = bottomMenuItem.title
                    Toast.makeText(context, bottomMenuItem.title, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(painter = bottomMenuItem.icon as Painter, contentDescription = null,
                            tint = colorResource(R.color.darkBrown),
                            modifier = Modifier.padding(top = 8.dp)
                                .size(24.dp)
                                .padding(bottom = 4.dp)


                            )
                        androidx.compose.material.Text(
                            text = bottomMenuItem.title,
                            fontSize = 12.sp,
                            color = colorResource(R.color.darkBrown),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                },
            )
        }
        }
    }



data class BottomMenuItem(
    val title: String,
    val icon: Painter
)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val BottomMenuItemList = arrayListOf<BottomMenuItem>()

    BottomMenuItemList.add(BottomMenuItem("Home", painterResource(R.drawable.btn_1) ))
    BottomMenuItemList.add(BottomMenuItem("Support", painterResource(R.drawable.btn_2)))
    BottomMenuItemList.add(BottomMenuItem("Wishlist", painterResource(R.drawable.btn_3)))
    BottomMenuItemList.add(BottomMenuItem("Profile", painterResource(R.drawable.btn_4)))

    return BottomMenuItemList
}