package com.example.msimple.network.response;

import com.example.msimple.data.vos.CategoryVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("categoriesPrograms")
    List<CategoryVO>categoryVOS;

    public List<CategoryVO> getCategoryVOS() {
        return categoryVOS;
    }
}
