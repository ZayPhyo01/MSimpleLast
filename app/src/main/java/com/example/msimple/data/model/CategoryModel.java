package com.example.msimple.data.model;

import com.example.msimple.Delegate.CategoryDelegate;
import com.example.msimple.data.vos.CategoryVO;
import com.example.msimple.data.vos.ProgramVO;
import com.example.msimple.utils.AppConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryModel extends BaseModel implements ICategoryModel {

    Map<String, ProgramVO>mData;
    private static CategoryModel mCategoryModel;

    private CategoryModel() {
        mData = new HashMap<>();
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
                for(int i=0;i<categoryVO.size();i++)
                {
                    for (int j=0;j<categoryVO.get(i).getPrograms().size();j++)
                    {
                        mData.put(categoryVO.get(i).getPrograms().get(j).getProgramId(),categoryVO.get(i).getPrograms().get(j));
                    }
                }
            }

            @Override
            public void fail(String message) {

                response.onFail(message);
            }
        });

    }

    @Override
    public ProgramVO getProgramVO(String id) {

        return mData.get(id);
    }
}
