package Pong;

import java.awt.*;

public class Ball {
    double xVel, yVel, x, y;

    public Ball(){
        x = 350;
        y = 250;
        //both center of the screen
        xVel = getRandomSpeed() * getRandomDirection();
        yVel = getRandomSpeed() * getRandomDirection();

    }

    public double getRandomSpeed(){
        return (Math.random() * 3 + 2);
    }

    public int getRandomDirection(){
        int rand = (int) (Math.random() * 2);

        if(rand == 1)
            return 1;
        else
            return -1;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval( (int)x-10, (int)y-10, 20, 20); //make a circle

    }

    //check when the paddle contacts with the ball
    public void checkPaddleCollision(IPaddle p1, IPaddle p2){
        if(x <= 50){
            if( y >= p1.getY() && y <= p1.getY() + 80 )/*paddle tall is: 80*/
                xVel = -xVel; // make the ball to change direction
        } else if(x >= 650){
            if( y >= p2.getY() && y <= p2.getY() + 80 )
                xVel = -xVel;
        }
    }

    public void move(){
        x += xVel;
        y += yVel;

        //prevent the ball from going out of the applet
        if(y < 10) //top of the screen
            yVel = -yVel; //when hits the top, start coming back

        if(y > 490)
            yVel = -yVel;

    }

    public int getX(){
        return (int) x;
    }

    public int getY(){
        return (int) y;
    }
}
