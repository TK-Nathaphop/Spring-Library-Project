package tkstudy.starterproject.domain.user.domain;

import tkstudy.starterproject.domain.constant.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User{

    @Id
    private final String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(){
    }

    public User(String name, String username, String password, Role role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String name, String username, String password, String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getUsername(){
        return this.username;
    }

    public String getRole(){
        return this.role.name();
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public void setPassword(String password){
        this.password = password;
    }
}
