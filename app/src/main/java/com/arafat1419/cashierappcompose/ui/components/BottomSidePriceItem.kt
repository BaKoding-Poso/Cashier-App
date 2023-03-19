package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R

@Composable
fun BottomSidePriceItem(
    modifier: Modifier = Modifier,
    idItem: String,
    amount: Int,
    price: Int
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = idItem,
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.dark_gray),
        )
        Text(
            text = "x $amount",
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.dark_gray),
            modifier = modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Text(
            text = "Rp.${price}",
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.dark_gray),
        )
    }
}