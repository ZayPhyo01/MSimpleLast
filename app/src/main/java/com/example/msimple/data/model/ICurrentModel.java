package com.example.msimple.data.model;

import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.CurrentVO;

import java.util.List;

public interface ICurrentModel {

    void getCurrentProgram(Response response);


    interface Response{

        void onSuccess(CurrentVO currentVO);
        void onFail(String message);

    }
}
