package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Player1 {
    public static final double PLAYER_SIZE = 64;
    private double x,y;
    private final Image image;
    private final Image image_speed;
    private boolean speedUp;
    private float angle = 0;
    //private final float MAX_SPEED = 1f;



    public Player1(){
        this.image = new ImageIcon(getClass().getResource("/Image/ship.png")).getImage();
        this.image_speed = new ImageIcon(getClass().getResource("/Image/ship_speed.png")).getImage();

    }

    public void changeAngle(float angle){
        if (angle < 0){
            angle = 359;
        }
        else if(angle > 359){
            angle = 0;
        }
        this.angle = angle;
    }

    public void update(){
        x += Math.cos(Math.toRadians(angle));
        y += Math.sin(Math.toRadians(angle));
    }

    public float getAngle(){
        return angle;
    }
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void changeLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void speedUp(){
        speedUp = true;
    }

    public void speedDown(){
        speedUp = false;
    }

    public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x,y);
        AffineTransform tran = new AffineTransform();
        g2.drawImage(speedUp? image_speed : image, tran, null);
        g2.setTransform(oldTransform);
    }

}
