package com.example.msimple.data.vos;

import java.util.Date;
import java.util.List;

public class CategoryVO {

    private String program_id;
    private String title;
    private String image;
    private int [] average_length;
    private String description;
    private List<ProgramVO>programs;


    public String getProgram_id() {
        return program_id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int[] getAverage_length() {
        return average_length;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public String getDescription() {
        return description;
    }


}
