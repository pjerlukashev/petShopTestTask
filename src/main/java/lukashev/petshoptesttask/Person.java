package lukashev.petshoptesttask;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Person {


    private Integer id;

    private String name;

    private String email;


    private List<Car> cars;

    public Person(){}

    public Person(Integer id, String name, String email, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cars = cars;
    }

    public Person(String name, String email, List<Car> cars) {
        this(null, name, email, cars);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cars=" + cars +
                '}';
    }
}
