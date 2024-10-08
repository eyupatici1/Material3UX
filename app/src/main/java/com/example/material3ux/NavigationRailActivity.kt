package com.example.material3ux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MarkEmailUnread
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.material3ux.ui.theme.Material3UXTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

// Use only for screen sizes bigger than "Compact" size eg. tablets

data class NavRailItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class NavigationRailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationRailM3()
        }
    }
}

@Composable
fun NavigationRailM3() {
    Material3UXTheme {
        val items = listOf(
            NavRailItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false
            ),
            NavRailItem(
                title = "Chat",
                selectedIcon = Icons.Filled.MarkEmailUnread,
                unselectedIcon = Icons.Outlined.MarkEmailUnread,
                hasNews = false,
                badgeCount = 12
            ),
            NavRailItem(
                title = "Settings",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true
            )
        )

        //val windowClass = calculateWindowSizeClass(NavigationRailActivity())
        //val showNavRail =
        //windowClass.widthSizeClass > WindowWidthSizeClass.Compact
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        Scaffold(
            bottomBar = {
                /* if(!showNavRail) {
                    // Navigation bar implementation needed
                } */
            },
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(start = 80.dp)
            ) {
                items(100) {
                    Text(
                        text = "Item $it",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            Row {
                NavigationSideBar(
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    onNavigate = { selectedItemIndex = it }
                )
                VerticalDivider(
                    thickness = 0.7.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                )
            }
            /* if(showNavRail) {

            } */
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun NavigationRailM3Preview() {
    NavigationRailM3()
}

@Composable
fun NavigationSideBar(
    items: List<NavRailItem>,
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit
) {
    NavigationRail(
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "More"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(
                12.dp,
                Alignment.Bottom
            )
        ) {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected = index == selectedItemIndex,
                    onClick = { onNavigate(index) },
                    icon = {
                        NavigationIcon(
                            item = item,
                            selected = index == selectedItemIndex
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun NavigationIcon(
    item: NavRailItem,
    selected: Boolean
) {
    BadgedBox(
        badge = {
            if (item.badgeCount != null) {
                Badge {
                    Text(text = item.badgeCount.toString())
                }
            }
            if (item.hasNews) Badge()
        }
    ) {
        Icon(
            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
            contentDescription = item.title
        )
    }
}