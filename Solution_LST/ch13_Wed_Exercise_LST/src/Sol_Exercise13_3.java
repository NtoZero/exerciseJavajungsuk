//[13-3] 다음 중 쓰레드를 일시정지 상태(WAITING)로 만드는 것이 아닌 것은? (모두 고르 시오)

//        a.	suspend()
//        b.	resume()
//        c.	join()
//        d.	sleep()
//        e.	wait()
//        f.	notify()

/*
<풀이 접근>
a. suspend()는 WAITING 상태로 만든다.
✔️b. resume()은 suspend()에 대응하여 WAITING 상태에서 깨운다.
c. join()은 다른 쓰레드가 작업을 마칠 때까지 쓰레드를 WAITING 상태로 만든다.
d. sleep()은 스태틱 메서드로 현재 쓰레드를 WAITING 상태로 만든다.
e. wait()은 실행 중이던 쓰레드를 해당 객체의 WAITING POOL에서 기다리게 한다.
✔️f. notify()는 해당 객체의 WAITING POOL에서 임의의 쓰레드를 깨운다.
 */

/*
<정답>
[정답] b, f
[해설] resume()은 suspend()의 호출로 인해 일시정지 상태가 된 쓰레드를 실행대기상태로 바꿔준다.
notify()역시 wait()의 호출로 인해 일시정지 상태가 된 쓰레드를 다시 실행대기 상태로 바꿔준다.
join()은 현재 실행 중인 쓰레드를 멈추고 다른 쓰레드가 실행 되도록 한다.
 */