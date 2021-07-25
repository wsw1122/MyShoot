/*
 * @Title: MouseAction
 * @Package cn.tedu.shoot
 * @author wsw
 * @date 2021/7/25  9:57
 */
package cn.tedu.shoot;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAction extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击了");
    }
}
