package com.example.msimple.data.vos;

public class SessionVO {

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
        return (getLength_in_seconds()/60)+" mins";
    }

    public String getFile_path() {
        return file_path;
    }

    public int getLength_in_seconds() {
        return length_in_seconds;
    }
}
