//package dev.vorstu.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "passwords")
//@Getter @Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Password {
//
//    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    public Password(String password) {
//        this.password = passwordEncoder.encode(password);}
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String password;
//
//    @JsonIgnore
//    private void setPasswordWithEncoding(String password) {
//        this.password = passwordEncoder.encode(password);
//    }
//
//
//
//}
