package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R
import com.arafat1419.cashierappcompose.ui.theme.CashierAppComposeTheme

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        Text(
            text = "Paku Tembok Cina Gembok Astaga",
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "Rp. 200.000",
            style = MaterialTheme.typography.subtitle1
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Stok: 100",
                style = MaterialTheme.typography.caption
            )

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
                                tint = colorResource(id = R.color.gray),
                            )
                        }
                    }
                }
            }
        }
        Divider(
            color = colorResource(id = R.color.gray),
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        TransactionItem()
    }
}