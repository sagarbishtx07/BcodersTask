package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.task.R
import com.example.task.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSetupScreen(
    navController: NavController
) {
    var selectedBox by remember { mutableStateOf<String?>("Man") }

    Surface(
        color = colorResource(R.color.whiteBg),
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.height(24.dp),
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = "Back Arrow"
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Image(
                    modifier = Modifier.height(60.dp),
                    painter = painterResource(R.drawable.ic_progress),
                    contentDescription = "Cross"
                )


            }

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Profile Setup",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 26.sp,
                ),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Let’s start by adding your personal details first.",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.dark_gray),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier.height(67.dp),
                painter = painterResource(R.drawable.ic_upload),
                contentDescription = "Back Arrow"
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = "John Smith",
                onValueChange = { },
                label = { Text("Full Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = colorResource(R.color.border_color2),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.border_color2),
                    focusedBorderColor = colorResource(R.color.theme_color)
                ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "mail icon",
                        modifier = Modifier.size(15.dp)
                    )
                }
            )
            Text(
                "Select Gender Selection",
                color = colorResource(R.color.text_color),
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    SelectableBox("Man", R.drawable.ic_person, selectedBox) {
                        selectedBox = it
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    SelectableBox("Woman", R.drawable.ic_person, selectedBox) {
                        selectedBox = it
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    SelectableBox("Gender Nonconforming", R.drawable.ic_mixed, selectedBox) {
                        selectedBox = it
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    SelectableBox("Other", null, selectedBox) {
                        selectedBox = it
                    }
                }
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            OutlinedTextField(
                value = "Choose Location",
                onValueChange = { },
                label = { Text("Location") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = colorResource(R.color.border_color2),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.border_color2),
                    focusedBorderColor = colorResource(R.color.theme_color)
                ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "mail icon",
                        modifier = Modifier.size(15.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_target),
                        contentDescription = "target icon",
                        modifier = Modifier.size(15.dp)
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            OutlinedTextField(
                value = "MM/DD/YYYY",
                onValueChange = { },
                label = { Text("DOB") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = colorResource(R.color.border_color2),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.border_color2),
                    focusedBorderColor = colorResource(R.color.theme_color)
                ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "calendar icon",
                        modifier = Modifier.size(15.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendar2),
                        contentDescription = "target icon",
                        modifier = Modifier.size(15.dp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate("home_screen")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.theme_color),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Next",
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun SelectableBox(
    title: String,
    icon: Int?,
    selectedTitle: String?,
    onSelect: (String) -> Unit
) {
    val isSelected = title == selectedTitle

    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) colorResource(id = R.color.theme_color) else colorResource(
                    id = R.color.whiteBg
                ),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onSelect(title) }
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row {
            if (icon != null) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "$title Icon",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = title,
                color = if (isSelected) Color.White else colorResource(R.color.text_color),
                fontSize = 12.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
