package instanciation_dynamique.DAO;

public class ImplDao implements IDAO {

    @Override
    public double getData() {
        System.out.println("Version Base de données");
        return Math.random() * 100;
    }
}
