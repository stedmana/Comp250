package InClass;
import javax.swing.ImageIcon;
import  javax.swing.JOptionPane;
import java.util.Collections;
import  java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Bob", 500);
        Manager m1 = new Manager(100,1000,"Harry");

        //JOptionPane.showMessageDialog(null,"hello");
        //JOptionPane.showMessageDialog(null, "Hello", "Message", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img.jpg"));
        //JOptionPane.showMessageDialog(null, "Hello", "Message", JOptionPane.INFORMATION_MESSAGE, new SmileyIcon(300));
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(new Country("Canada", 100000000));
        countries.add(new Country("USA", 100));
        countries.add(new Country("Germany", 1500));

        Collections.sort(countries);
        for (Country country:countries) {
            System.out.println(country.getName() + ": " + country.getArea());

        }
    }
}
