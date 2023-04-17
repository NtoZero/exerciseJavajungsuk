//[13-9] 다음은 사용자의 입력을 출력하고 종료하는 프로그램을 작성한 것으로, 10초 동안 입력이 없으면 자동종료되어야 한다.
//        그러나 실행결과를 보면, 사용자의 입력이
//        10초 안에 이루어졌음에도 불구하고 프로그램이 즉시 종료되지 않는다.
//        사용자로부터 입력받는 즉시 프로그램이 종료되도록 수정하시오.


import javax.swing.JOptionPane;

class Sol_Exercise13_9 {
    public static void main(String[] args) throws Exception {
        //⭐run()이 구현되어 있는 쓰레드 객체 생성
        Sol_Exercise13_9_1 th1 =new Sol_Exercise13_9_1();
        //⭐호출 스택 하나 더 만들어 그곳에서 th1.run()을 동작시킴.
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 "+input +"입니다.");
        th1.interrupt(); //⭐ 쓰레드에게 작업을 멈추라고 요청한다.
    }
}

class Sol_Exercise13_9_1 extends Thread {
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);

            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                //💡⭐sleep()에 의해 쓰레드가 잠시 멈춰있을 때, `interrupt()`를 호출하면 `InterruptedException`이 발생되고
                // 쓰레드의 interrupted상태는 false로 자동 초기화된다. ➡️ 쓰레드의 interrupted상태를 true로 다시 바꿔줘야 한다.
                interrupt();
            }
        }

        System.out.println("카운트가 종료되었습니다.");
    } // main
}

/*
<실행결과>
(swing에 abcd를 입력)
10
9
8
입력하신 값은 abcd입니다.
7
6
5
4
3
2
1
카운트가 종료되었습니다.
 */

/*
<풀이 접근>
현재, 사용자의 입력이 이루어진 순간 쓰레드가 종료되어야 하지만,
쓰레드가 지속실행되는 문제가 있다.

 */

/*
<해설>
[해설]
💡⭐`sleep()`에 의해 쓰레드가 잠시 멈춰있을 때, `interrupt()`를 호출하면 `InterruptedException`이 발생되고 쓰레드의 `interrupted`상태는 `false`로 자동 초기화된다.
그래서, 위와 같이 catch블럭에 `interrupt()`를 추가로 넣어줘서 쓰레드의 `interrupted상태`를 `true`로 다시 바꿔줘야 한다.
보다 자세한 내용은 p.754를 참고하자.
 */