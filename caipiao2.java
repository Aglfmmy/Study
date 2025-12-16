
import java.util.Random;
import java.util.Scanner;

public class caipiao2 {
    // 代码功能:系统生成一个包含6个红球号码（1-33）和1个蓝球号码（1-16）的双色球彩票号码，红球号码不重复
    // 用户输入一组号码,将两组号码进行比较是否中奖
    // 一等奖：6红+1蓝，1000万元    二等奖：6红+0蓝，500万元    三等奖：5红+1蓝，3000元
    // 四等奖：5红+0蓝 或 4红+1蓝，200元 五等奖：4红+0蓝 或 3红+1蓝，10元
    //六等奖：0红+1蓝 或 1红+1蓝 或 2红+1蓝，5元


    // 代码功能实现的步骤
    // 1.系统自动生成一组中奖号码
    // 2.用户手动输入一组中奖号码
    // 3.通过比较两组号码,判断用户是否中奖以及中奖等级并输出中奖结果

    
    public static void main(String[] args) {
        // 将自动生成的中奖号码存入数组中
        int dataArr[];
        dataArr = auto();
        System.out.println("自动生成的号码为:");
        for (int i = 0; i < dataArr.length; i++) {
            System.out.println(dataArr[i]);
        }
        // 将用户输入的中奖号码存入数组中
        int userArr[];
        userArr=user();
        System.out.println("用户输入的号码为:");
        for (int i = 0; i < userArr.length; i++) {
            System.out.println(userArr[i]);
        }



        // 3.比较两组号码,判断用户是否中奖,以及中奖等级

        // 记录红球号码正确的个数
        int redTrue=0;
        // 遍历数组范围-1,因为最后一位是蓝球号码
        // 利用双层for循环将用户输入的号码与系统生成的号码每一位进行比较是否相同
        for (int i = 0; i < userArr.length-1;) {
            for (int j = 0; j < dataArr.length-1; j++) {
                if(userArr[i]==dataArr[j])
                {
                    // 红球号码相同,则变量redTrue值加1
                    redTrue++;
                    break;
                }
            }
            i++;
        }

        // 判断蓝球号码是否相同
        boolean blueTrue=false;
        if(userArr[6]==dataArr[6])
        {
            blueTrue=true;
        }
        
        // 判断是否中奖并输出中奖结果
        switch(redTrue)
        {
            case 0,1,2->    {System.out.println(blueTrue?"六等奖,奖金5元":"未中奖");}
            case 3->  {System.out.println("五等奖,奖金10元");}
            case 4-> { System.out.println(blueTrue?"四等奖,奖金200元":"五等奖,奖金10元");}
            case 5-> {System.out.println(blueTrue?"三等奖,奖金3000元":"四等奖,奖金200元");}
            case 6-> {System.out.println(blueTrue?"一等奖,奖金1000万元":"二等奖,奖金500万元");}
        }
    }
        





    // 2.用户输入中奖号码
    public static int[] user() {
        Scanner sc = new Scanner(System.in);
        int userNumber[] = new int[7];
        // 用户输入6个红球号码
        for (int i = 0; i < 6;) {
            System.out.println("请输入第" + (i + 1) + "个红球号码:");
            int uredNumber = sc.nextInt();
            // 判断用户输入的红球号码是否在1-33范围内
            if (uredNumber >= 1 && uredNumber <= 33) {
                // 判断用户输入的红球号码是否重复
                if (!chazhao(userNumber, uredNumber)) {
                    userNumber[i] = uredNumber;
                    i++;
                } else {
                    System.out.println("号码重复，请重新输入");
            
                }
                }else
                {System.out.println("输入的红球号码不在规定范围内");}

        }

        System.out.println("请输入1个蓝球号码:");
        for (int i = 0; i < 1;) {
        // 用户输入蓝球号码
        int ublueNumber=sc.nextInt();
        // 判断用户输入的蓝球号码是否在1-16范围内
        if(ublueNumber>=1&&ublueNumber<=16){
            // 将用户输入的蓝球号码放入数组最后一位
            userNumber[6]=ublueNumber;
            i++;
        }
        else {System.out.println("输入的蓝球号码不在规定范围内");}
        }
        
        // 返回用户输入的号码
        return userNumber;
    }









    // 1.自动生成中奖号码
    public static int[] auto() {

        int[] autoNumber = new int[7];
        //随机生成红球的号码且不重复
        Random r = new Random();
        for (int i = 0; i < autoNumber.length - 1;) {
            int redNumber = r.nextInt(33) + 1;
            if (!chazhao(autoNumber, redNumber)) {
                autoNumber[i] = redNumber;
                i++;
            }

        }
        int blueNumber;
        //随机生成蓝球的号码
        blueNumber = r.nextInt(16) + 1;
        // 将蓝球号码放入数组最后一位
        autoNumber[6] = blueNumber;
        // 返回自动生成的号码
        return autoNumber;
    }

    //查找某一值是否在数组中存在
    public static boolean chazhao(int a[], int b) {
        boolean n = false;
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                n = true;
            }
        }
        return n;
    }
}
