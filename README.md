# 📂 Injection de Dépendances avec Spring

Ce repository contient un projet pratique sur l'injection de dépendances en utilisant Spring. Il inclut la création d'interfaces (`IDao` et `IMetier`), leurs implémentations, et la mise en œuvre de l'injection de dépendances via trois méthodes : **instanciation statique**, **dynamique**, et **configuration avec Spring** (XML et annotations). Le projet est organisé avec une structure claire et un fichier `README.md` détaillant les étapes et les ressources utilisées.

---

## 🚀 Fonctionnalités

- **Couplage faible** : Utilisation d'interfaces (`IDAO` et `IMetier`) pour découpler les implémentations.
- **Injection de dépendances** :
  - **Instanciation statique** : Injection directe des dépendances dans le code.
  - **Instanciation dynamique** : Injection via des setters ou constructeurs.
  - **Spring** : Configuration des dépendances via XML et annotations.
- **Structure modulaire** : Organisation claire des packages pour chaque méthode d'injection.

---

## 🛠️ Technologies Utilisées

- **Java** : Langage de programmation principal.
- **Spring Framework** : Pour la gestion des dépendances et l'injection.
- **Maven** : Pour la gestion des dépendances et la construction du projet (si applicable).
- **Git** : Pour le contrôle de version.

---

## 📚 Ressources Vidéo

- **Partie 1** : [Vidéo Part 1](https://www.youtube.com/watch?v=N6_IL2cxVrs)
- **Partie 2** : [Vidéo Part 2](https://www.youtube.com/watch?v=2pJIO3sF8jM)

---

## 📂 Structure du Projet
src/
├── main/
│ ├── java/
│ │ ├── instantiation_static/ 
│ │ ├── instanciation_dynamique/ 
│ │ ├── spring/ # Injection avec Spring
│ │ │ ├── annotations/
│ │ │ ├── XML/ 
│ │ └── resources/ (config.xml)
│ ├── resources/


---

## 📸 Exemples de Code

### 🖥️ **Instanciation Statique**


package instantiation_static.presentation;

import instantiation_static.DAO.implDao;
import instantiation_static.IMetier.implMetier;

public class MainStatique {
    public static void main(String[] args) {
        // Instanciation statique
        implDao dao = new implDao();
        implMetier metier = new implMetier();

        metier.setDao(dao);

        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}

 
### 🖥️ **Instanciation Dynamique**


package instanciation_dynamique.presentation;

import instanciation_dynamique.DAO.IDAO;
import instanciation_dynamique.IMetier.IMetier;

import java.io.File;
import java.util.Scanner;

public class MainDynamique {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("config.txt"));
            String daoclassname = sc.nextLine();
            String metierclassname = sc.nextLine();

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


 🖥️ **Spring - Version Annotations**
 
package spring.annotations.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotations.IMetier.IMetier;

public class Presentation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring.annotations");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}


 ### 🖥️ ** Spring - Version XML**
package spring.xml.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.xml.IMetier.IMetier;

public class Presentation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}

## 💡 Injection des Dépendances

- **a. Par instanciation statique** : L'instance de `IDao` est créée directement dans la classe `MetierImpl`.
- **b. Par instanciation dynamique** : L'instance de `IDao` est passée à `MetierImpl` via un constructeur ou un setter.
- **c. En utilisant le Framework Spring** :
  - **Version XML** : Configuration des beans dans un fichier `applicationContext.xml`.
  - **Version annotations** : Utilisation des annotations `@Component`, `@Autowired`, etc., pour la configuration.

---

## 💌 Auteur

👩‍💻 **Rim Aaloi**  
💌 Contact: [GitHub Profile](https://github.com/RimAaloi) | [LinkedIn](https://www.linkedin.com/in/rim-aaloi/)  

---

## 📢 Notes

🔹 Ce projet est conçu pour illustrer les concepts d'injection de dépendances en Java avec Spring.  
🔹 Vous pouvez étendre le projet en ajoutant des tests unitaires ou en explorant d'autres fonctionnalités de Spring.  
🔹 N'hésitez pas à personnaliser le code et la structure pour répondre à vos besoins spécifiques.  
