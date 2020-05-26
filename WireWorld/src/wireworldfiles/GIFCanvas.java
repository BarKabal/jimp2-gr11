package wireworldfiles;

import java.awt.*;

public class GIFCanvas extends Canvas {

    public void paint(Graphics graphics){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image gif = toolkit.getImage("example.gif");
        graphics.drawImage(gif,600,600,this);
    }
}