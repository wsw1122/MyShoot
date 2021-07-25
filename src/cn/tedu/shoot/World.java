/*
 * @Title: World
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/3  21:25
 */
package cn.tedu.shoot;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class World extends JPanel {
    private Sky s;
    private Hero h;
    //利用数组管理能打掉的飞机类
    private FlyingObject[] planes;
    private Bullet[] bts ;
    private int index = 0;
    private int score = 0;
    private int life = 3;
    public static final int READY = 0;
    public static final int RUNNING = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER = 3;
    private int state = READY;
    //初始化
    public World() {
        s = new Sky();
        h = new Hero(140, 400);
        planes = new FlyingObject[0];
        bts = new Bullet[0];
    }
    //画布
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setSize(400, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        world.action();
    }
    //随机生成飞机
    public void createPlane() {
        //生成速度减小18倍
        if (index % 18 == 0) {
            Random random = new Random();
            int n = random.nextInt(10);
            Plane plane;
            //当随机数时0~6 的时候创建 小飞机
            if (n <= 6) {
                plane = new Airplane();
                //当随机数时7~8 的时候创建 大飞机
            } else if (n <= 8) {
                plane = new Bigplane();
                //当随机数时9 的时候创建 小蜜蜂
            } else {
                plane = new Bee();
            }

            //为数组添加敌机
            planes = Arrays.copyOf(planes, planes.length + 1);
            planes[planes.length - 1] = plane;
        }
        index++;
    }
    //创建子弹
    public void fireAction() {
        //如果英雄已经死亡
        if (!h.isLiving()){
            return;
        }
        if (index % 10 == 0) {
            Bullet[] double_bullet = h.openFire();
            int len = bts.length;
            //扩容子弹
            Bullet[] arr = Arrays.copyOf(bts,len+double_bullet.length);
            //合并数组
            System.arraycopy(double_bullet,0,arr,len,double_bullet.length);
            bts = arr;
        }
    }
    @Override
    //开始画图
    public void paint(Graphics g) {
        s.paintObject(g);
        h.paintObject(g);
        for (int i = 0; i < planes.length; i++) {
            planes[i].paintObject(g);
        }
        for (int i = 0; i < bts.length; i++) {
            bts[i].paintObject(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("宋体",Font.BOLD,20));
        g.drawString("分数："+score ,20,40);
        g.drawString("生命："+life ,20,60);

        if(state == READY){
            Images.start.paintIcon(this,g,0,0);
        }
        if(state == PAUSE){
            Images.pause.paintIcon(this,g,0,0);
        }
        if (state == GAME_OVER){
            Images.gameover.paintIcon(this,g,0,0);
        }
    }
    //子弹和飞机移动方法
    public void objectMove(){
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].isLiving()) {
                planes[i].move();
            }

        }
        for (int i = 0; i < bts.length; i++) {
            if (bts[i].isLiving()) {
                bts[i].move();
            }

        }
    }
    //击中碰撞检查
    public void hitDection() {
        for (int i = 0; i < bts.length; i++) {
            if (!bts[i].isLiving()) {
                continue;
            }
            for (int j = 0; j < planes.length; j++) {
                if (!planes[j].isLiving()) {
                    continue;
                }
                if (planes[j].duang(bts[i])) {
                    planes[j].hit();
                    bts[i].goDead();
                    scores(planes[j]);
                }
            }
        }
    }
    //英雄机碰撞检测
    public void runAway(){
        //检查英雄机状态
        if(h.isLiving()){
            for (int i = 0; i < planes.length; i++) {
                if(!planes[i].isLiving()){
                    continue;
                }
                if(h.duang(planes[i])){
                    h.goDead();
                    planes[i].goDead();
                    break;
                }
            }
        }else if (h.isZombie()){
            if(life>0){
                h = new Hero(140, 400);
                for (int i = 0; i < planes.length; i++) {
                    planes[i].goDead();
                }
                life--;
            }else {
                state = GAME_OVER;
            }
        }
    }
    //得分和奖励
    public void scores(FlyingObject plane){
        //判断飞行物状态
        if(plane.isDead()){
            //判读plane是否是接口实现
            if(plane instanceof Enemy){
                //向下转型
                Enemy enemy = (Enemy) plane;
                score += enemy.getScore();
            }

            //获取Bee奖品

            if (plane instanceof Award){
                Award award = (Award) plane;
                int type = award.getAward();
                if(type == award.DOUBLE_FILE){
                    h.doubleFire();
                }else if(type == Award.LIFT){
                    life++;
                }

            }
        }

    }
    //清除数组
    public void clean() {
        //清除敌机
        FlyingObject[] living = new FlyingObject[planes.length];
        int index = 0;
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].isZombie() || planes[i].outOfBounds()) {
                continue;
            }
            living[index++] = planes[i];
        }
        //重新赋值新数组
        planes = Arrays.copyOf(living, index);
        //清除子弹
        Bullet[] arr = new Bullet[bts.length];
        index = 0;
        for (int i = 0; i < bts.length; i++) {
            if (bts[i].isDead() || bts[i].outOfBounds()) {
                continue;
            }

            arr[index++] = bts[i];
        }
        bts = Arrays.copyOf(arr, index);
    }
    //鼠标控制英雄机的移动和游戏的开始暂停
    public void action() {
        Timer timer = new Timer();  //1.创建定时器对象
        LoopTask task = new LoopTask(); //2.创建定时任务
        timer.schedule(task, 1000, 10); //定时任务  1内部类  2多长时间后执行 3间隔多次时间执行
        //创建鼠标事件
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (state == RUNNING){
                    double x = e.getX() - h.width / 2;
                    double y = e.getY() - h.height / 2;
                    if (h.isLiving()){
                        h.move(x, y);
                    }
                }
            }
        });
        //切换状态
        this.addMouseListener(new MouseAdapter(){
            //点击鼠标
            @Override
            public void mouseClicked(MouseEvent e) {
                if(state == READY){
                    state=RUNNING;
                }else if (state == GAME_OVER){
                    score = 0;
                    life = 3;
                    s = new Sky();
                    h = new Hero(140, 400);
                    planes = new FlyingObject[0];
                    bts = new Bullet[0];
                    state = READY;
                }
            }
            //鼠标进入
            @Override
            public void mouseEntered(MouseEvent e) {
                if(state == PAUSE){
                    state=RUNNING;
                }
            }
            //鼠标离开
            @Override
            public void mouseExited(MouseEvent e) {
                if(state == RUNNING){
                    state=PAUSE;
                }
            }

        });

    }

    class LoopTask extends TimerTask {

        //重新定时任务run方法
        @Override
        public void run() {
            //创建飞机
            if (state == RUNNING){
                createPlane();
                //创建子弹
                fireAction();
                //敌机和子弹移动
                objectMove();
                //检测碰撞
                hitDection();
                //英雄机碰撞检测
                runAway();
                //清除死亡单位
                clean();

            }
            //背景移动
            s.move();
            //重新画图
            repaint();
        }
    }

}
