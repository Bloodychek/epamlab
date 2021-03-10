import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {

    public static void main(String[] args) {
        Material steel = new Material("steel", 7850);
        Subject subject = new Subject("wire", steel, 0.03);

        System.out.println(steel.toString());
        System.out.println(subject.toString() + ";" + subject.getMass());

        Material cooper = new Material("cooper", 8500);
        subject.setMaterial(cooper);
        System.out.println("The wire mass is " + subject.getMass());
    }
}
