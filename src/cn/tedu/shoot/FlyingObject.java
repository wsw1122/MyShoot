/*
 * @Title: FlyingObject
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/1  21:14
 */
package cn.tedu.shoot;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public abstract class FlyingObject {
    protected double width; //宽
    protected double height; //高
    protected double x;
    protected double y;
    protected ImageIcon image; //图片
    protected double speed;


    public FlyingObject(double width,double height,double x,double y){

        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    //    移动
    public abstract void move();
    //画对象
    public void paintObject(Graphics g){
        image.paintIcon(null,g,(int) x,(int) y);
    }
}
