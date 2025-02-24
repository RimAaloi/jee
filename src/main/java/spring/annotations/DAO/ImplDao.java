package spring.annotations.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class ImplDao implements IDAO {

    @Override
    public double getData() {
        System.out.println("Version Base de données");
        return Math.random() * 50;
    }
}
