package instanciation_dynamique.presentation;

import instanciation_dynamique.DAO.IDAO;
import instanciation_dynamique.IMetier.IMetier;
import instanciation_dynamique.IMetier.implMetier;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class MainDynamique {
    public static void main(String[] args) {
        try {
            // Charger le fichier de configuration
            Scanner sc = new Scanner(new File("config.txt"));
            String daoclassname=sc.nextLine();
            String metierclassname=sc.nextLine();

            // Charger dynamiquement les classes
            Class<?> daoClass = Class.forName(daoclassname);
            Class<?> metierClass = Class.forName(metierclassname);

            // Créer les instances
            IDAO dao = (IDAO) daoClass.getDeclaredConstructor().newInstance();
            IMetier metier = (IMetier) metierClass.getDeclaredConstructor().newInstance();

            // Injecter la dépendance
            if (metier instanceof implMetier) {
                ((implMetier) metier).setDao(dao);
            }

            // Utilisation
            System.out.println("Résultat du calcul : " + metier.calcul());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
