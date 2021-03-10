import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {

    public static void main(String[] args) {
        Material material = new Material("steel", 7850);
        Subject subject = new Subject("wire", material, 0.03);

        System.out.println(material.toString());
        System.out.println(subject.toString() + ";" + subject.getMass());

        Material material1 = new Material("cooper", 8500);
        subject.setMaterial(material1);
        System.out.println("The wire mass is " + subject.getMass());
    }
}
