package com.example.msimple.Delegate;

import com.example.msimple.data.vos.CurrentVO;

import java.util.List;

public interface CurrentProgramDelegate extends BaseDelegate{
    void onSuccess(CurrentVO currentVOS);
}
