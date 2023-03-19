package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Print
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.data.TransactionItemModel
import com.arafat1419.cashierappcompose.ui.components.button.CustomIconButton
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme
import com.arafat1419.cashierappcompose.utils.VarUtils

@Composable
fun SideTransaction(
    modifier: Modifier = Modifier,
    trxType: Int = VarUtils.CASHIER
) {
    val listOfContent = listOf(
        TransactionItemModel(
            true,
            "Ini adalah nota"
        ),
        TransactionItemModel(
            false,
            null,
        ),
        TransactionItemModel(
            false,
            "Ini adalah nota2"
        ),
        TransactionItemModel(
            true,
            "Ini adalah nota3"
        ),
        TransactionItemModel(
            false,
            "Ini adalah nota4"
        ),
        TransactionItemModel(
            true,
            "Ini adalah nota5"
        ),
        TransactionItemModel(
            false,
            "Ini adalah nota6"
        ),
    )

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
            when (trxType) {
                VarUtils.CASHIER -> {
                    Text(
                        text = "Transaksi",
                        style = MaterialTheme.typography.h6
                    )
                    CustomIconButton(
                        backgroundColor = colorResource(id = R.color.c_red),
                        tintColor = colorResource(id = R.color.white),
                        icon = Icons.Outlined.DeleteForever
                    )
                }
                VarUtils.PENDING -> {
                    Column {
                        Text(
                            text = "#INV-01-001",
                            style = MaterialTheme.typography.subtitle2,
                            color = colorResource(id = R.color.orange_500),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Mohammad Arafat Maku",
                            style = MaterialTheme.typography.h6
                        )
                    }
                    CustomIconButton(
                        backgroundColor = colorResource(id = R.color.c_yellow),
                        tintColor = colorResource(id = R.color.white),
                        icon = Icons.Outlined.Edit
                    )
                }
                VarUtils.SUCCESS -> {
                    Column {
                        Text(
                            text = "#INV-01-001",
                            style = MaterialTheme.typography.subtitle2,
                            color = colorResource(id = R.color.orange_500),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Mohammad Arafat Maku",
                            style = MaterialTheme.typography.h6
                        )
                    }
                    CustomIconButton(
                        backgroundColor = colorResource(id = R.color.c_green),
                        tintColor = colorResource(id = R.color.white),
                        icon = Icons.Outlined.Print
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(listOfContent, key = { it }) { item ->
                TransactionItem(transactionItem = item, trxType = trxType)
            }
        }

        BottomSideTransaction(modifier, true, trxType)
    }
}

@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        SideTransaction()
    }
}