package ia.eu.code.DTO;

import lombok.Getter;
import lombok.Setter;


public class UserDto {

    Long id;
    String username;
    String emaildto;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmaildto() {
        return emaildto;
    }

    public void setEmaildto(String emaildto) {
        this.emaildto = emaildto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
