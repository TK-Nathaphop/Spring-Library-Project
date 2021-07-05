package tkstudy.starterproject.domain.user.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tkstudy.starterproject.domain.constant.Role;

public class UserDto {
    private String username;
    private String name;
    private String role;

    public UserDto(){}

    public UserDto(String username, String name, String role){
        this.username = username;
        this.name = name;
        this.role = role;
    }

    public UserDto(String username, String name, Role role){
        this.username = username;
        this.name = name;
        this.role = role.name();
    }

    public String getUsername(){
        return this.username;
    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setRole(Role role){
        this.role = role.name();
    }

    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        String userDtoJSON;
        try{
            userDtoJSON = mapper.writeValueAsString(this);
        }
        catch(Exception e)
        {
            userDtoJSON = "Error occured while converting to JSON";
        }
        return userDtoJSON;
    }
}
