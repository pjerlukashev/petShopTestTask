package lukashev.petshoptesttask.repository;

import lukashev.petshoptesttask.Car;
import lukashev.petshoptesttask.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;


@org.springframework.stereotype.Repository
public class Repository {

   private SqlSessionFactory sqlSessionFactory;

   private Reader reader;

public Repository(){
    try {
        reader = Resources
                .getResourceAsReader("db/mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public Person getPersonById(int id){
    SqlSession session = sqlSessionFactory.openSession();
    try {
        return session.selectOne("lukashev.petshoptesttask.PersonMapper.getPersonById", id);
    } finally {
        session.close();
    }
}

public List<Person> getAllPersons(){
    SqlSession session = sqlSessionFactory.openSession();
    try {
      return session.selectList("lukashev.petshoptesttask.PersonMapper.getAllPersons");
    } finally {
        session.close();
    }
}

public boolean updatePerson(Person person){
    SqlSession session = sqlSessionFactory.openSession();
    try {
        int result = session.update("lukashev.petshoptesttask.PersonMapper.updatePerson",person);
        session.commit();
        return  result>0;
    } finally {
        session.close();
    }
}

    public boolean createPerson(Person person){
    SqlSession session = sqlSessionFactory.openSession();
        try {
            int result = session.insert("lukashev.petshoptesttask.PersonMapper.insertPerson",person);
            session.commit();
            return  result>0;
        } finally {
            session.close();
        }
}

    public boolean deletePersonById(int id){
    SqlSession session = sqlSessionFactory.openSession();
        try {
            int result = session.delete("lukashev.petshoptesttask.PersonMapper.deletePersonById", id);
            session.commit();
            return  result>0;
        } finally {
            session.close();
        }
}

    public Car getCarById(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return session.selectOne("lukashev.petshoptesttask.CarMapper.getCarById", id);
        } finally {
            session.close();
        }
    }

    public List<Car> getAllCars(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            return  session.selectList("lukashev.petshoptesttask.CarMapper.getAllCars");
        } finally {
            session.close();
        }
    }

    public boolean updateCar(Car car){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int result = session.update("lukashev.petshoptesttask.CarMapper.updateCar", car);
            session.commit();
            return  result>0;
        } finally {
            session.close();
        }
    }

    public boolean createCar(Car car){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int result = session.insert("lukashev.petshoptesttask.CarMapper.insertCar", car);
            session.commit();
            return  result>0;
        } finally {
            session.close();
        }
    }

    public boolean deleteCarById(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            int result = session.delete("lukashev.petshoptesttask.CarMapper.deleteCarById", id);
            session.commit();
            return  result>0;
        } finally {
            session.close();
        }
    }
}
