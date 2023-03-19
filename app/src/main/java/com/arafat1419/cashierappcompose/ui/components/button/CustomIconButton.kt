package com.arafat1419.cashierappcompose.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arafat1419.cashierappcompose.R

@Composable
fun CustomIconButton(
    backgroundColor: Color,
    tintColor: Color,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) = Button(
    shape = RoundedCornerShape(8.dp),
    colors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
    ),
    contentPadding = PaddingValues(0.dp),
    elevation = ButtonDefaults.elevation(0.dp),
    modifier = modifier.size(48.dp),
    onClick = onClick
) {
    Icon(
        imageVector = icon,
        contentDescription = stringResource(id = R.string.delete_all),
        tint = tintColor,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    )
}