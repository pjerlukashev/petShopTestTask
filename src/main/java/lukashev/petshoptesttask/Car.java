package lukashev.petshoptesttask;

public class Car {

    private  Integer id;

    private String model;

    private int speed;

    private Person person;

    public Car(){}

    public Car(Integer id, String model, int speed, Person person) {
        this.id = id;
        this.model = model;
        this.speed = speed;
        this.person = person;
    }

    public Car(String model, int speed, Person person) {
      this(null, model, speed, person);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
