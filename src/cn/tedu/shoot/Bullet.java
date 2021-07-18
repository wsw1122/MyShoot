/*
 * @Title: 子弹
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;
import java.util.Arrays;

public class Bullet extends FlyingObject {
//    private int fire; //火力值

    public Bullet(){};
    public Bullet(double x,double y){
        super(x,y,Images.bullet,null,null);
//        this.fire = fire;
        this.speed = 4;
    }
    public void move() {
        y-=speed;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "state=" + state +
                ", life=" + life +
                ", width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", image=" + image +
                ", speed=" + speed +
                ", images=" + Arrays.toString(images) +
                ", bom=" + Arrays.toString(bom) +
                ", index=" + index +
                '}';
    }
}
