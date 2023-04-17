//[13-2] 다음 코드의 실행결과로 옳은 것은?

class Exercise13_2 {
    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        t1.run();

        for (int i = 0; i < 10; i++) System.out.print(i);
    }
}

class Thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) System.out.print(i);
    }
}

/*
a. 01021233454567689789처럼 0부터 9까지의 숫자가 섞여서 출력된다.
b. 01234567890123456789처럼 0부터 9까지의 숫자가 순서대로 출력된다.
c. IllegalThreadStateException이 발생한다.
 */

/*
<풀이 접근>
해당 소스코드에서 쓰레드는 main 쓰레드와 th1 쓰레드로 각각 2개이다.
동기화되지 않은 단일 자원(데이터, 출력)에 대한 멀티 쓰레딩은 두 쓰레드가 빠른 속도로 번갈아가며 수행되므로,
a가 옳다.

<오답 복기>
자세히 보니 ⭐t1.start()를 호출한 것이 아니라 t1.run()을 호출했다.
t1.start()는 새 호출 스택을 만들어 쓰레드를 통한 run()을 동작시키는데 반면,
t1.run()은 새 호출 스택을 만들지 않고 main쓰레드 안에서 run()을 구동시키므로,
해당 run()이 끝나고 난 이후에 main 쓰레드의 for문이 동작한다.

따라서 b가 옳다.
 */

/*
[정답] b
[해설]
Thread2클래스의 인스턴스를 생성하긴 했지만, start()가 아닌
run()을 호출함으로써 쓰레드를 실행시킨 것이 아니라 단순히 Thread2클래스의 메서드를 호출한 셈이 되었다.
만일 run()이 아닌 start()를 호출하였다면, 숫자가 섞여서 출력되었을 것이다.
 */