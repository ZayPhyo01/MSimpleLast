package com.example.msimple.data.model;

import com.example.msimple.data.vos.CurrentVO;
import com.example.msimple.data.vos.TopicVO;

import java.util.List;

public interface ITopicModel {

    void getTopic(Response response);

    interface Response{

        void onSuccess(List<TopicVO> topicVOS);
        void onFail(String message);

    }

}
