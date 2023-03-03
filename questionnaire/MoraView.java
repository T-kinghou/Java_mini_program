package com.game;

import java.util.Scanner;

public class MoraView {
    private int allsocre;
    //private  String[] questions;
    private int num[] = new int[20];

    //定义20道题
        String questions[] = {"1. 是否遵守法律法规？", "2. 是否尊重他人？",
                "3. 是否有责任心？", "4. 是否有礼貌？",
                "5. 是否有自律？", "6. 是否有负责任的态度？",
                "7. 是否有良好的道德观？", "8. 是否有良好的道德行为？",
                "9. 是否有良好的道德标准？", "10. 是否有良好的道德观念？",
                "11. 是否有良好的道德修养？", "12. 是否有良好的道德风尚？",
                "13. 是否有良好的道德准则？", "14. 是否有良好的道德观念？",
                "15. 是否有良好的道德修养？", "16. 是否有良好的道德风尚？",
                "17. 是否有良好的道德准则？", "18. 是否有良好的道德观念？",
                "19. 是否有良好的道德修养？", "20. 是否有良好的道德风尚？"};

    public void print(){
        System.out.println("=============================");
        System.out.println("现在开始答题，如有选错，请输入重新选择答案");
    }
    public void Definfo() {

        // 定义ABCD选项
        String[] options = {"A", "B", "C", "D"};
        // 定义总分
        int totalScore = 0;
        MoraService moraService = new MoraService();
        int x = 0;
        // 判断输入是否正确
        for ( x = 0; x < questions.length; x++) {
            System.out.println(questions[x]);
            moraService.infooptions();
            if(moraService.getOption().equals("重新选择答案")){
                System.out.print("请输入你要修改的题号： ");
                Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();
                moraService.remodify(num,a);
                x--;
            }
            else if (moraService.getOption().equals(options[0]) ||
                    moraService.getOption().equals(options[1])
                    || moraService.getOption().equals(options[2])
                    || moraService.getOption().equals(options[3])) {
                for (int i = 1, j = 3; j >= 0; j--) {
                    if (moraService.getOption().equals(options[j])) {
                        num[x] = i;
                        break;
                        //allsocre += i;
                        //i = 1;
                    } else {
                        i++;
                    }
                }
            } else {
                System.out.println("你的输入有误，请重新输入");
                x--;
            }

        }

    }

    public int getAllsocre() {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum+=num[i];
        }
        return sum;
    }

    public void setAllsocre(int allsocre) {
        this.allsocre = allsocre;
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }
    public String option(int n){
        // 定义ABCD选项
        String[] options = {"A", "B", "C", "D"};
        return options[n];
    }
}

