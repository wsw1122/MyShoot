package cn.tedu.shoot;/*
 * @Title: cn.tedu.shoot.Interface
 * @Package PACKAGE_NAME
 * @author wsw
 * @date 2021/7/18  16:45
 */

public class Interface {
    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.abc();
        System.out.println(frog.creep(1));
    }
}
interface Creep{
    public int creep(int a);
}
interface Swimming{
    public void swimming();
    public default void abc(){
        System.out.println("aaaa");
    }
}

class Frog implements Creep,Swimming{
    @Override
    public int creep(int a) {
        return a;
    }

    @Override
    public void swimming() {

    }
}