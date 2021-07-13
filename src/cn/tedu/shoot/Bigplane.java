/*
 * @Title: 大敌机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:11
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Bigplane extends Plane{

    // 根据位置自定义出场位置
    public Bigplane( double x, double y, double speed) {
        super(x, y,Images.bigairplane[0],Images.bigairplane,Images.bom);
        this.speed = speed;
    }

    //调用父类随机生成的构造方法
    public Bigplane(){
        super(Images.bigairplane[0],Images.bigairplane,Images.bom);
        speed = Math.random()*3+1.5;
    }
}
