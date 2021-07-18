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
    //飞行物的三个状态
    public static final int LIVING = 1; //活着
    public static final int DEAD = 0;  //被击中
    public static final int ZOMBIE = -1; //僵尸
    //飞行物状态
    protected int state = LIVING;

    //飞行物生命值
    protected int life = 1;

    protected double width; //宽
    protected double height; //高
    protected double x;
    protected double y;
    protected ImageIcon image; //图片
    protected double speed;
    protected ImageIcon[] images;  //数组切换图片
    protected ImageIcon[] bom;      //数组切换爆炸图片
    protected int index = 0;
    private int i=0;
    public FlyingObject(double x,double y,ImageIcon image,ImageIcon[] images,ImageIcon[] bom){
        this.x = x;
        this.y = y;
        this.image = image;
        this.images = images;
        this.bom = bom;
        width = image.getIconWidth();
        height = image.getIconHeight();
    }
    /**
     * 无参构造,减少子类的编译错误
     * 因为子类继承父类后,如果在子类中添加了无参构造,会默认调用父类的无参构造,如果父类没有,会报异常
     */

    public FlyingObject(){};
    //    移动
    public abstract void move();
    //画对象
    public void paintObject(Graphics g){
        nextImage();
        image.paintIcon(null,g,(int) x,(int) y);
    }


    public boolean duang(FlyingObject bullet ){
        //敌机
        double r1 = Math.min(this.width,this.height)/2;
        double x1 = this.x+this.width/2;
        double y1 = this.y+this.height/2;

        //子弹
        double r2 = Math.min(bullet.width,bullet.height);
        double x2 = bullet.x+bullet.width/2;
        double y2 = bullet.y+bullet.height/2;

        //勾股定理
        double a = y2-y1;
        double b = x2-x1;

        double c = Math.sqrt(a*a+b*b);
        return c < r1+r2;


    }
    //定义播放动画帧

    public void nextImage(){
        switch (state){
            case LIVING:
                if (images == null) {
                    return;
                }
                image = images[(index++/20) % images.length];
                break;
            case DEAD:
                int index = i++ /30;
                if (bom == null) {
                    return;
                }
                if (index == bom.length){
                    state = ZOMBIE;
                    return;
                }
                image = bom[index];

        }

        // 播放小敌机  2
        //  index=0 (index++)=0  0%2=0  image=images[0];
        //  index=1 (index++)=1  1%2=1  image=images[1];
        //  index=2 (index++)=2  2%2=0  image=images[0];
        //  index=3 (index++)=3  3%2=1  image=images[1];
        // ...依次类推,当被除数是0,1,2,3,4..之类的周期性的正整数时
        //对%取余则余数的范围是[0,2)
        //除以20是为了++时候放慢20倍速

    }

    //击中后减少血量
    //减少生命值 true
    //已经死亡  false
    public boolean hit(){
        if (life > 0) {
            life--;
            if (life == 0){
                state = DEAD;
            }
            return true;
        }
        return false;
    }

    //设置死亡状态
    public boolean goDead(){
        if (state == LIVING) {
            life = 0;
            state = DEAD;
            return true;
        }else {
            return false;
        }
    }

    public boolean isLiving(){
        return state == LIVING;
    }

    public boolean isDead(){
        return state == DEAD;
    }

    public boolean isZombie(){
        return state == ZOMBIE;
    }
}
