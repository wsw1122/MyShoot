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
    public Sky() {
        super(0,0,Images.sky,null,null);
        this.speed = 0.8;
        this.y1 = -height;
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
