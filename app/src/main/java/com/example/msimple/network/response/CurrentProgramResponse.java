package com.example.msimple.network.response;

import com.example.msimple.data.vos.CurrentVO;
import com.google.gson.annotations.SerializedName;

public class CurrentProgramResponse {

    @SerializedName("currentProgram")
    public CurrentVO currentVO;

    public CurrentVO getCurrentVO() {
        return currentVO;
    }
}
