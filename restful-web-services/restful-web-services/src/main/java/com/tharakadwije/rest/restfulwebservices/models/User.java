package com.tharakadwije.rest.restfulwebservices.models;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details about the user")
public class User {

    private Integer id;

    @Size(min = 2 ,message = "Name must contain a atleast 2 charactors")
    @ApiModelProperty(notes = "Name must be more than two letters")
    private  String name;

    @Past
    @ApiModelProperty(notes = "Date must be past date")
    private Date bdate;



    public User(Integer id, String name, Date bdate) {
        this.id = id;
        this.name = name;
        this.bdate = bdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
}
