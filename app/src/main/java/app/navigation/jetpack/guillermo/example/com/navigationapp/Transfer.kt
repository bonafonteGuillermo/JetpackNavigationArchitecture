package app.navigation.jetpack.guillermo.example.com.navigationapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Guillermo Bonafonte Criado on 16/11/2018.
 * 2018 © Cognizant Technology Solutions
 */
@Parcelize
data class Transfer(var concept: String, var amount: Int) : Parcelable