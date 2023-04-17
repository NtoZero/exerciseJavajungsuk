//[13-6] 다음의 코드를 실행한 결과를 예측하고, 직접 실행한 결과와 비교하라.
// 만일 예측한 결과와 실행한 결과의 차이가 있다면 그 이유를 설명하라.

class Exercise13_6 {
    public static void main(String[] args) throws Exception {
        Thread4 th1 = new Thread4();
        th1.setDaemon(true);
        th1.start();

        try {
            th1.sleep(5 * 1000);
        } catch (Exception e) {
        }

        throw new Exception("꽝~!!!");
    }
}

class Thread4 extends Thread {
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
<풀이 접근>
Thread4의 run()은 0에서 9까지의 숫자를 매 초마다 출력하는 메서드이다.
Thread4 th1 = new Thread4();로 쓰레드를 생성했고,
th1.setDaemon(true);로 이 쓰레드를 데몬 쓰레드로 만들었다.

⭐Daemon 쓰레드는 다른 쓰레드에 대한 보조 쓰레드이므로,
여기서는 main 쓰레드에 대한 보조 쓰레드가 된다.
Daemon 쓰레드는 main 쓰레드의 실행이 종료되면 동작을 멈춘다.
따라서 main 쓰레드에 예외가 발생하면 Daemon도 동작을 멈춘다.

 */

/*
[해설] 문제13-6에 `th1.setDaemon(true);` 한 문장을 추가해서 쓰레드 th1을 데몬 쓰레드로(daemon thread) 설정하였다.
데몬 쓰레드는 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)가 모두 종료되면 자동 종료되므로, main쓰레드(일반쓰레드)가 종료됨과 동시에 자동 종료된다.
그래서 문제13-6과는 달리 쓰레드th1이 main메서드의 종료와 동시에 종료되었다.
 */