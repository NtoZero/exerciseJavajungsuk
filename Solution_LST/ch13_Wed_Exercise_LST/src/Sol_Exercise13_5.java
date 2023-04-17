//[13-5] 다음의 코드를 실행한 결과를 예측하고, 직접 실행한 결과와 비교하라.
// 만일 예측한 결과와 실행한 결과의 차이가 있다면 그 이유를 설명하라.

class Exercise13_5 {
    public static void main(String[] args) throws Exception {
        Thread3 th1 = new Thread3();
        th1.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (Exception e) {
        }

        throw new Exception("꽝~!!!");
    }
}

class Thread3 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    } // run()
}

/*
<풀이접근>
Thread3의 run()은 0부터 9까지 숫자를 매 초마다 출력하는 메서드이다.
main 쓰레드에서 Thread3에 대한 쓰레드를 생성하여 (Thread3 th1 = new Thread3();)
th1.start();로 호출 스택 하나를 더 만들어 멀티쓰레딩이 구동되도록 했다.
join()이나 wait()이 메인 쓰레드에 존재하지 않으므로 main 쓰레드 역시 계속 동작한다.

main쓰레드는 5초를 쉬고,
새 예외를 고의 발생시킨다. (throw new Exception("꽝~!!!");)
main쓰레드 단의 예외는 JVM이 받는 것으로 생각된다.

th1 쓰레드는 동작을 멈출까? 아니다. 별도의 호출스택에서 동작하므로,
계속해서 9까지 숫자를 출력할 것이다.

<실행결과>
0
1
2
3
4
Exception in thread "main" java.lang.Exception: 꽝~!!!
	at Exercise13_5.main(Sol_Exercise13_5.java:14)
5
6
7
8
9
 */