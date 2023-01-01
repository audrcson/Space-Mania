package board;

public class Keyboard {
    private boolean right;
    private boolean left;
    private boolean n;
    private boolean up;
    private boolean down;
    private boolean c;


    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isN() {
        return n;
    }

    public void setN(boolean n) {
        this.n = n;
    }



    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

}
