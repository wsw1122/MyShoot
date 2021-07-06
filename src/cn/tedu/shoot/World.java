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
import java.util.Timer;
import java.util.TimerTask;
public class World extends JPanel{
    private Sky s;
    private Hero h;
    private Airplane[] as = new Airplane[2];
    private Bigplane[] bas = new Bigplane[2];
    private Bee[] bs = new Bee[2];
    private Bullet[] bts = new Bullet[2];
    public World(){
        s =new Sky(400,700,0,0,1,-700);
        h = new Hero(65,50,140,400,0);
        as[0] = new Airplane(45,45,10,30,2);
        as[1] = new Airplane(45,45,300,30,2);
        bas[0] = new Bigplane(80,80,20,100,2);
        bas[1] = new Bigplane(80,80,120,30,2);
        bs[0] = new Bee(30,30,120,130,2,1);
        bs[1] = new Bee(30,30,220,300,2,-1);
        bts[0] = new Bullet(8,8,220,300,2,2);
        bts[1] = new Bullet(8,8,220,200,2,2);
    }




    @Override
    public void paint(Graphics g) {
        s.paintObject(g);
        h.paintObject(g);
        for (int i = 0; i < as.length; i++) {
            as[i].paintObject(g);
        }
        for (int i = 0; i < bas.length; i++) {
            bas[i].paintObject(g);
        }
        for (int i = 0; i < bs.length; i++) {
            bs[i].paintObject(g);
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
            s.move();
            for (int i = 0; i < as.length; i++) {
                as[i].move();
            }
            for (int i = 0; i < bas.length; i++) {
                bas[i].move();
            }
            for (int i = 0; i < bs.length; i++) {
                bs[i].move();
            }
            for (int i = 0; i < bts.length; i++) {
                bts[i].move();
            }
            //重新画图
            repaint();
        }
    }

}
