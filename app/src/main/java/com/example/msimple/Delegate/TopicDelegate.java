package com.example.msimple.Delegate;

import com.example.msimple.data.vos.TopicVO;

import java.util.List;

public interface TopicDelegate extends BaseDelegate{
    void onSuccess(List<TopicVO>topicVOS);
}
