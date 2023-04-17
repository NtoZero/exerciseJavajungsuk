//[13-7] 다음의 코드는 쓰레드 th1을 생성해서 실행시킨 다음 6초 후에 정지시키는 코드이다.
//      그러나 실제로 실행시켜보면 쓰레드를 정지시킨 다음에도 몇 초가 지난 후에서야 멈춘다.
//      그 이유를 설명하고, 쓰레드를 정지시키면 지체없이 바로 정지되도록 코드를 개선하시오.

class Exercise13_7 {
    //⭐ 인스턴스 변수 stopped를 false로 둔다.
    static boolean stopped = false;

    public static void main(String[] args) {
        //⭐Thread5에 대한 쓰레드 생성후 start()
        Thread5 th1 = new Thread5();
        th1.start();

        //⭐6초를 기다림
        try {
            Thread.sleep(6 * 1000);
        } catch (Exception e) {
        }

        stopped = true; // 쓰레드를 정지시킨다.
        System.out.println("stopped");
    }
}

//⭐Thread5에 대한 run()에서는
class Thread5 extends Thread {
    public void run() {
//⭐ Exercise13_7.stopped의 값이 false인 동안 반복한다. (3초마다 0, 1, 2, ... 출력)
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

/*
<풀이접근❌>
main 쓰레드에서
try {
            Thread.sleep(6 * 1000);
        } catch (Exception e) {
        }

        stopped = true; // 쓰레드를 정지시킨다.
를 했음에도 불구하고 몇 초 뒤에야 th1 쓰레드가 멈추는 이유는
➡️ 6초 뒤에 인스턴스 변수 stopped를 true로 변경했음에도 불구하고,
그 직전에 Thread5의 run()에서 for문 조건 !Exercise13_7.stopped;를 체크했기 때문에,
Thread.sleep(3 * 1000); (3초 텀이 적용되고 나서야 멈추게 되는 것이다.) ❌
(물론 OS 스케쥴러에 따라 아래와 같이 바로 멈출수도 있다.)
<⬇️OS 스케줄러의 컨디션에 따라 main 쓰레드가 먼저 실행되었을 경우 실행결과>
0
1
stopped

⭐OS 컨트롤러의 스케줄을 직접 조정하는 것은 매우 큰 부담이기 때문에 적절한 답이 아니다.
❓어떻게 해결해야 할까?

 */

/*
- 모범 해설:
[정답] **`Exercise13_7.stopped`의 값이 바뀌어도 for문내의
`Thread.sleep(3*1000);`문장에 의해 일시정지 상태에 있는 경우**, <u>시간이 지나서 일시정지 상태를 벗어날 때까지 for문을 벗어날 수 없기 때문에 이런 현상이 발생</u>한다. 그래서 **interrupt()를 호출해서 자고 있는 (sleep()에 의해 일시정지 상태에 있는) 쓰레드를 깨워야 즉시 정지**하게 된다.<br/>
[해설] 쓰레드 `th1`은 아래의 반복문을 수행하다가 main메서드에서
`Exercise13_7.stopped`의 값을 true로 바꾸면 반복문을 빠져나와 수행을 종료하게 된다. ⭐**반복문 안에 쓰레드를 3초 동안 일시정지 상태로 하는 `‘Thread.sleep(3*1000)’`이 있기 때문에 `Exercise13_7.stopped`의 값이 바뀌었다 하더라도 일시정지 상태에 있다면, 일시정지 상태가 끝나야만 반복문을 빠져나오게 된다.**

```java
  public void run(){
      // Exercise13_7.stopped의 값이 false인 동안 반복한다.
      for(int i=0; ⭐!Exercise13_7.stopped; i++) {
          System.out.println(i);

              try{
                  Thread.sleep(3*1000); // ⭐3초간 쉰다.
              }catch(Exception e){}
          }
      } // run()

```
- **그래서 쓰레드의 실행을 바로 종료시키려면** `Exercise13_7.stopped`의 값을 `true`로 바꾸는 것만으로는 부족하다. 그 외에 다른 방법이 더 필요하다. 그것은 바로 **`interrupt()`를 호출**하는 것이다.
![](https://velog.velcdn.com/images/9to0/post/789f0a38-62c5-48df-9b00-27d9a8595305/image.png)`interrupt()`는 InterruptedException을 발생시킴으로써 `Thread.sleep()`에 의해 일시정지 상태에 있던 쓰레드를 즉시 깨운다. 그래서 ⭐**`Exercise13_7.stopped`의 값을 `true`로 바꾸고, `interrupt()`를 호출하면 지연 없이 즉시 쓰레드를 멈추게 할 수 있다.**
 */