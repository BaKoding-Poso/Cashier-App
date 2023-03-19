package com.arafat1419.cashierappcompose.ui.screen.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.screen.cashier.CashierItem
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.c_green),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 8.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 8.dp
                        )
                    )
                    .align(Alignment.TopEnd)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Selesai",
                    style = MaterialTheme.typography.body2,
                    color = colorResource(id = R.color.white),
                )
            }
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                Text(
                    text = "#INV-01-001",
                    style = MaterialTheme.typography.caption,
                    color = colorResource(id = R.color.orange_500),
                )
                Text(
                    text = "Mohammad Arafat Maku",
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = "Rp. 800.000",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.white_background),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = colorResource(id = R.color.orange_200),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.CalendarToday,
                                contentDescription = stringResource(id = R.string.date),
                                tint = colorResource(id = R.color.black),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "10 Februari 2022",
                                style = MaterialTheme.typography.body2,
                                color = colorResource(id = R.color.black),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = colorResource(id = R.color.white_background),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = colorResource(id = R.color.orange_200),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AccessTime,
                                contentDescription = stringResource(id = R.string.time),
                                tint = colorResource(id = R.color.black),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "21:24",
                                style = MaterialTheme.typography.body2,
                                color = colorResource(id = R.color.black),
                            )
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        CashierItem()
    }
}