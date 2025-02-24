package instantiation_static.DAO;

public class implDao implements IDAO {

    @Override
    public double getData() {
        System.out.println("Version Base de données");
        return Math.random() * 100;
    }
}
