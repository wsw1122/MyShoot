/*
 * @Title: 小蜜蜂
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bee extends Plane{
    private int direction;
    public Bee(double width, double height, double x, double y, double speed,int direction) {
        super(width,height,x,y);
        this.speed = speed;
        this.direction = direction;
        image = Images.bee[0];
        width = image.getIconWidth();
        height = image.getIconHeight();
    }
    public void move() {
        y+=speed;
        x+=direction;
        if (x<=0){
            direction = 1;
        }
        if (x>=400){
            direction = -1;
        }
    }
}
