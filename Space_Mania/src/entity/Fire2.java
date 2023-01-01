package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Fire2 {
    private double x, y;
    private double size;
    private final Shape shape;
    private final float angle;
    private final Color color = new Color(55,25,25);
    private float speed = 1f;

    public Fire2(double x, double y, float angle, double size, float speed){

        x += Player2.PLAYER_SIZE / 2 - (size / 2) + 60;
        y += Player2.PLAYER_SIZE / 2 - (size / 2) + 5;
        this.x = x;
        this.y = y;
        this.size = size;
        this.speed = speed;
        this.angle = angle;
        shape = new Ellipse2D.Double(0,0,size,size);
    }

    public  void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.setColor(color);
        g2.translate(x,y);
        g2.fill(shape);
        g2.setTransform(oldTransform);
    }
    public void update(){
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getSize(){
        return size;
    }

    public double getCenterX(){
        return x+size/2;
    }

    public double getCenterY(){
        return  y+size/2;
    }

    public boolean check2(int width, int height){
        if ( x <=- size || y <- size || x > width || y > height){
            return  false;
        }
        else {
            return true;
        }
    }

    public Shape getShape() {
        return new Area(new Ellipse2D.Double(x,y,size,size));
    }
}

