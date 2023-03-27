
/*
[9-11] 커맨드라인으로 2~9사이의 두 개의 숫자를 받아서 두 숫자사이의 구구단을 출력 하는 프로그램을 작성하시오.
        예를 들어 3과 5를 입력하면 3단부터 5단까지 출력한다.

*/

import java.util.Scanner;

public class Sol_Exercise9_11 {
    static void gugudan() {
        int start=0;
        int end=0;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("시작 단을 입력해주세요(2~9단)>> ");
            start = scan.nextInt();
            if (start < 2 ||start > 9) {
                System.out.println("값을 잘못 입력하셨습니다.");
                continue;
            }
            System.out.println("끝 단을 입력해주세요(2~9단)");
            end = scan.nextInt();
                while(end<start||end<2||end>9) {
                    System.out.println("끝 단을 다시 입력 해주세요. \n끝 단은 2~9단 사이이며, 시작 단 보다 높아야 합니다.");
                    System.out.println("현재 시작 단: " + start);
                    System.out.println("끝 단을 입력해주세요>>");
                    end = scan.nextInt();
                }
                break;
        }
        for(int i=start; i<=end; i++) {
            for(int j=1; j<=9; j++) {
                System.out.println(i+"*"+j+"="+i*j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        gugudan();
    }
}



/*
<실행결과>
C:\jdk1.8\work\ch9>java Exercise9_11 2 시작 단과 끝 단, 두 개의 정수를 입력해주세요.
USAGE : GugudanTest 3 5

C:\jdk1.8\work\ch9>java Exercise9_11 1 5
단의 범위는 2와 9사이의 값이어야 합니다.
USAGE : GugudanTest 3 5

C:\jdk1.8\work\ch9>java Exercise9_11 3 5 3*1=3
3*2=6
3*3=9
3*4=12
3*5=15
3*6=18
3*7=21
3*8=24
3*9=27

4*1=4
4*2=8
4*3=12
4*4=16
4*5=20
4*6=24
4*7=28
4*8=32
4*9=36

5*1=5
5*2=10
5*3=15
5*4=20
5*5=25
5*6=30
5*7=35
5*8=40
5*9=45
 */

/*
<모범풀이>
class Exercise9_11 {
    public static void main(String[] args) { int from = 0;
        int to = 0;

        try {
            if(args.length!=2)
                throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
            from = Integer.parseInt(args[0]); to = Integer.parseInt(args[1]);

            if(!(2 <= from && from <= 9 && 2 <= to && to <= 9))
                throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.");
        } catch(Exception e) { System.out.println(e.getMessage()); System.out.println("USAGE : GugudanTest 3 5"); System.exit(0);
        }

// 시작 단(from)이 끝 단(to)보다 작아야하니까
// to보다 from의 값이 크면 두 값을 바꾼다. if(from > to) {
        int tmp = from; from = to;
        to = tmp;
    }

// from단부터 to단까지 출력한다. for(int i=from;i<=to;i++) {
for(int j=1;j<=9;j++) { System.out.println(i+"*"+j+"="+i*j);
    }
System.out.println();
}
} // main
        }*/
