package net.codejava.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_signin")
public class LogSignIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;

    private String authServerName;
    private Date loginDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getAuthServerName() {
        return authServerName;
    }

    public void setAuthServerName(String authServerName) {
        this.authServerName = authServerName;
    }
}
