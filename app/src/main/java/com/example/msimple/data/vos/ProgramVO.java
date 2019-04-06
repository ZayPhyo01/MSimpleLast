package com.example.msimple.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgramVO {




        @SerializedName("program-id")
        private String programId;

        @SerializedName("title")
        private String title;

        @SerializedName("image")
        private String image;

        @SerializedName("average-lengths")
        private List<Integer> averageLengths;

        @SerializedName("description")
        private String description;

        @SerializedName("sessions")
        private List<SessionVO> sessionsList;



        public String getProgramId() {
            return programId;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public List<Integer> getAverageLengths() {
            return averageLengths;
        }

        public String getDescription() {
            return description;
        }

        public List<SessionVO> getSessionsList() {
            return sessionsList;
        }

}
