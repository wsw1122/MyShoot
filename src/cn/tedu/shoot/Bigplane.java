/*
 * @Title: 大敌机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bigplane extends Plane{

    public Bigplane(double width, double height, double x, double y, double speed) {
        super(width,height,x,y);
        this.speed = speed;
        image = Images.bigairplane[0];
        width = image.getIconWidth();
        height = image.getIconHeight();
    }
}
