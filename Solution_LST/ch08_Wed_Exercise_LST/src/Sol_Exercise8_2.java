//[8-2] 다음은 실행도중 예외가 발생하여 화면에 출력된 내용이다. 이에 대한 설명 중 옳 지 않은 것은?
//		java.lang.ArithmeticException : / by zero
//		at ExceptionEx18.method2(ExceptionEx18.java:12)
//		at ExceptionEx18.method1(ExceptionEx18.java:8)
//		at ExceptionEx18.main(ExceptionEx18.java:4)
//
//		a.	위의 내용으로 예외가 발생했을 당시 호출스택에 존재했던 메서드를 알 수 있다.
//		b.	예외가 발생한 위치는 method2 메서드이며, ExceptionEx18.java파일의 12번째 줄이다.
//		c.	발생한 예외는 ArithmeticException이며, 0으로 나누어서 예외가 발생했다.
//		d.	method2메서드가 method1메서드를 호출하였고 그 위치는 ExceptionEx18.java파일의 8번째 줄이다.

/*
<문제풀이>
a는 옳다. printStackTrace()메서드는 예외 발생 당시 호출 스택에 있던 메서드와 예외의 정보를 반환한다.
b는 옳다. 예외가 method2에서 발생하여 처리되지 못하여 method1으로 전달된다. method1도 처리X -> main도 처리X -> JVM의 기본예외처리기가 예외를 처리한다.
c는 옳다. ArithmeticException은 0으로 나누어 예외가 발생한다.
d는 옳지 앟ㄴ다. main이 method1을 호출, method1이 method2를 호출했다. method2가 호출스택의 가장 위에서 예외를 발생시켜 연쇄작용이 발생했다.

<모범>
[정답] d
[해설] 예외의 종류는 ArithmeticException이고 0으로 나눠서 발생하였다. 예외가 발생한 곳은 method2이고 ExceptionEx18.java의 12번째 줄이다.
예외가 발생했을 당시의 호출스택을 보면 아래의 그림과 같다. 호출스택은 맨 위에 있는 메서드가 현재 실행 중인 메서 드이고 아래 있는 메서드가 바로 위의 메서드를 호출한 것이다.
그래서 main → method1 → method2의 순서로 호출되었음을 알 수 있다.
괄호안의 내용은 예외가 발생한 소스와 라인인데, method1()의 경우 예외가 발생한 곳이 method2()호출한 라인이고 main의 경우 method1()을 호출한 라인이다.
method1()에서 봤을 때는 method2()를 호출한 곳에서 예외가 발생한 것이기 때문이다.
main메서드 역시 마찬가지.
 */