package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun FilterItem(
    isActive: Boolean,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            0.5.dp,
            colorResource(id = if (isActive) R.color.orange_500 else R.color.white_background)
        ),
        modifier = modifier
            .wrapContentSize()
            .clickable { }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 8.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Checkbox(
                checked = isActive,
                onCheckedChange = {}, 
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.orange_500),
                    uncheckedColor = colorResource(id = R.color.gray)
                ),
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilterItem(true, "Terbaru")
            FilterItem(false, "Nama")
            FilterItem(false, "Harga")
        }
    }
}