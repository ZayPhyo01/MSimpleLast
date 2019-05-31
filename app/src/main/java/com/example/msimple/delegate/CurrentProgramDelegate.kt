package com.example.msimple.delegate

import com.example.msimple.data.vos.CurrentVO

interface CurrentProgramDelegate : BaseDelegate {
    fun onSuccess(currentVOS: CurrentVO)
}
