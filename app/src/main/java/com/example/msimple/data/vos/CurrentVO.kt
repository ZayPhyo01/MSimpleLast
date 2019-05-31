package com.example.msimple.data.vos

import com.google.gson.annotations.SerializedName

class CurrentVO {

    val programId: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("current-period")
    val currentPeriod: String? = null

    @SerializedName("background")
    val background: String? = null

    @SerializedName("average-lengths")
    val averageLengths: List<Int>? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("sessions")
    val sessionsList: List<SessionVO>? = null

}
