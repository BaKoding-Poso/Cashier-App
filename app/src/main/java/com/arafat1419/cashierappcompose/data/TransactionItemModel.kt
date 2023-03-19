package com.arafat1419.cashierappcompose.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionItemModel(
    val isEditable: Boolean? = null,
    val notes: String? = null
) : Parcelable
