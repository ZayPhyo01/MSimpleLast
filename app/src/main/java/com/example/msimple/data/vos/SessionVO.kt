package com.example.msimple.data.vos

class SessionVO {

    val session_id: String? = null
    val title: String? = null
    val length_in_seconds: Int = 0
    val file_path: String? = null

    val time: String
        get() = (length_in_seconds / 60).toString() + " mins"
}
