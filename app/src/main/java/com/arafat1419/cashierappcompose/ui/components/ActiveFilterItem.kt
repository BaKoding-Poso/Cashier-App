package com.arafat1419.cashierappcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
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
fun ActiveFilterItem(
    title: String,
    modifier: Modifier = Modifier,
    onCloseClicked: (String) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .wrapContentWidth()
            .height(32.dp)
            .padding(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.body2,
                modifier = modifier
                    .padding(vertical = 0.dp, horizontal = 24.dp)
            )
            Button(
                onClick = { onCloseClicked(title) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.orange_500),
                ),
                contentPadding = PaddingValues(0.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .size(32.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = stringResource(id = R.string.close),
                    tint = colorResource(id = R.color.white),
                )
            }
        }
    }
}

@Preview
@Composable
private fun ActiveFilterItemPreview() {
    CashierAppComposeTheme {
        ActiveFilterItem(title = "Paku", onCloseClicked = {})
    }
}