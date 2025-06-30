package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class BottomNavBarExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                BottomNavBarApp()
            }
        }
    }
}

data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNum: Int
)

@Composable
fun BottomNavBarApp(
    modifier: Modifier = Modifier
) {
    val items = listOf(
        NavItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeNum = 0
        ),
        NavItemState(
            title = "Inbox",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasBadge = true,
            badgeNum = 20
        ),
        NavItemState(
            title = "Account",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasBadge = true,
            badgeNum = 0
        )
    )

    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                containerColor = Color.Blue
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = {bottomNavState = index},
                        icon = {
                            BadgedBox(badge = {
                                if (item.hasBadge) Badge{}
                                if (item.badgeNum != 0) Badge {
                                    Text(text = item.badgeNum.toString())
                                }
                            }) {
                                Icon(
                                   imageVector = if (bottomNavState == index) {
                                       item.selectedIcon
                                   } else {
                                       item.unselectedIcon
                                   },
                                    contentDescription = item.title
                                )
                            }
                        },
                        label = {
                            Text(text = item.title)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,
                            unselectedIconColor = Color.White,
                            indicatorColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedTextColor = Color.White
                        )
                    )
                }
            }
        }
    ) { contentPadding ->
        Column(
            modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = items[bottomNavState].title,
                fontWeight = FontWeight.Bold,
                fontSize = 44.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBarApp()
}