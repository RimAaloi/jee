package instanciation_dynamique.IMetier;

import instanciation_dynamique.DAO.IDAO;

public class ImplMetier implements IMetier {
    private IDAO dao; // Couplage faible via l'interface IDao

    public ImplMetier(IDAO dao) {
        this.dao = dao;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {

        double data = dao.getData();
        return data * 10;
    }
}
