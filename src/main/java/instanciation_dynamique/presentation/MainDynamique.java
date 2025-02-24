package instanciation_dynamique.presentation;

import instanciation_dynamique.DAO.IDAO;
import instanciation_dynamique.IMetier.IMetier;

import java.io.File;
import java.util.Scanner;

public class MainDynamique {
    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(new File("config.txt"));
            String daoclassname=sc.nextLine();
            String metierclassname=sc.nextLine();

            Class<?> daoClass = Class.forName(daoclassname);
            Class<?> metierClass = Class.forName(metierclassname);


            IDAO dao = (IDAO) daoClass.getConstructor().newInstance();
            IMetier metier = (IMetier) metierClass.getConstructor(IDAO.class).newInstance(dao);

            System.out.println("Résultat du calcul : " + metier.calcul());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
