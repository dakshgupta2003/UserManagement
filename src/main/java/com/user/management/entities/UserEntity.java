package com.user.management.entities;

// import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@Data // generates getters/setters, toString, equals, hashcode
@Component
@Entity // tells the spring JPA that this is a database entity class (working on Repository/Dao layer)
@Table(name = "users") // specifies the table name in db

public class UserEntity {
    @Id // makes userID a primary key
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String address1;
    private String address2;


    public UserEntity(String userId, String userName, String firstName, String lastName, String mobileNumber, String emailId, String address1, String address2) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.address1 = address1;
        this.address2 = address2;
    }

    public UserEntity(){}

    public String getUserId() {
        return userId;
    }
}
