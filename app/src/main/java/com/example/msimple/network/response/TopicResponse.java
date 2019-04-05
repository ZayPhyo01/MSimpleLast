package com.example.msimple.network.response;

import com.example.msimple.data.vos.TopicVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopicResponse {

    @SerializedName("topics")
    List<TopicVO>topicVOS;

    public List<TopicVO> getTopicVOS() {
        return topicVOS;
    }
}
