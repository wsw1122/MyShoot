/*
 * @Title: World
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/3  21:25
 */
package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class World extends JPanel{
    private Sky s;
    private Hero h;
    //利用数组管理能打掉的飞机类
    private Plane[] planes;
    private Bullet[] bts = new Bullet[2];
    private int index = 0;
    public World(){
        s =new Sky();
        h = new Hero(140,400);
        bts[0] = new Bullet(8,8);
        bts[1] = new Bullet(8,8);
        planes = new Plane[6];
        planes[0] = new Airplane();
        planes[1] = new Airplane();
        planes[2] = new Bigplane();
        planes[3] = new Bigplane();
        planes[4] = new Bee();
        planes[5] = new Bee();

    }




    @Override
    public void paint(Graphics g) {
        s.paintObject(g);
        h.paintObject(g);
        for (int i = 0; i < planes.length; i++) {
            planes[i].paintObject(g);
        }
        for (int i = 0; i < bts.length; i++) {
            bts[i].paintObject(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setSize(400,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        world.action();
    }

    //启动程序的执行
    public void action(){
        Timer timer = new Timer();  //1.创建定时器对象
        LoopTask task = new LoopTask(); //2.创建定时任务
        timer.schedule(task,1000,10); //定时任务  1内部类  2多长时间后执行 3间隔多次时间执行
    }

    class LoopTask extends TimerTask{
        //重新定时任务run方法
        @Override
        public void run(){

            createPlane();
            s.move();
            for (int i = 0; i < planes.length; i++) {
                planes[i].move();
            }
            for (int i = 0; i < bts.length; i++) {
                bts[i].move();
            }
            //重新画图
            repaint();
        }

        //随机生成飞机
        public void createPlane(){
            //生成速度减小18倍
            if(index%18 == 0){
                Random random = new Random();
                int n = random.nextInt(10);
                Plane plane;
                //当随机数时0~6 的时候创建 小飞机
                if(n<=6){
                    plane = new Airplane();
                    //当随机数时7~8 的时候创建 大飞机
                }else if (n<=8){
                    plane = new Bigplane();
                    //当随机数时9 的时候创建 小蜜蜂
                }else {
                    plane = new Bee();
                }

                //为数组添加敌机
                planes = Arrays.copyOf(planes ,planes.length+1);
                planes[planes.length-1] = plane;
            }
            index++;
        }
    }

}
