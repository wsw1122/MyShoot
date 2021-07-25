/*
 * @Title: 小蜜蜂
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;
public class Bee extends Plane implements Award{
    private int direction;
    // 根据位置自定义出场位置
    public Bee( double x, double y, double speed) {
        super(x, y,Images.bee[0],Images.bee,Images.bom);
        this.speed = speed;
        this.direction = Math.random() >= 0.5 ? 1: -1;
//        System.out.println( this.direction);
    }

    //调用父类随机生成的构造方法
    public Bee(){
        super(Images.bee[0],Images.bee,Images.bom);
        speed = Math.random()*5+1.5;
        this.direction = Math.random() >= 0.5 ? 1: -1;
    }
    public void move() {
        y+=speed;
        x+=direction;
        if (x<=0){
            direction = 1;
        }
        if (x>=400-width){
            direction = -1;
        }
    }

    @Override
    public int getAward() {
        return Math.random() >= 0.5 ? DOUBLE_FILE: LIFT;
    }
}
