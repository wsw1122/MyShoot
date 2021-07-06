/*
 * @Title: 大敌机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bigplane extends FlyingObject{
    private double speed;

    public Bigplane(double width, double height, double x, double y, double speed) {
        super(width,height,x,y);
        this.speed = speed;
        image = new ImageIcon("images/bigairplane0.png");

    }
    public void move() {
        y+=speed;
    }
}
