package com.example.msimple.Delegate;

import com.example.msimple.data.model.BaseModel;
import com.example.msimple.data.vos.CategoryVO;

import java.util.List;

public interface CategoryDelegate extends BaseDelegate {

    void onSuccess(List<CategoryVO> categoryVO);

}
