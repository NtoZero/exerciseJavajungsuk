//[13-7] 다음의 코드는 쓰레드 th1을 생성해서 실행시킨 다음 6초 후에 정지시키는 코드이다.
//      그러나 실제로 실행시켜보면 쓰레드를 정지시킨 다음에도 몇 초가 지난 후에서야 멈춘다.
//      그 이유를 설명하고, 쓰레드를 정지시키면 지체없이 바로 정지되도록 코드를 개선하시오.

class Exercise13_7 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread5 th1 = new Thread5();
        th1.start();

        try {
            Thread.sleep(6 * 1000);
        } catch (Exception e) {
        }

        stopped = true; // 쓰레드를 정지시킨다.
        System.out.println("stopped");
    }
}

class Thread5 extends Thread {
    public void run() {
// Exercise13_7.stopped의 값이 false인 동안 반복한다.
        for (int i = 0; !Exercise13_7.stopped; i++) {
            System.out.println(i);

            try {
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
            }
        }
    } // run()
}


/*
<실행결과>
0
1
2
stopped
 */