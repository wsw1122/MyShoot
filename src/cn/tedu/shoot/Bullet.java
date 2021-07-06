/*
 * @Title: 子弹
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bullet extends FlyingObject {
    private int fire; //火力值
    private double speed;

    public Bullet(double width,double height,double x,double y,double speed,int fire){
        super(width,height,x,y);
        this.fire = fire;
        this.speed = speed;
        image = new ImageIcon("images/bullet.png");
    }
    public void move() {
        y-=speed;
    }

}
