package com.example.msimple.data.model;

import com.example.msimple.Delegate.CategoryDelegate;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.utils.AppConstants;

import java.util.List;

public class CategoryModel extends BaseModel implements ICategoryModel {

    private static CategoryModel mCategoryModel;

    private CategoryModel() {
    }

    public static CategoryModel getInstance() {
        if (mCategoryModel == null) {
            mCategoryModel = new CategoryModel();
        }
        return mCategoryModel;
    }

    @Override
    public void getCategory(final Response response) {

        mRetrofit.loadCategory(AppConstants.ACCESS_TOKEN, "1", new CategoryDelegate() {
            @Override
            public void onSuccess(List<CategoryVO> categoryVO) {
                response.onSuccess(categoryVO);
            }

            @Override
            public void fail(String message) {

                response.onFail(message);
            }
        });

    }
}
