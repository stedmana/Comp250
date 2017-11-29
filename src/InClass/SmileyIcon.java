package InClass;

import java.awt.*;
import javax.swing.Icon;

public class SmileyIcon implements Icon {
    private int size;

    public SmileyIcon(int aSize) {
        this.size = aSize;
    }
    public int getSize() {
        return this.size;
    }
    @Override
    public int getIconWidth() {
        return size;
    }
    @Override
    public  int getIconHeight() {
        return size;
    }

    @Override
    public void paintIcon(Component C, Graphics g, int x, int y) {
        g.drawOval(x,y,200,200);
        g.fillOval(x+55,y+50,10,20);
        g.fillOval(x-55,y+50,10,20);
    }
}
