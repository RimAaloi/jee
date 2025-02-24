package spring.annotations.extensions;


import org.springframework.stereotype.Repository;
import spring.annotations.DAO.IDAO;

@Repository("dao2")
public class DaoImplv2 implements IDAO {
    @Override
    public double getData() {
        System.out.println("Getting data from Web Service");
        return Math.random() * 50;
    }
}
