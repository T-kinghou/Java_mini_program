package com.game;

/**
 * @author 侯贻达
 */
public class MoralAndLawBehaviorApp {
    public static void main(String[] args) {
        // 定义20道题目
        MoraView moraView = new MoraView();
       //moraView.deinfo();
        moraView.print();
        moraView.Definfo();
        System.out.println("总成绩为 "+ moraView.getAllsocre());
        new MoraService().evaluation();
        System.out.println("感谢您使用该问卷调查小程序，开发者:Kinghou");


    }
}
