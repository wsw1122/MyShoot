package cn.tedu.ball;


import cn.tedu.shoot.FlyingObject;
import cn.tedu.util.App;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Ball extends App{
    protected int d;
    protected double x;
    protected double y;
    protected int offsetX ,offsetY;
    protected int r,g,b;
    protected int is_del = 0;

    public Ball(){
        Random random = new Random();
        d = random.nextInt(60-10+1)+10;
        x = Math.random()*(800 - d);
        y = Math.random()*(600 - d);
        offsetX = random.nextInt(6-1+1)+1;
        offsetY = random.nextInt(6-1+1)+1;
        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);

    }
    public void move(){
        x+=offsetX;
        y+=offsetY;
        if(x > Math.abs(800-d)){
            offsetX = -offsetX;
            x = 800-d;
        }
        if(y > Math.abs(600-d)){
            offsetY = -offsetY;
            y = 600-d;
        }
        if(x<0){
            offsetX = -offsetX;
            x=0;
        }
        if(y<0){
            offsetY = -offsetY;
            y=0;
        }

    }

    public boolean isCollide(Ball ball){
        double a = (this.x+this.d/2) - (ball.x+ball.d/2);
        double b = (this.y+this.d/2) - (ball.y+ball.d/2);
        double c = Math.sqrt(a*a + b*b);
        return c < ((this.d/2)-(ball.d/2));
    }
    public void eat(Ball ball){

        if ( isCollide(ball)) {
            ball.is_del = 1;
            double r1 = this.d/2;
            double r2 = ball.d/2;
            double area = Math.PI*r1*r1 + Math.PI*r2*r2;
            double rx = Math.sqrt(area/Math.PI);
            this.d = (int) (rx*2);
        }
    }

}


class Demo extends App{
    int num = 100;
    Ball[] balls = new Ball[num];
    Ball[] living = new Ball[num];
    public Demo(){
        for (int i = 0; i < num; i++) {
            balls[i] = new Ball();
        }
    }
    @Override
    public void painting(Graphics2D g) {
        int index=0;
        while (index<balls.length){
            g.setColor(new Color(balls[index].r,balls[index].g,balls[index].b));
            g.fillOval((int) balls[index].x,(int) balls[index].y,balls[index].d,balls[index].d);
            balls[index].move();
            //清除小球
            for (int i = 0; i < balls.length; i++) {
                if(i == index){
                    continue;
                }
                if(balls[index].is_del == 0 && balls[i].is_del == 0){
                    balls[index].eat(balls[i]);
                }
            }
            index++;
        }
        del();
    }
    //清除小球
    public void del(){
        int index = 0;
        for (int i = 0; i < balls.length; i++) {

            if (balls[i].is_del == 1) {
                continue;
            }
            living[index++] = balls[i];
        }
        //重新赋值新数组
        balls = Arrays.copyOf(living, index);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
    }
}

