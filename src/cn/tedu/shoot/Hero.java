/*
 * @Title: 英雄机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:10
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Hero extends FlyingObject {

    private int fire; //火力值

    public Hero(double width,double height,double x,double y,int fire){
        super(width,height,x,y);
        this.fire = fire;
        image = Images.hero[0];
        width = image.getIconWidth();
        height = image.getIconHeight();
    }
    public void move() {

    }

}
