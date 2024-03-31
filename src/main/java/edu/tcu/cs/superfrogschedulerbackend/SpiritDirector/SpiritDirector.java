package edu.tcu.cs.superfrogschedulerbackend.SpiritDirector;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SpiritDirector {
    @Id
    private Integer directorId;

    private String directorFirstName;
    private String directorLastName;
    private String directorUser;
    private String directorPhoneNumber;

    private String privileges;
    private Boolean isLoggedIn;

    

    public SpiritDirector() {
    }

    
    public Integer getDirectorId() {
        return directorId;
    }
    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }
    public String getDirectorFirstName() {
        return directorFirstName;
    }
    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }
    public String getDirectorLastName() {
        return directorLastName;
    }
    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }
    public String getDirectorUser() {
        return directorUser;
    }
    public void setDirectorUser(String directorUser) {
        this.directorUser = directorUser;
    }
    public String getDirectorPhoneNumber() {
        return directorPhoneNumber;
    }
    public void setDirectorPhoneNumber(String directorPhoneNumber) {
        this.directorPhoneNumber = directorPhoneNumber;
    }
    public String getPrivileges() {
        return privileges;
    }
    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }
    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}
