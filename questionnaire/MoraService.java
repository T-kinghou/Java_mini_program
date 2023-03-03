package com.game;

import java.util.Scanner;

public class MoraService {
    private String option;

    public void infooptions() {
        System.out.println("A. 完全符合");
        System.out.println("B. 基本符合");
        System.out.println("C. 不太符合");
        System.out.println("D. 不符合");
        System.out.print("请输入你的选择：");
        // 定义输入
        Scanner input = new Scanner(System.in);
        option = input.nextLine();
    }

    public void remodify(int anser[], int y) {
        System.out.println("请重新选择答案");
        infooptions();
        int i = 0, a = 4;
        boolean loop = false;
        do {
            if (option == new MoraView().option(i)) {
                anser[y] = i + a;
                loop = true;
                i = 0;
                a = 4;
                break;
            }
            if (i > 3) {
                loop = true;
                System.out.println("你的输入有误，请重试 ");
            }
            i++;
            a--;
        } while (loop);
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void evaluation() {
        int all = new MoraView().getAllsocre();
        all = all / 10;
        switch (all) {
            case 8:
            case 7:
                System.out.println("太棒了，你的表现极其优秀");
                break;
            case 6:
            case 5:
                System.out.println("你的表现良好，请继续保持");
            case 4:
                System.out.println("你的表现欠佳，请规范自己的日常行为");
                break;

        }
    }
}
