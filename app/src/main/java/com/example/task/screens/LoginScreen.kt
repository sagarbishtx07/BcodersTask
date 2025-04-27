package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastCbrt
import androidx.navigation.NavController
import com.example.task.R
import com.example.task.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
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
            Image(
                modifier = Modifier.align(Alignment.End).height(40.dp),
                painter = painterResource(id = R.drawable.cross),
                contentDescription = "Cross"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(44.dp),
                painter = painterResource(id = R.drawable.ic_yatts),
                contentDescription = "Cross"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Welcome Back",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 26.sp,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Please sign into your account",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.dark_gray),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = "JohnSmith123@gmail.com",
                onValueChange = { },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.2.dp,
                        color = colorResource(R.color.border_color),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.border_color),
                    focusedBorderColor = colorResource(R.color.theme_color)
                ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "mail icon",
                        modifier = Modifier.size(15.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = "******",
                onValueChange = { },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 0.5.dp,
                        color = colorResource(R.color.border_color),
                        shape = RoundedCornerShape(12.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = colorResource(R.color.border_color),
                    focusedBorderColor = colorResource(R.color.theme_color)
                ),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = "mail icon",
                        modifier = Modifier.size(15.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.visibility),
                        contentDescription = "password show/hide",
                        modifier = Modifier.size(18.dp)
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = { it ->

                    }
                )
                Spacer(
                    modifier = Modifier.width(5.dp)
                )
                Text(
                    "Remember me",
                    color = colorResource(R.color.text_color),
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "Forgot Password?",
                    color = colorResource(R.color.theme_color),
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate("profile_setup_screen")
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
                    text = "Sign In",
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f), // Occupy available space on the left
                    thickness = 0.5.dp,
                    color = colorResource(R.color.dark_gray)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "OR",
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.dark_gray)
                )
                Spacer(modifier = Modifier.width(8.dp))
                HorizontalDivider(
                    modifier = Modifier.weight(1f), // Occupy available space on the left
                    thickness = 0.5.dp,
                    color = colorResource(R.color.dark_gray)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    )
                ) {
                    Image(
                        modifier = Modifier
                            .padding(20.dp)
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.ic_apple),
                        contentDescription = "Apple Login"
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier.background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    )
                ) {
                    Image(
                        modifier = Modifier
                            .padding(20.dp)
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "Google Login"
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier.background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    )
                ) {
                    Image(
                        modifier = Modifier
                            .padding(20.dp)
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = "Facebook Login"
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(horizontal = 30.dp),
                thickness = 0.5.dp,
                color = colorResource(R.color.dark_gray)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Don't have an account ? ",
                    color = colorResource(R.color.text_color),
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
                Spacer(
                    modifier = Modifier.width(5.dp)
                )
                Text(
                    "Sign Up",
                    color = colorResource(R.color.theme_color),
                    fontSize = 12.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}