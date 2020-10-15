package Pong;

import java.awt.*;

public class HumanPaddle implements IPaddle {
    private static final double GRAVITY = 0.94;
    double y, yVel; //yVolcity
    boolean upAccel, downAccel;
    int player, x;
    // x,y represents the position of the actual paddle in the applet
    // player represents player 1 or 2, left side of the applet or right side of the applet
    // upAccelerating: moving up faster / down Accelerating


    public HumanPaddle(int player) {
        upAccel = false;
        downAccel = false;
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
        //defining how fast the y velocity is changing when a key is pressed
        if(upAccel){
            yVel -= 2;
        } else if(downAccel){
            yVel += 2;
        } else if(!upAccel && !downAccel){
            yVel *= GRAVITY; //multiply
        }

        //make the paddle slow down so it doesn't go out of the screen at single key press
        if(yVel >= 5)
            yVel = 5;
        else if(yVel <= -5)
            yVel = -5;

        y += yVel;

        //make the paddle doesn't go out of the screen, limit to the top and bottom
        if(y < 0)
            y = 0;

        if(y > 420)
            y = 420;
    }

    public void setUpAccel(boolean input){
        upAccel = input;
    }

    public void setDownAccel(boolean input) {
        downAccel = input;
    }

    public int getY() {
        return (int)y;
    }
}
