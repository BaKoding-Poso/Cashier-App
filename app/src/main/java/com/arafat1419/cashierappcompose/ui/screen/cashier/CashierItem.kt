package com.arafat1419.cashierappcompose.ui.screen.cashier

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun CashierItem(
    modifier: Modifier = Modifier
) {
    val listOfCategories = arrayListOf("Pcs", "Paku")

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
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "#P-01-001",
                style = MaterialTheme.typography.caption,
                color = colorResource(id = R.color.orange_500),
            )
            Text(
                text = "Paku Tembok Cina Gembok Astaga",
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = "Rp. 200.000",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Stok: 100",
                    style = MaterialTheme.typography.caption
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(listOfCategories, key = { it }) { item ->
                        Text(
                            text = item,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .background(
                                    color = colorResource(id = R.color.orange_200),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
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