package spring.annotations.IMetier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.annotations.DAO.IDAO;

@Service("metier")
public class ImplMetier implements IMetier {
    private final IDAO dao;


    public ImplMetier( @Qualifier("dao") IDAO dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        double data = dao.getData();
        return data * 20;
    }
}
