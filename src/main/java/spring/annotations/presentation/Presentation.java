package spring.annotations.presentation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.annotations.IMetier.IMetier;

public class Presentation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring.annotations");
        IMetier metier =  context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
