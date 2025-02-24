package spring.xml.extensions;

import spring.annotations.DAO.IDAO;

public class DaoImplv2 implements IDAO {
    @Override
    public double getData() {
        System.out.println("Version 2");
        return Math.random() * 30;
    }
}
