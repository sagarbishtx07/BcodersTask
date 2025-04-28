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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import com.example.task.CompletedBookingModel
import com.example.task.R
import com.example.task.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    navController: NavController
) {
    var search by remember { mutableStateOf("") }
    val completedBookings = listOf(
        CompletedBookingModel(
            artistName = "Artist Name",
            artistId = "#4556/1",
            date = "Monday, August 19",
            style = "Blackwork (14 hrs)",
            rating = 4.0f,
            price = "$12/hour",
            status = "Completed",
            statusColor = R.color.textGreen,
            artistImage = R.drawable.ic_artist
        ),
        CompletedBookingModel(
            artistName = "Artist Name",
            artistId = "#4556/1",
            date = "Monday, August 19",
            style = "Blackwork (14 hrs)",
            rating = 0.0f,
            price = "$12/hour",
            status = "Cancelled",
            statusColor = R.color.textCancel,
            artistImage = R.drawable.ic_artist
        ),
        CompletedBookingModel(
            artistName = "Artist Name",
            artistId = "#4556/1",
            date = "Monday, August 19",
            style = "Blackwork (14 hrs)",
            rating = 4.0f,
            price = "$12/hour",
            status = "Completed",
            statusColor = R.color.textGreen,
            artistImage = R.drawable.ic_artist
        ),
        CompletedBookingModel(
            artistName = "Artist Name",
            artistId = "#4556/1",
            date = "Monday, August 19",
            style = "Blackwork (14 hrs)",
            rating = 4.0f,
            price = "$12/hour",
            status = "Completed",
            statusColor = R.color.textGreen,
            artistImage = R.drawable.ic_artist
        )
    )

    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
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
            LazyColumn(
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Booking",
                            style = TextStyle(
                                color = Color.Black,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 19.sp,
                            ),
                            textAlign = TextAlign.Start
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                        Image(
                            modifier = Modifier.size(38.dp),
                            painter = painterResource(R.drawable.ic_notificationone),
                            contentDescription = "Icon Notification"
                        )
                    }
                }

                item {
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(color = Color.White)
                    ) {
                        TextField(
                            value = search,
                            onValueChange = { search = it },
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
                                    contentDescription = "Search icon",
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        )
                    }
                }

                item {
                    Text(
                        text = "Today’s Appointment",
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                item {
                    BookingCard(
                        artistName = "Artist Name",
                        artistId = "#4556/1",
                        timeRange = "10:00 AM - 12:00 PM (6hrs)",
                        date = "Monday, August 19",
                        style = "Blackwork",
                        hourlyRate = "$12/hour",
                        daysLeft = "08",
                        hoursLeft = "08",
                        minutesLeft = "26",
                        artistImage = R.drawable.ic_artist,
                        status = "In_Progress",
                        statusColor1 = R.color.textYellow,
                        statusColor2 = R.color.colorYellow
                    )
                }

                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Upcoming Appointments",
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
                }

                item {
                    BookingCard(
                        artistName = "Artist Name",
                        artistId = "#4556/1",
                        timeRange = "10:00 AM - 12:00 PM (6hrs)",
                        date = "Monday, August 19",
                        style = "Blackwork",
                        hourlyRate = "$12/hour",
                        daysLeft = "08",
                        hoursLeft = "08",
                        minutesLeft = "26",
                        artistImage = R.drawable.ic_artist,
                        status = "Scheduled",
                        statusColor1 = R.color.textBlue,
                        statusColor2 = R.color.colorBlue
                    )
                }

                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Bookings",
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
                }
                items(completedBookings.size) { index: Int ->
                    CompletedBookingCard(completedBookings[index])
                }
            }
        }
    }
}


@Composable
fun BookingCard(
    artistName: String,
    artistId: String,
    timeRange: String,
    date: String,
    style: String,
    hourlyRate: String,
    daysLeft: String,
    hoursLeft: String,
    minutesLeft: String,
    artistImage: Int,
    status: String,
    statusColor1: Int,
    statusColor2: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 2.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 5.dp, horizontal = 5.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(artistImage),
                contentDescription = "Artist Image",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "$artistName ($artistId)",
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Text(
                    text = timeRange,
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.textColor4)
                )
                Text(
                    text = date,
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.textColor4)
                )
                Text(
                    text = style,
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.textColor4)
                )
            }
            Box(
                modifier = Modifier
                    .background(colorResource(statusColor2), shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 1.dp)
            ) {
                Text(
                    text = status,
                    color = colorResource(statusColor1),
                    fontFamily = poppinsFontFamily,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = hourlyRate,
                fontFamily = poppinsFontFamily,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(R.color.textColor4)
            )
        }
        HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CountdownItem(count = daysLeft, label = "Days")
            CountdownItem(count = hoursLeft, label = "Hours")
            CountdownItem(count = minutesLeft, label = "Minutes")
        }
    }
}

@Composable
fun CountdownItem(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFF6F6F6), shape = RoundedCornerShape(12.dp))
            .padding(vertical = 5.dp, horizontal = 4.dp)
    ) {
        Text(
            text = count,
            fontFamily = poppinsFontFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Text(
            text = label,
            fontFamily = poppinsFontFamily,
            color = colorResource(R.color.textColor4),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun CompletedBookingCard(
    bookingModel: CompletedBookingModel
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = bookingModel.artistImage),
                contentDescription = "Artist Image",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = bookingModel.artistName,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = bookingModel.artistId,
                        style = TextStyle(
                            fontSize = 10.sp,

                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = Color.Gray
                        )
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = bookingModel.date,
                    style = TextStyle(
                        fontSize = 10.sp,

                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = bookingModel.style,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(horizontalAlignment = Alignment.End) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(colorResource(bookingModel.statusColor).copy(alpha = 0.2f))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = bookingModel.status,
                        style = TextStyle(
                            color = colorResource(bookingModel.statusColor),
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) { index ->
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Star",
                            tint = if (index < bookingModel.rating.toInt()) Color(0xFFFFC107) else Color.LightGray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = String.format("%.1f", bookingModel.rating),
                        fontSize = 10.sp,

                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = bookingModel.price,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}



