package prueban;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class panelll extends JPanel {

    private final int TRIED = 3;
    private final int PATH = 7;
    private int[][] grid
            = {{1, 0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1, 0,},
            {0, 0, 0, 0, 1, 0,},
            {0, 0, 1, 0, 1, 1,},
            {1, 0, 0, 0, 0, 1,},};

    public boolean traverse(int row, int colum) {
        boolean done = false;
        if (valid(row, colum)) {
            grid[row][colum] = TRIED;
            if (row == grid.length - 1 && colum == grid[0].length - 1) {
                done = true;
            } else {
                done = traverse(row + 1, colum);
                if (!done) {
                    done = traverse(row, colum + 1);
                }
                if (!done) {
                    done = traverse(row - 1, colum);
                }
                if (!done) {
                    done = traverse(row, colum - 1);
                }
            }
            if (done) {
                grid[row][colum] = PATH;
            }
        }
        return done;
    }

    private boolean valid(int row, int colum) {
        boolean result = false;
        if (row >= 0 && row < grid.length && colum >= 0 & colum < grid[row].length) {
            if (grid[row][colum] == 1) {
                return true;
            }
        }
        return result;
    }

    public String toString() {
        String result = "\n";
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                result += grid[row][column] + "";
            }
            result += "\n";
        }
        return result;
    }

    public void paintComponent(Graphics g) {
        ImageIcon muro = new ImageIcon(new ImageIcon(getClass().getResource("/img/muro.png")).getImage());
        ImageIcon camino = new ImageIcon(new ImageIcon(getClass().getResource("/img/camino.png")).getImage());
        String result = "\n";
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    g.drawImage(muro.getImage(), column * 60, row * 60, 60, 60, this);
                } else if (grid[row][column] == 1) {
                    g.drawImage(camino.getImage(), column * 60, row * 60, 60, 60, this);
                }
            }
        }
    }
}

class panelFrame1 extends JFrame {

    public panelFrame1() {
        add(new panelll());
        setSize(380, 350);
        setVisible(true);
    }
}
