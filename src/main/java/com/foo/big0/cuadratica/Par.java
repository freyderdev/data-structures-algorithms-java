package com.foo.big0.cuadratica;

public class Par {
    private int x;
    private int y;

    public Par(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
