/*
 * @Title: 子弹
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bullet extends FlyingObject {
//    private int fire; //火力值

    public Bullet(double x,double y){
        super(x,y,Images.bullet,null,null);
//        this.fire = fire;
        this.speed = 4;
    }
    public void move() {
        y-=speed;
    }

}
