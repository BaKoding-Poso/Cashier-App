package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.data.FilterItemModel
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@ExperimentalFoundationApi
@Composable
fun FilterDialog(
    modifier: Modifier = Modifier
) {3
    val listOfSortBy = listOf(
        FilterItemModel(1, "Terbaru", true),
        FilterItemModel(2, "Nama", false),
        FilterItemModel(3, "Harga", false),
        FilterItemModel(4, "Stok", false)
    )
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.white_background)
        ),
        modifier = modifier
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
        ) {
            Text(
                text = "Urutkan",
                style = MaterialTheme.typography.subtitle2
            )
            LazyVerticalGrid(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                columns = GridCells.Adaptive(80.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                items(listOfSortBy, key = { it.id }) { item ->
                    FilterItem(isActive = item.isActive, title = item.title, modifier)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        FilterDialog()
    }
}