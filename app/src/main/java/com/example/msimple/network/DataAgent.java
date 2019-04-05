package com.example.msimple.network;

import com.example.msimple.Delegate.CategoryDelegate;
import com.example.msimple.Delegate.CurrentProgramDelegate;
import com.example.msimple.Delegate.LoginDelegate;
import com.example.msimple.Delegate.TopicDelegate;

public interface DataAgent {

    void loadCategory(String access_token, String page, CategoryDelegate categoryDelegate);
    void loadTopic(String access_token, int page, TopicDelegate topicDelegate);
    void loadCurrentProgram(String access_token, int page, CurrentProgramDelegate currentProgramDelegate);
    void login(String phone,String password,LoginDelegate loginDelegate);
    void register();


}
