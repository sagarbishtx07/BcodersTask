package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun HomeScreen(
    navController: NavController
) {
    var search by remember { mutableStateOf("") }
    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.gradientColor1),
                            colorResource(R.color.gradientColor2)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_fingerprint),
                        modifier = Modifier.size(41.dp),
                        contentDescription = "Icon Fingerprint"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Welcome Back",
                            style = TextStyle(
                                color = colorResource(R.color.textColor2),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp,
                            ),
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Joseph",
                            style = TextStyle(
                                color = Color.Black,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 19.sp,
                            ),
                            textAlign = TextAlign.Start
                        )
                    }
                    Image(
                        modifier = Modifier.size(38.dp),
                        painter = painterResource(R.drawable.ic_notificationone),
                        contentDescription = "Icon Notification"
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = Color.White)
                ) {
                    TextField(
                        value = search,
                        onValueChange = {search = it },
                        label = { Text("Search") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(20.dp),
                                width = 0.dp
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            disabledTextColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(20.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "mail icon",
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Recommended Studio",
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "See More",
                        fontFamily = poppinsFontFamily,
                        fontSize = 10.sp,
                        color = colorResource(R.color.textColor3),
                        fontWeight = FontWeight.Medium
                    )
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 1.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(5) { index: Int ->
                        CardItem()
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Top Talents",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        ImageCircle("John virk", R.drawable.ic_personfirst)
                        Spacer(modifier = Modifier.width(5.dp))
                        ImageCircle("Harry", R.drawable.ic_person2)
                        Spacer(modifier = Modifier.width(5.dp))
                        ImageCircle("Berry", R.drawable.ic_person3)
                        Spacer(modifier = Modifier.width(5.dp))
                        ImageCircle("Verry", R.drawable.ic_person4)
                        Spacer(modifier = Modifier.width(5.dp))
                        ImageCircle("Nopand", R.drawable.ic_person5)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Featured Artist",
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "See More",
                        fontFamily = poppinsFontFamily,
                        fontSize = 10.sp,
                        color = colorResource(R.color.textColor3),
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    FeaturedArtists(R.drawable.featuredartist1,Modifier.height(150.dp).fillMaxWidth().weight(1f))
                    Spacer(modifier = Modifier.width(10.dp))
                    FeaturedArtists(R.drawable.featuredartist2, Modifier.height(150.dp).fillMaxWidth().weight(1f))
                }
            }
        }
    }
}

@Composable
fun CardItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image1), // Replace with your actual image
                    contentDescription = "Main Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(360.dp)
                        .height(127.dp)
                        .clip(RoundedCornerShape(12.dp))
                )

                Box(
                    modifier = Modifier
                        .background(color = colorResource(R.color.cardPurple),
                            shape = RoundedCornerShape(20.dp))
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                ) {
                    Text(
                        text = " \$ 80.0/hr",
                        fontSize = 11.sp,
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.background(color = colorResource(R.color.cardPurple))
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image2), // Replace with your icon
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                ) {
                    Text(
                        text = "Atlanta Studio",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Text(
                        text = " 106 Street Edmonton, Alberta",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.star4), // Another image
                    contentDescription = "Extra Image",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "4.0",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.colorYellow),
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_time), // Another image
                            contentDescription = "Extra Image",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "09:00 AM - 10:00 PM",
                            fontSize = 12.sp,
                            color = colorResource(R.color.textYellow)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(R.color.colorGreen),
                            shape = RoundedCornerShape(20.dp)
                        ),

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_review), // Another image
                            contentDescription = "Extra Image",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "457 reviews",
                            fontSize = 12.sp,
                            color = colorResource(R.color.textGreen)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCircle(
    name: String,
    image: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = name,
            modifier = Modifier
                .size(45.dp) // You can adjust the size
                .clip(CircleShape)
                .background(Color.Gray), // optional background
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp)) // Small space between image and text
        Text(
            text = name,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            fontSize = 10.sp
        )
    }
}

@Composable
fun FeaturedArtists(image: Int, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image), // Replace with your actual image
            contentDescription = "Main Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(127.dp)
                .clip(RoundedCornerShape(12.dp))

        )

        Box(
            modifier = Modifier
                .background(color = colorResource(R.color.cardPurple),
                    shape = RoundedCornerShape(20.dp))
                .align(Alignment.BottomCenter)
                .padding(5.dp)
        ) {
            Text(
                text = "\$ 77.00 - \$ 80.00",
                fontSize = 11.sp,
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.background(color = colorResource(R.color.cardPurple))
            )
        }
    }
}