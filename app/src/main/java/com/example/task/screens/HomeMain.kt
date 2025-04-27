package com.example.task.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.task.R
import com.example.task.ui.theme.poppinsFontFamily

@Composable
fun HomeMain(
    navController: NavController
) {
    val selectedIndex = remember { mutableStateOf(2) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { selectedIndex.value = 2 },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.Unspecified
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bottomnavcenter),
                    contentDescription = "Center Button",
                    modifier = Modifier.size(55.dp),
                    tint = Color.Unspecified
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                tonalElevation = 8.dp,
                actions = {
                    Spacer(Modifier.width(10.dp))
                    BottomNavigationItem(
                        icon = Icons.Default.DateRange,
                        label = "Booking",
                        selected = selectedIndex.value == 0
                    ) {
                        selectedIndex.value = 0
                    }
                    Spacer(Modifier.width(10.dp))
                    BottomNavigationItem(
                        icon = Icons.Default.Search,
                        label = "Search",
                        selected = selectedIndex.value == 1
                    ) {
                        selectedIndex.value = 1
                    }
                    Spacer(Modifier.weight(1f)) // Space for center FAB
                    BottomNavigationItem(
                        icon = Icons.Outlined.MailOutline,
                        label = "Profile",
                        selected = selectedIndex.value == 3
                    ) {
                        selectedIndex.value = 3
                    }
                    Spacer(Modifier.width(10.dp))
                    BottomNavigationItem(
                        icon = Icons.Outlined.Person,
                        label = "Settings",
                        selected = selectedIndex.value == 4
                    ) {
                        selectedIndex.value = 4
                    }
                    Spacer(Modifier.width(10.dp))
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedIndex.value) {
                0 -> BookingScreen(navController)
                else -> HomeScreen(navController)
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) colorResource(R.color.theme_color) else Color.Gray
            )
        }
        Text(
            text = label,
            fontFamily = poppinsFontFamily,
            fontSize = 8.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected) colorResource(R.color.theme_color) else Color.Gray
        )
    }
}