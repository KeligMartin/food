package model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Recipe {

    private int id;

    private String name;

    private List<String> steps;

    public void validate(){

    }
}
