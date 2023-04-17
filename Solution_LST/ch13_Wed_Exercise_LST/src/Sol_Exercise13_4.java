//[13-4] 다음 중 (모두 고르시오)
//        interrupt()에 의해서 실행대기 상태(RUNNABLE)가 되지 않는 경우는?

       /* a.	sleep()에 의해서 일시정지 상태인 쓰레드
        b.	join()에 의해서 일시정지 상태인 쓰레드
        c.	wait()에 의해서 일시정지 상태인 쓰레드
        d.	suspend()에 의해서 일시정지 상태인 쓰레드*/

/*
<풀이 접근>
sleep(), join(), suspend()는 모두 InterruptedException 을 던지는 예외로,
interrupt()를 통해 WAITING 상태에서 벗어나게 된다.

그러나 `wait()`은 InterruptedException를 던지는 예외가 아니므로,
interrupt()로 인해서 WAITING POOL에서 깨어나지 않는다.
wait()을 깨우는 방법으로 notify()와 notifyAll()이 존재한다.❌❌❌
 */

/*
💡 **오답 개념 정리**:
`suspend()`를 제외한 나머지 메서드들은
`interrupt()`가 호출되면 `interruptedException`이 발생하여 일시정지 상태에서 벗어나 실행대기 상태가된다.
(try-catch문으로 InterruptedException을 처리해주어야 한다.)
 */