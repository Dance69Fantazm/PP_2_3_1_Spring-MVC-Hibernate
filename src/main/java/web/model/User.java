package web.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name not empty!")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Name not empty!")
    private String surname;

    @Column(name = "email")
    @NotBlank(message = "Name not empty!")
    private String email;

    @Column(name = "age")
    @Min(value = 1,message = "Age >0")
    @Max(value = 1500,message = "Age <=1500")
    private int age;

    public User() {
    }

    public User(Long id, String name, String surname, String email, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name not empty!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name not empty!") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Name not empty!") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Name not empty!") String surname) {
        this.surname = surname;
    }

    public @NotBlank(message = "Name not empty!") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Name not empty!") String email) {
        this.email = email;
    }

    @Min(value = 1, message = "Age >0")
    @Max(value = 1500, message = "Age <=1500")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 1, message = "Age >0") @Max(value = 1500, message = "Age <=1500") int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
