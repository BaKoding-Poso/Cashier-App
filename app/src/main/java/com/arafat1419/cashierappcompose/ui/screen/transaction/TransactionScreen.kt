package com.arafat1419.cashierappcompose.ui.screen.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.components.ActiveFilterItem
import com.arafat1419.cashierappcompose.ui.components.FilterDialog
import com.arafat1419.cashierappcompose.ui.components.StuffItem
import com.arafat1419.cashierappcompose.ui.components.TransactionItem
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun TransactionScreen(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TransactionMainScreen(
            modifier = modifier
                .weight(3f)
        )
        TransactionSideScreen(
            modifier = modifier
                .background(color = colorResource(id = R.color.white))
                .weight(1f)
                .fillMaxHeight()
        )
    }
}

@Composable
fun TransactionMainScreen(
    modifier: Modifier = Modifier
) {
    val listOfFilter = arrayListOf("Paku", "Kayu", "Batu Bata", "Paku1", "Kayu1", "Batu Bata1", "Paku2", "Kayu2", "Batu Bata2")
    val listOfContent = (0..10).toList()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = "",
                onValueChange = { },
                placeholder = {
                    Text(
                        text = "Cari sesuatu disini...",
                        color = colorResource(id = R.color.dark_gray)
                    )
                },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search",
                        tint = colorResource(id = R.color.dark_gray)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = colorResource(id = R.color.white),
                ),
                modifier = modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
            )
            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.white),
                ),
                contentPadding = PaddingValues(0.dp),
                elevation = ButtonDefaults.elevation(0.dp),
                modifier = Modifier.size(48.dp),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.FilterAlt,
                    contentDescription = stringResource(id = R.string.sign_out),
                    tint = colorResource(id = R.color.dark_gray),
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(listOfFilter, key = { it }) { item ->
                ActiveFilterItem(title = item, onCloseClicked = {
                })
            }
        }
        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            columns = GridCells.Fixed(2),
            modifier = modifier.padding(vertical = 8.dp)
        ) {
            items(listOfContent, key = { it }) {
                StuffItem()
            }
        }
    }
}

@Composable
fun TransactionSideScreen(
    modifier: Modifier = Modifier
) {
    val listOfContent = (0..10).toList()

    Column(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Transaksi",
                style = MaterialTheme.typography.h6
            )
            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.c_red),
                ),
                contentPadding = PaddingValues(0.dp),
                elevation = ButtonDefaults.elevation(0.dp),
                modifier = Modifier.size(48.dp),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Outlined.DeleteForever,
                    contentDescription = stringResource(id = R.string.delete_all),
                    tint = colorResource(id = R.color.white),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(listOfContent, key = { it }) { item ->
                TransactionItem()
            }
        }

        Divider(
            color = colorResource(id = R.color.gray),
            thickness = 0.5.dp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Total Harga",
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = "Rp. 1.000.000",
                style = MaterialTheme.typography.h6
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Bayar (10)",
                style = MaterialTheme.typography.h6,
                color = colorResource(id = R.color.white)
            )
        }
    }
}

@Preview(showSystemUi = true, device = Devices.NEXUS_10)
@Composable
private fun TransactionPreview() {
    CashierAppComposeTheme {
        TransactionScreen()
    }
}