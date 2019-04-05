package com.example.msimple.data.model;

import com.example.msimple.Delegate.CurrentProgramDelegate;
import com.example.msimple.data.vos.CurrentVO;
import com.example.msimple.utils.AppConstants;

public class CurrentProgramModel extends BaseModel implements ICurrentModel {

    private static CurrentProgramModel mCurrentProgramModel;


    private CurrentProgramModel() {
    }

    public static CurrentProgramModel getInstance() {
        if (mCurrentProgramModel == null) {
            mCurrentProgramModel = new CurrentProgramModel();
        }

        return mCurrentProgramModel;
    }


    @Override
    public void getCurrentProgram(final Response response) {
        mRetrofit.loadCurrentProgram(AppConstants.ACCESS_TOKEN, 1, new CurrentProgramDelegate() {
            @Override
            public void onSuccess(CurrentVO currentVOS) {
                response.onSuccess(currentVOS);
            }

            @Override
            public void fail(String message) {
                response.onFail(message);
            }
        });
    }
}
