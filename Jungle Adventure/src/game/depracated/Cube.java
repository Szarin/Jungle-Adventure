package game.depracated;

import javax.swing.*;
import java.awt.*;

@Deprecated
public class Cube extends Objet{

    private Image imgCube;
    //private ImageIcon icoCube;
    public Cube(int x, int y) {
        super(12, 12, x, y); //code temporaire car le cube n'est pas encore fait
    }

    public Image getImgCube() {
        return imgCube;
    }

}
