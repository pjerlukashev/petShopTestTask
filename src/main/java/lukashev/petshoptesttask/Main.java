package lukashev.petshoptesttask;


import lukashev.petshoptesttask.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class Main {

    private static Repository repository= new Repository();

    public static void main(String[] args) {

      /*  System.out.println(repository.getPersonById(1));
        System.out.println("//////////////////");
        System.out.println(repository.getAllPersons());
        System.out.println("//////////////////");
        System.out.println(repository.deletePersonById(2));
        System.out.println("//////////////////");
        System.out.println(repository.getCarById(4));
        System.out.println("//////////////////");
        System.out.println(repository.getAllCars());
        System.out.println("//////////////////");
        System.out.println(repository.deleteCarById(5));*/

        //System.out.println(repository.getAllPersons());
        System.out.println(repository.getAllPersons());
/*
      Person person = new Person(11,"Vyacheslav", "someemail@yahoo.com", null);
      Person person1 = new Person(3,"Vyac", "someemail@yahoo.com", null);
        System.out.println(repository.deletePersonById(2));
        System.out.println(repository.createPerson(person));
        System.out.println(repository.updatePerson(person1));

      System.out.println(repository.createCar(new Car(35,"lambogini", 350, person)));*/

    /* Person person2 = repository.getPersonById(2);

        System.out.println(repository.updateCar(new Car(8, "hyundai", 180, person2)));*/

    }
}
