package com.example.msimple.data.model;

import com.example.msimple.data.vos.CategoryVO;

import java.util.List;

public interface BaseResponse<T> {

        void onSuccess(List<T> categoryVO);
        void onFail(String message);


}
