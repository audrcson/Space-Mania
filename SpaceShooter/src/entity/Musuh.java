package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Musuh {
    public static final double ENEMY_SIZE = 50;
    private double x,y;
    private final float speed = 0.3f;
    private final Image image;
    private  float angle = 0;


    public Musuh(){

        this.image = new ImageIcon(getClass().getResource("/Image/musuh.png")).getImage();
    }

    public void changeLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void update(){
        x += Math.cos(Math.toRadians(angle)) * speed;
        y += Math.sin(Math.toRadians(angle)) * speed;
    }

    public void changeAngle(float angle){
        if(angle < 0){
            angle = 359;
        }
        else if(angle > 359){
            angle = 0;
        }
        this.angle = angle;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public float getAngle(){
        return angle;
    }

    public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x,y);
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(angle+90), ENEMY_SIZE/2, ENEMY_SIZE/2 );
        g2.drawImage(image,tran,null);
        g2.setTransform(oldTransform);
    }

}
