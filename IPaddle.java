package Pong;

import java.awt.*;

public interface IPaddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}
