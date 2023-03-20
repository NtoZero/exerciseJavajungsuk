//[8-8] 다음은 1~100사이의 숫자를 맞추는 게임을 실행하던 도중에 숫자가 아닌 영문자를 넣어서 발생한 예외이다.
//예외처리를 해서 숫자가 아닌 값을 입력했을 때는 다시 입력을 받도록 보완하라.

//1과 100사이의 값을 입력하세요 :50
//더 작은 수를 입력하세요.
//1과 100사이의 값을 입력하세요 :asdf
//Exception in thread "main" java.util.InputMismatchException
//	at java.util.Scanner.throwFor(Scanner.java:819)
//	at java.util.Scanner.next(Scanner.java:1431)
//	at java.util.Scanner.nextInt(Scanner.java:2040)
//	at java.util.Scanner.nextInt(Scanner.java:2000)
//	at Exercise8_8.main(Exercise8_8.java:16)

import java.util.*;

class Sol_Exercise8_8 {
    public static void main(String[] args) {
        // 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
        int answer = (int)(Math.random() * 100) + 1;
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기 위한 변수

        do {

            count++;
            System.out.print("1과 100사이의 값을 입력하세요 :");
            try {   //
                input = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) { //🔥 input에 숫자 이외의 값을 입력했을 때
                System.out.println(">>숫자가 아닌 값을 입력하였습니다.\n>>1부터 100 사이의 숫자를 입력해주세요.");
                continue; //🔥 해당 break로 끝내지 않고 다시 do로 반복하게 해야함.
            } catch (Exception e) { //🔥 그 외 미처 잡지 못한 모든 예외 잡기
                System.out.println("올바른 값이 아닙니다.");
                continue;
            }
            if (answer > input) {
                System.out.println("더 큰 수를 입력하세요.");
            } else if (answer < input) {
                System.out.println("더 작은 수를 입력하세요.");
            } else {
                System.out.println("맞췄습니다.");
                System.out.println("시도횟수는 " + count + "번입니다.");
                break; // do-while문을 벗어난다

            }
        } while (true); // 무한반복문
    } // end of main
} // end of class HighLow



//	<실행결과>
//	1과 100사이의 값을 입력하세요 :50
//	더 작은 수를 입력하세요.
//	1과 100사이의 값을 입력하세요 :asdf
//	유효하지 않은 값입니다. 다시 값을 입력해주세요. 1과 100사이의 값을 입력하세요 :25
//	더 큰 수를 입력하세요.
//	1과 100사이의 값을 입력하세요 :38
//	더 큰 수를 입력하세요.
//	1과 100사이의 값을 입력하세요 :44
//	맞췄습니다. 시도횟수는 5번입니다.


/*
[해설] 사용자로부터 값을 입력받는 경우에는 유효성검사를 철저하게 해야 한다. 가 어떤 값을 입력할지 모르기 때문이다.
사용자 여기서는 간단하게 화면으로부터 값을 입력받는 부분에 try-catch구문으로 예외처리를
해주기만 하면 된다. 값을 입력받을 때 예외가 발생하면, 값을 다시 입력하라는 메세지를 보여주고 다시 입력 받으면 된다.

input = new Scanner(System.in).nextInt(); 를
                     ⬇️
try {
input = new Scanner(System.in).nextInt();
} catch(Exception e) {
System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
continue;
}
로 바꿔주면된다.
 */