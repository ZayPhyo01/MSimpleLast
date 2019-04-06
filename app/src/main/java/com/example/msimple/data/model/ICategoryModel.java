package com.example.msimple.data.model;

import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.ProgramVO;

import java.util.List;

public interface ICategoryModel {
    void getCategory(Response response);
    ProgramVO getProgramVO(String id);

    interface Response{

        void onSuccess(List<CategoryVO> categoryVO);
        void onFail(String message);

    }
}
