/*
 * @Title: Plane
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/10  20:25
 */
package cn.tedu.shoot;

import javax.swing.*;
import java.util.Random;
public abstract class Plane extends FlyingObject{
    //无参构造:为了避免子类继承错误
    public Plane(){};
    //带参构造:根据位置初始化对象数据
    public Plane(double x, double y , ImageIcon image, ImageIcon[] images,ImageIcon[] bom) {
        super(x,y,image,images,bom);
    }
    //带参构造:利用算法实现让飞行物从屏幕上方随机出现
    public Plane(ImageIcon image, ImageIcon[] images,ImageIcon[] bom){
        width = image.getIconWidth();
        height = image.getIconHeight();
        Random random = new Random();
        x = random.nextInt(400-(int) width);
        y = -height;
        this.image = image;
        this.images = images;
        this.bom = bom;
    }
    @Override
    public  void move() {
        y+=speed;
    }
}
