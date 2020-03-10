import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class T200310 {
	public static void main(String[] args) {
		//输出一个整数的每一位
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0) {
        	n = -n;
        }
		while(n != 0) {
			int tmp = n % 10;
            System.out.print(tmp);
			n = n/10;
		}
	}

	public static void main4(String[] args) {
		//获取一个数二进制序列中所有的偶数位和奇数位,分别输出二进制序列
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		
		//奇数
		for(int i = 31; i >= 1; i-=2) {
            System.out.print( ((n >>> i) & 1) + " ");
		}
        System.out.println();

        //偶数
        for(int i = 30; i >= 0; i-=2) {
            System.out.print( ((n >>> i) & 1) + " ");
		}
	}

	public static void main3(String[] args) {
		//写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
		//更优解
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n != 0) {
        	count++;
        	n = n & (n-1);
        }
        System.out.println(count);
		/*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n != 0) {
        	if((n & 1) != 0) {
        		count++;
        	}
        	n = n >>> 1;//针对负数
        }
        System.out.println(count);*/
	}

	public static void main2(String[] args) {
		//编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
        //入，最多输入三次。三次均错，则提示退出程序
		Scanner sc = new Scanner(System.in);
		int count = 3;
        System.out.println("请输入密码，您有三次机会");
		while(count != 0) {
            System.out.println("请输入密码");
            String password = sc.next();
            //在java中，若要判断两个字符串是否相等，用方法 equals
            if(password.equals("123456")) {//equals ——> "=="
                System.out.println("登陆成功");
                break;
            }else {
            	count--;
                System.out.println("登录失败,你还有" + count +"次的机会");
            }
		}
		/*Random random = new Random();//若（）内有指定整数，则每次随机数相同；若无，则每次不同
		int rand = random.nextInt(1000);//[0——100)——>实际上[0——99]
		for(int i = 1; i <= 3; i++) {
            String password = sc.next();
            if(password == randam) {
            	System.out.println("密码正确");
            }else {
            	System.out.println("密码错误");
            }
		}
        System.out.println("已错三次，退出程序");*/
	}

	public static void main1(String[] args) {
		//0～999之间的所有“水仙花数”并输出
		//1.判断i是几位数(一般用除法)
		//123
		int i = 0;
		for(i = 0; i <= 999; i++) {
		    int count = 0;//存放数字的位数
		    int tmp = i;//保存i
			while(tmp != 0) {
				count++;//          1             2           3
				tmp = tmp/10;//  123/10=12     12/10=1     1/10=0
			}//此时tmp=0;
			//2.求每个数字i的每一位，用于count的次方运算(用模%计算)
			tmp = i;
			int sum = 0;
			while(tmp != 0) {
				sum += Math.pow(tmp%10, count);//             123%10=3  3^count
				//复合运算符不需强转类型                      12%10=2   2^count
				tmp= tmp/10;//123/10=12 12/10=1 1/10=0        1%10=1    1^count
			}//3.sum 就是每个位上数字的次方和
			if(sum == i) {
				System.out.print(sum + " ");
			}
		}
	}
}