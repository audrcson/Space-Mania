package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Musuh {
    public static final double ENEMY_SIZE = 50;
    private double x,y;
    private final float speed = 0.3f;
    private final Image image;
    private  float angle = 0;
    private final Area rocketShap;


    public Musuh(){

        this.image = new ImageIcon(getClass().getResource("/Image/musuh.png")).getImage();
        Path2D p = new Path2D.Double();
        p.moveTo(0, ENEMY_SIZE);
        p.lineTo(-15, 75);
        p.lineTo(ENEMY_SIZE-7, 10);
//        p.lineTo(ENEMY_SIZE + 10, ENEMY_SIZE / 2);
//        p.lineTo(ENEMY_SIZE - 5, ENEMY_SIZE - 13);
//        p.lineTo(15, ENEMY_SIZE - 10);
        rocketShap = new Area(p);
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

    public Area getShape() {
        AffineTransform afx = new AffineTransform();
        afx.translate(x, y);
        afx.rotate(Math.toRadians(angle), ENEMY_SIZE / 2, ENEMY_SIZE / 2);
        return new Area(afx.createTransformedShape(rocketShap));
    }

    public void draw(Graphics2D g2){
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x,y);
        AffineTransform tran = new AffineTransform();
        tran.rotate(Math.toRadians(angle+90), ENEMY_SIZE/2, ENEMY_SIZE/2 );
        g2.drawImage(image,tran,null);
        Shape shap = getShape();
        g2.setTransform(oldTransform);

        //  Test
//         g2.setColor(new Color(36, 214, 63));
//         g2.draw(shap);
        g2.draw(shap.getBounds2D());
    }

    public boolean check(int width, int height) {
        Rectangle size = getShape().getBounds();
        if (x <= -size.getWidth() || y < -size.getHeight() || x > width || y > height) {
            return false;
        } else {
            return true;
        }
    }
}
