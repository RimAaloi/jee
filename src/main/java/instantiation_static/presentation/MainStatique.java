package instantiation_static.presentation;

import instantiation_static.DAO.implDao;
import instantiation_static.IMetier.implMetier;

public class MainStatique {
    public static void main(String[] args) {
        // Instanciation statique
        implDao dao = new implDao();
        implMetier metier = new implMetier();

        // Injection de dépendance
        metier.setDao(dao);


        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}
