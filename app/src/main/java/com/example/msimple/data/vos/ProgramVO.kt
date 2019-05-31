package com.example.msimple.data.vos

import com.google.gson.annotations.SerializedName

class ProgramVO {


    @SerializedName("program-id")
    val programId: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("average-lengths")
    val averageLengths: List<Int>? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("sessions")
    val sessionsList: List<SessionVO>? = null

}
