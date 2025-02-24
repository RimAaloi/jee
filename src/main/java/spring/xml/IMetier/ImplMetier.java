package spring.xml.IMetier;

import spring.annotations.DAO.IDAO;

public class ImplMetier implements IMetier {
    private IDAO dao;

    public ImplMetier(IDAO dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        double data = dao.getData();
        return data * 30;
    }
}
