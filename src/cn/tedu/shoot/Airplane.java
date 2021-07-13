/*
 * @Title: 小敌机
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/6/29  20:10
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Airplane extends Plane {
    // 根据位置自定义出场位置
    public Airplane( double x, double y, double speed) {
        super(x, y,Images.airplane[0],Images.airplane,Images.bom);
        this.speed = speed;
    }
    //调用父类随机生成的构造方法
    public Airplane(){
        super(Images.airplane[0],Images.airplane,Images.bom);
        speed = Math.random()*4+1.5;
    }
}
