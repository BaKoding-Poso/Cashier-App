package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.Pending
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.components.button.CustomIconButton
import com.arafat1419.cashierappcompose.utils.VarUtils

@Composable
fun BottomSideTransaction(
    modifier: Modifier = Modifier,
    isOpen: Boolean = false,
    trxType: Int = VarUtils.CASHIER
) {
    Column {
        Divider(
            color = colorResource(id = R.color.light_gray),
            thickness = 0.5.dp,
        )

        Button(
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.white),
            ),
            contentPadding = PaddingValues(0.dp),
            elevation = ButtonDefaults.elevation(0.dp),
            modifier = Modifier
                .size(24.dp)
                .align(alignment = Alignment.CenterHorizontally),
            onClick = { }
        ) {
            Icon(
                imageVector = if (isOpen) Icons.Outlined.ExpandMore else Icons.Outlined.ExpandLess,
                contentDescription = stringResource(id = R.string.delete_all),
                tint = colorResource(id = R.color.dark_gray),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isOpen) {
            Column {
                BottomSidePriceItem(
                    idItem = "#P-01-001",
                    amount = 1,
                    price = 200_000
                )

                Spacer(modifier = Modifier.height(8.dp))

                BottomSidePriceItem(
                    idItem = "#P-01-001",
                    amount = 1,
                    price = 200_000
                )

                Spacer(modifier = Modifier.height(8.dp))

                BottomSidePriceItem(
                    idItem = "#P-01-001",
                    amount = 1,
                    price = 200_000
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

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

        Row {
            when (trxType) {
                VarUtils.CASHIER -> {
                    CustomIconButton(
                        backgroundColor = colorResource(id = R.color.dark_gray),
                        tintColor = colorResource(id = R.color.white),
                        icon = Icons.Outlined.Pending,
                        Modifier.padding(end = 16.dp)
                    )
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Bayar (10)",
                            style = MaterialTheme.typography.h6,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }
                VarUtils.PENDING -> {
                    CustomIconButton(
                        backgroundColor = colorResource(id = R.color.dark_gray),
                        tintColor = colorResource(id = R.color.white),
                        icon = Icons.Outlined.Cancel,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Bayar (10)",
                            style = MaterialTheme.typography.h6,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }
                VarUtils.SUCCESS -> {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.c_green),
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Transaksi Selesai",
                            style = MaterialTheme.typography.h6,
                            color = colorResource(id = R.color.white)
                        )
                    }
                }
            }
        }
    }
}