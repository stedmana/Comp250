package InClass;
import java.awt.Component;
import  java.awt.Graphics;

public interface OurIcon {

    int getIconWidth();
    int getIconHeight();
    void paintIcon(Component c, Graphics g, int x, int y);


}
