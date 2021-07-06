/*
 * @Title: FlyingObject
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/1  21:14
 */
package cn.tedu.shoot;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public class FlyingObject {
    protected double width; //宽
    protected double height; //高
    protected double x;
    protected double y;
    protected ImageIcon image; //图片


    public FlyingObject(double width,double height,double x,double y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    //    移动
    public void move() {
        System.out.println("单位飞行！");
    }
    //画对象
    public void paintObject(Graphics g){
        image.paintIcon(null,g,(int) x,(int) y);
    }
}
