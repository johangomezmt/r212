package co.usa.reto3.reto3.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user",indexes = @Index(name = "index_email",columnList = "user_email",unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_identification",nullable = false)
    private String identification;
    @NonNull
    @Column(name = "user_name",nullable = false)
    private String name;
    @NonNull
    @Column(name = "user_address",nullable = false)
    private String address;
    @NonNull
    @Column(name = "user_cellphone",nullable = false)
    private String cellphone;
    @NonNull
    @Column(name = "user_email",nullable = false)
    private String email;
    @NonNull
    @Column(name = "user_password",nullable = false)
    private String password;
    @NonNull
    @Column(name = "user_zone",nullable = false)
    private String zone;
    @NonNull
    @Column(name = "user_type",nullable = false)
    private String type;

    public User(String email, String password, String no_definido) {
    }
}
