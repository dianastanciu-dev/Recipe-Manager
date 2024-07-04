package com.example.recipemanager.model;

import ch.qos.logback.core.util.StringUtil;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
//@Entity maps the class to a database
public class Recipe implements Serializable {
    //The class will be saved to a database and sent to frontend as Json
    //Recipe class will be a table in a database
    //Implement as Serializable any class intended for use in different streams
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false) //id column can not be null or updated
    private Long id; //primary key

    private String name;
    private String description;
    private String imageUrl;

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    private String recipeCode;

    public Recipe(){} //no argument constructor
    // Creates an instance of Recipe class without providing any initial values for its fields
//When a class implements Serializable, it can be converted to a byte stream,
// which can then be reverted back into a copy of the object.
// Having a no-argument constructor can be useful for the deserialization process,
// where an instance of the class is recreated from the byte stream.
// While not strictly necessary for serialization, some serialization frameworks and
// libraries rely on a no-argument constructor to reconstruct the object.


    public Recipe(String name, String description, String imageUrl, String recipeCode) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.recipeCode = recipeCode;
    }    // Constructor with parameters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        //Constructs a string representation of the Recipe object in a readable format,
        // for debugging and logging
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    //example output: Recipe{id=1, name='Savage Tofu',
    // description='Sign Up for Tofu??', imageUrl='tofu.jpg'}

}
