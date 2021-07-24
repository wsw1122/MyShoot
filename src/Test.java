/*
 * @Title: Test
 * @Package PACKAGE_NAME
 * @author wsw
 * @date 2021/7/20  20:47
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

   /*     Scanner sc = new Scanner(System.in);
        System.out.println("输入单价");
        double price = sc.nextDouble();
        System.out.println("输入数量");
        int num = sc.nextInt();
        System.out.println("输入金额");
        double money = sc.nextDouble();

        double total = price * num;

        if (total >= 500){
            total = total*0.8;
        }
        if(money >= total){
            double change = money-total;
            System.out.println("总价为："+total +"找零："+change);
        }else {
            double change = total-money;
            System.out.println("您的金钱不够还需要："+change);
        }
*/

        Scanner sc = new Scanner(System.in);
        System.out.println("输入号码");
        int code = sc.nextInt();
        switch (code){
            case 1:
                System.out.println("教学部");
                break;
            case 2:
                System.out.println("人事部");
                break;
            case 3:
                System.out.println("财务部");
                break;
            default:
                System.out.println("人工服务");
                break;
        }


        System.out.println("输入成绩");
        int score = sc.nextInt();
        String level;
        if(score >= 90){
            level = "A";
        }else if (score >=80){
            level = "B";
        }else if (score >=60){
            level = "C";
        }else {
            level = "D";
        }
        System.out.println("等级为"+level);
    }
}
