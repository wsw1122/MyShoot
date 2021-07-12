/*
 * @Title: 小敌机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:10
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Airplane extends Plane {

    public Airplane(double width, double height, double x, double y, double speed) {
        super(width, height, x, y);
        this.speed = speed;
        image = Images.airplane[1];
        width = image.getIconWidth();
        height = image.getIconHeight();
    }

}
