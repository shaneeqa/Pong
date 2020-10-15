package Pong;

import java.awt.*;

public class AIPaddle implements IPaddle {
    private static final double GRAVITY = 0.94;
    double y, yVel; //yVolcity
    boolean upAccel, downAccel;
    int player, x;
    Ball b1; //track the value of the ball


    public AIPaddle(int player, Ball b) {
        upAccel = false;
        downAccel = false;
        b1 = b;
        y = 210; //center point for the paddle
        yVel = 0; //paddle is not moving

        if(player == 1)
            x = 20; //if player is 1, going to be in the left side of the applet
        else
            x = 660; //if player is 2, going to be in the right side of the applet
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int) y, 20, 80   );
    }

    public void move() {
        y = b1.getY() -40; //40: move the paddle half way, so the paddle is centered to the ball where it is
        if(y < 0)
            y = 0;

        if(y > 420)
            y = 420;
    }


    public int getY() {
        return (int)y;
    }
}
