package com.arafat1419.cashierappcompose.ui.screen.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
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
import com.arafat1419.cashierappcompose.ui.components.SideTransaction
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme
import com.arafat1419.cashierappcompose.utils.VarUtils

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        HistoryMainScreen(
            modifier = modifier
                .weight(2.5f)
        )
        SideTransaction(
            modifier = modifier
                .background(color = colorResource(id = R.color.white))
                .weight(1f)
                .fillMaxHeight(),
            trxType = VarUtils.PENDING
        )
    }
}

@Composable
fun HistoryMainScreen(
    modifier: Modifier = Modifier
) {
    val listOfFilter = arrayListOf(
        "Paku",
        "Kayu",
        "Batu Bata",
        "Paku1",
        "Kayu1",
        "Batu Bata1",
        "Paku2",
        "Kayu2",
        "Batu Bata2"
    )
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
                    androidx.compose.material3.Text(
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
                HistoryItem()
            }
        }
    }
}

@Preview(showSystemUi = true, device = Devices.NEXUS_10)
@Composable
private fun TransactionPreview() {
    CashierAppComposeTheme {
        HistoryScreen()
    }
}