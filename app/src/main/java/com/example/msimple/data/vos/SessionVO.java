package com.example.msimple.data.vos;

class SessionVO {

    private String session_id;
    private String title;
    private int length_in_seconds;
    private String file_path;

    public String getSession_id() {
        return session_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return length_in_seconds/60+" mins";
    }

    public String getFile_path() {
        return file_path;
    }
}
