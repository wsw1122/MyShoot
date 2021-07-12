/*
 * @Title: 天空
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;
import java.awt.*;

public class Sky extends FlyingObject{
    private double y1; //第二张背景的y坐标
    public Sky(double width, double height, double x, double y, double speed,double y1) {
        super(width,height,x,y);

        this.speed = speed;
        this.y1 = y1;
        image = Images.sky;
        width = image.getIconWidth();
        height = image.getIconHeight();
    }
    public void move() {
        y+=speed;
        y1+=speed;
        if (y>=700){
            y = -700;
        }
        if (y1>=700){
            y1 = -700;
        }
    }
    //重写paintObject画对象天空需要两张图做循环
    @Override
    public void paintObject(Graphics g){
        super.paintObject(g);
        image.paintIcon(null,g,(int) x,(int) y1);
    }
}
