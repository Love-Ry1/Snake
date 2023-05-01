package graphics;

import logic.DataOfSquare;
import logic.KeyboardListener;
import logic.SquareToLightUp;
import logic.ThreadsController;
import pojo.Tuple;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class Window extends JFrame {
    @Serial
    private static final long serialVersionUID = -2542001418764869760L;
    private static ArrayList<ArrayList<DataOfSquare>> Grid;
    private final static int width = 20;
    private final static int height = 20;
    private static Window f1;

    public static void main(String[] args) {

        // Creating the window with all its awesome snaky features
        f1 = new Window();

        // Setting up the window settings
        f1.setTitle("Snake");
        f1.setSize(300, 300);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Window() {

        // Creates the arraylist that'll contain the threads
        Grid = new ArrayList<>();
        ArrayList<DataOfSquare> data;

        // Creates Threads and its data and adds it to the arrayList
        for (int i = 0; i < width; i++) {
            data = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                DataOfSquare c = new DataOfSquare(SquareToLightUp.BACK_GROUND.ordinal());
                data.add(c);
            }
            Grid.add(data);
        }

        // Setting up the layout of the panel
        getContentPane().setLayout(new GridLayout(height, width, 0, 0));

        // Start & pauses all threads, then adds every square of each thread to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getContentPane().add(Grid.get(i).get(j).getSquare());
            }
        }

        // initial position of the snake
        Tuple position = new Tuple(10, 10);
        // passing this value to the controller
        ThreadsController c = new ThreadsController(position); // &line[Move]
        // Let's start the game now..
        c.start();

        // Links the window to the KeyboardListener.
        this.addKeyListener(new KeyboardListener()); // &line[Controls]

    }

    public static ArrayList<ArrayList<DataOfSquare>> getGrid() {
        return Grid;
    }

    public static int getWindowWidth() {
        return width;
    }

    public static int getWindowHeight() {
        return height;
    }

    public static void updateTitle(String s){
        f1.setTitle(s);
    }
}