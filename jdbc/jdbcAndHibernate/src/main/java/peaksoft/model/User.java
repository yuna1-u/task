package peaksoft.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;
    Byte age;

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}