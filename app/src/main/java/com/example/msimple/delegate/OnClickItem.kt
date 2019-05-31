package com.example.msimple.delegate

import com.example.msimple.data.vos.ProgramVO

interface OnClickItem {

    fun onTap(programVO: ProgramVO)

}
