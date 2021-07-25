/*
 * @Title: Test
 * @Package PACKAGE_NAME
 * @author wsw
 * @date 2021/7/20  20:47
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test1 test1 = new Test2();
        test1.run();
    }
}
class Test1{
    public void run(){
        System.out.println("BBB");
    }
}
class Test2 extends Test1{
    public void run(){
        System.out.println("aaaa");
    }
}