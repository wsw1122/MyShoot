/*
 * @Title: 英雄机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:10
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Hero extends FlyingObject {

//    private int fire; //火力值

    public Hero(double x,double y){
        super(x,y,Images.hero[0], Images.hero,Images.bom);
//        this.fire = fire;
    }
    public void move() {}
    public void move(double x,double y){
        this.x = x;
        this.y = y;
    }

    public Bullet fire(){
        double x = this.x+width/2-5;
        double y = this.y-15;
        Bullet bullet = new Bullet(x,y);
        return bullet;
    }
}
