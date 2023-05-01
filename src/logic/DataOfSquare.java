package logic;

import java.util.ArrayList;
import java.awt.Color;

import graphics.SquarePanel;

public class DataOfSquare {
    // ArrayList that'll contain the colors
    private final ArrayList<Color> C = new ArrayList<>();
    private final SquarePanel square;

    public DataOfSquare(int color) {

        // Lets add the color to the arrayList
        C.add(Color.darkGray);// &line[Tile::Snake]
        C.add(Color.BLUE);    // &line[Food]
        C.add(Color.white);   // &line[Playing_Area]
        square = new SquarePanel(C.get(color));
    }

    // &begin[Update]
    public void lightMeUp(SquareToLightUp c) {
        square.ChangeColor(C.get(c.ordinal()));
    }
    // &end[Update]

    public SquarePanel getSquare() {
        return square;
    }
}

