package dev.vorstu.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = " common_sequence1 ",
            initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    //static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private String password;

    //public String SetPassword(String password) {
//        return this.password = passwordEncoder.encode(password);
//    }

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "user")
    private List<Board> Board;

    private boolean enable;
}
