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
    private int doubleFire;
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
        return new Bullet(x,y);
    }
    public void doubleFire(){
        doubleFire = 20;
    }
    public Bullet[] openFire(){
        if (doubleFire > 0){
            doubleFire--;
            double x = this.x+width/2-5;
            double y = this.y-15;
            Bullet b1= new Bullet(x+15,y);
            Bullet b2= new Bullet(x-15,y);
            return new Bullet[]{b1,b2};
        }else {
            Bullet b = fire();
            return new Bullet[]{b} ;
        }

    }
}
