package com.example.msimple.data.model;

import com.example.msimple.Delegate.BaseDelegate;
import com.example.msimple.Delegate.TopicDelegate;
import com.example.msimple.data.vos.TopicVO;
import com.example.msimple.utils.AppConstants;

import java.util.List;

public class TopicModel extends BaseModel implements ITopicModel {

    private static TopicModel mTopicModel;



    private TopicModel() {
    }

    public static TopicModel getInstance() {
        if (mTopicModel == null) {
            mTopicModel = new TopicModel();
        }

        return mTopicModel;
    }

    @Override
    public void getTopic(final Response response) {

        mRetrofit.loadTopic(AppConstants.ACCESS_TOKEN, 1, new TopicDelegate() {
            @Override
            public void onSuccess(List<TopicVO> topicVOS) {
                response.onSuccess(topicVOS);
            }

            @Override
            public void fail(String message) {

            }
        });

    }
}
