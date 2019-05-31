package com.example.msimple.network.response

import com.example.msimple.data.vos.CurrentVO
import com.google.gson.annotations.SerializedName

class CurrentProgramResponse {

    @SerializedName("currentProgram")
    var currentVO: CurrentVO? = null
}
