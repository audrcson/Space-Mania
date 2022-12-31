package board;

import entity.Musuh;
import entity.Fire;
import entity.Player1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardPanel extends JComponent {


    private Graphics2D g2;
    private BufferedImage Image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true;
    private Keyboard key;
    private int shootTime;

    //FPS
    private final int FPS = 60;
    private final int TARGET_TIME = 1000000000/FPS;

    private Player1 player1; //player 1

    //enemy
    private List<Musuh> enemys;
    private List<Fire> bullets;


    public void start(){
        width = getWidth();
        height = getHeight();
        Image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2 = Image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(start){
                    long startTime = System.nanoTime();
                    drawBackground();
                    drawGame();
                    render();
                    long time = System.nanoTime() - startTime;
                    if(time<TARGET_TIME){
                        long sleep=(TARGET_TIME - time) / 1000000;
                        sleep(sleep);
                    }

                }
            }
        });
        initObjectGame();
        initKeyboard();
        initBullets();
        thread.start();

    }

    //Menambahkan Alien
    private void addMusuh() {
        Random ran = new Random();
        int locationY2 = ran.nextInt(height - 50) + 25;
        Musuh rocket2 = new Musuh();
        rocket2.changeLocation(width, locationY2);
        rocket2.changeAngle(180);
        enemys.add(rocket2);
    }

    //menampilkan posisi object
    private void initObjectGame(){
        player1 = new Player1();
        player1.changeLocation(100,120);
        enemys = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(start){
                    addMusuh();
                    sleep(2000);
                }
            }
        }).start();
    }



    private void initBullets(){
        bullets = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (start){
                    for (int i = 0; i<bullets.size(); i++){
                        Fire fire = bullets.get(i);
                        if(fire != null){
                            fire.update();
                            if (!fire.check(width,height)){
                                bullets.remove(fire);
                            }
                        }
                        else{
                            bullets.remove(fire);
                        }
                    }
                    sleep(1);
                }
            }
        }).start();
    }


    //keyboard control player1
    private void initKeyboard(){
        key = new Keyboard();
        requestFocus();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setLeft(true);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setRight(true);
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    key.setC(true);
                } else if (e.getKeyCode() == KeyEvent.VK_W){
                    key.setUp(true);
                } else if (e.getKeyCode() == KeyEvent.VK_S){
                    key.setDown(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    key.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    key.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    key.setC(false);
                } else if (e.getKeyCode() == KeyEvent.VK_W){
                    key.setUp(false);
                } else if (e.getKeyCode() == KeyEvent.VK_S){
                    key.setDown(false);
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                float s = 0f;
                double awal = 1;
                while(start){
                    double arahX = player1.getX();
                    double arahY = player1.getY();
                    float angle = player1.getAngle();
                    if (key.isLeft()){
                        angle -=s;
                        arahX -= awal;
                        player1.speedUp();
                    }
                    else if (key.isRight()){
                        angle += s;
                        arahX += awal;
                        player1.speedUp();
                    }
                    else if (key.isUp()){
                        angle -= s;
                        arahY -= awal;
                        player1.speedUp();
                    }
                    else if (key.isDown()){
                        angle += s;
                        arahY += awal;
                        player1.speedUp();
                    }
                    else{
                        player1.speedDown();
                    }
                    if(key.isC()){
                        if(shootTime == 0){
                            if(key.isC()){
                                bullets.add(0,new Fire(player1.getX(),player1.getY(), player1.getAngle(), 5,3f));
                            }
                        }
                        shootTime++;
                        if(shootTime==15){
                            shootTime = 0;
                        }
                    }else{
                        shootTime = 0;
                    }

                    player1.update();
                    player1.changeAngle(angle);
                    player1.changeLocation(arahX,arahY);
                    for (int i = 0; i < enemys.size(); i++) {
                        Musuh rocket = enemys.get(i);
                        if (rocket != null) {
                            rocket.update();
//                            if (!rocket.check(width, height)) {
//                                enemys.remove(rocket);
//                            } else {
//                                if (player1.isAlive()) {
//                                    checkPlayer(rocket);
//                                }
//                            }
                        }
                    }
                    sleep(6);
                }
            }
        }).start();
    }



    private void drawBackground(){
        g2.setColor(new Color(20, 20, 10));
        g2.fillRect(0,0,width,height);

    }

    //menampilkan pesawat
    private void drawGame() {
        player1.draw(g2);
        for (int i = 0; i < bullets.size(); i++) {
            Fire fire = bullets.get(i);
            if (fire != null) {
                fire.draw(g2);
            }
        }
        for (int i = 0; i < enemys.size(); i++) {
            Musuh rocket = enemys.get(i);
            if (rocket != null) {
                rocket.draw(g2);
            }
        }
    }


    private void render(){
        Graphics g = getGraphics();
        g.drawImage(Image,0,0,null);
        g.dispose();
    }

    private void sleep(long speed){
        try {
            Thread.sleep(speed);
        }catch (InterruptedException ex){
            System.err.println(ex);
        }

    }
}
