/*
 * @Title: Images
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/8  20:27
 */
package cn.tedu.shoot;

import javax.swing.*;

public class Images {
    public static ImageIcon[] airplane = new ImageIcon[2];
    public static ImageIcon[] bigairplane = new ImageIcon[2];
    public static ImageIcon[] bee = new ImageIcon[2];
    public static ImageIcon[] hero = new ImageIcon[2];
    public static ImageIcon[] bom = new ImageIcon[4];
    public static ImageIcon bullet;
    public static ImageIcon sky;
    public static ImageIcon start;
    public static ImageIcon pause;
    public static ImageIcon gameover;


    static {
        for (int i = 0; i < airplane.length; i++) {
            airplane[i] = new ImageIcon("images/airplane"+i+".png");
        }
        for (int i = 0; i < bigairplane.length; i++) {
            bigairplane[i] = new ImageIcon("images/bigairplane"+i+".png");
        }
        for (int i = 0; i < bee.length; i++) {
            bee[i] = new ImageIcon("images/bee"+i+".png");
        }
        for (int i = 0; i < hero.length; i++) {
            hero[i] = new ImageIcon("images/hero"+i+".png");
        }
        for (int i = 0; i < bom.length; i++) {
            bom[i] = new ImageIcon("images/bom"+(i+1)+".png");
        }
        bullet = new ImageIcon("images/bullet.png");
        sky = new ImageIcon("images/background.png");
        start = new ImageIcon("images/start.png");
        pause = new ImageIcon("images/pause.png");
        gameover = new ImageIcon("images/gameover.png");
    }

}
