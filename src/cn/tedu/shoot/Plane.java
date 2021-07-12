/*
 * @Title: Plane
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/10  20:25
 */
package cn.tedu.shoot;

public abstract class Plane extends FlyingObject{

    public Plane(double width, double height, double x, double y) {
        super(width,height,x,y);
    }
    @Override
    public  void move() {
        y+=speed;
    }
}
