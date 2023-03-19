package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.data.TransactionItemModel
import com.arafat1419.cashierappcompose.utils.VarUtils

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    transactionItem: TransactionItemModel,
    trxType: Int = VarUtils.CASHIER
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "#P-01-001",
            style = MaterialTheme.typography.caption,
            color = colorResource(id = R.color.orange_500),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Paku Tembok Cina Gembok Astaga",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                text = "Rp. 200.000",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(end = 8.dp)
            )
            if (transactionItem.isEditable == true && trxType == VarUtils.CASHIER) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.white),
                    ),
                    contentPadding = PaddingValues(0.dp),
                    elevation = ButtonDefaults.buttonElevation(0.dp),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .size(16.dp)

                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = stringResource(id = R.string.delete),
                        tint = colorResource(id = R.color.dark_gray),
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Stok: 100",
                style = MaterialTheme.typography.caption
            )

            if (trxType == VarUtils.CASHIER) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.white),
                        ),
                        contentPadding = PaddingValues(0.dp),
                        elevation = ButtonDefaults.buttonElevation(0.dp),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .size(24.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Outlined.DeleteOutline,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = colorResource(id = R.color.dark_gray),
                        )
                    }

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.white)
                        ),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, colorResource(id = R.color.white_background))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.white),
                                ),
                                contentPadding = PaddingValues(0.dp),
                                elevation = ButtonDefaults.buttonElevation(0.dp),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .size(24.dp)

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Remove,
                                    contentDescription = stringResource(id = R.string.delete),
                                    tint = colorResource(id = R.color.orange_500),
                                )
                            }

                            Text(
                                text = "100",
                                style = MaterialTheme.typography.subtitle1
                            )

                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.white),
                                ),
                                contentPadding = PaddingValues(0.dp),
                                elevation = ButtonDefaults.buttonElevation(0.dp),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .size(24.dp)

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Add,
                                    contentDescription = stringResource(id = R.string.delete),
                                    tint = colorResource(id = R.color.light_gray),
                                )
                            }
                        }
                    }
                }
            } else {
                Text(
                    text = "x1",
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
        if (transactionItem.notes != null) {
            Text(
                text = "Keterangan :",
                style = MaterialTheme.typography.caption
            )
            Text(
                text = transactionItem.notes,
                style = MaterialTheme.typography.caption
            )
        }
        Divider(
            color = colorResource(id = R.color.light_gray),
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}