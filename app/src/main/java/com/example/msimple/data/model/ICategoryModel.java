package com.example.msimple.data.model;

import com.example.msimple.data.vos.CategoryVO;

import java.util.List;

public interface ICategoryModel {
    void getCategory(Response response);

    interface Response{

        void onSuccess(List<CategoryVO> categoryVO);
        void onFail(String message);

    }
}
