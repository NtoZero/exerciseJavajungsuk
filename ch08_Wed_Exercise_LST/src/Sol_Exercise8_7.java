//[8-7] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.
class Sol_Exercise8_7 {
    static void method(boolean b) {
        try {
            System.out.println(1);  //🔥💧 예외 없음. 실행
            if (b)
                System.exit(0); //🔥 true일 경우 System.exit 예외 발생. RuntimeException인지 Exception인지 알 수 없다.
            System.out.println(2);  //💧 false일 때 2가 실행 예외가 발생하지 않으니 catch를 건너뛰고 finally 실행
        } catch (RuntimeException r) {
            System.out.println(3);  //🔥 true
            return;     // ❓return문이 있어도 finally는 동작? 그럴 것이다. 그러나 try-catch-finally 부분을 실행하고 return될 것.
        } catch (Exception e) {
            System.out.println(4);
            return;
        } finally {     //🔥💧true, false이든 무조건 실행
            System.out.println(5);
        }

        System.out.println(6);  //💡try~catch 블럭 안에서 return이 나오면 여기까지는 도달하지 x
                                //💧catch안의 return이 동작하지 않고 정상 순서로 프로그램이 진행되니 자동 실행
    }

    public static void main(String[] args) {
        method(true);
        method(false);
    } // main
}

/*
<내 풀이>
main 단에서 method(true);와 method(false);를 각각 실행했을 때의 결과를 묻고 있다.
🔥method(true)일 때는 1, 3, 5가 실행된다.
💧method(false)일 때는 1, 2, 5, 6이 실행된다.
<내 정답>
1
3
5
1
2
5
6

<모범>
<정답> 1
<해설>
변수 b의 값이 true이므로 System.exit(0);이 수행되어 프로그램이 즉시 종료된다.
이럴 때는 finally 블럭이 수행되지 않는다.

<틀린이유>
💡System.exit(0)은 프로그램 자체를 종료하는 메서드이다.
<궁금점>
❓❓그렇다고 하더라도 method(false)는 실행되어야 하는게 아닌가?
💡 System.exit(0)은 JVM을 강제로 종료시키는 역할을 합니다. 0은 정상적인 종료임을 나타내는 종료 코드입니다.
따라서 해당 코드가 실행되면, 현재 실행 중인 Java 프로그램이 즉시 종료됩니다.
method(true)에서 System.exit(0)이 실행되어 JVM이 강제 종료되면서 프로그램이 바로 종료됩니다.
따라서 method(false)는 실행되지 않습니다.

💡💡 차이점을 알 수 있다. 단순 예외가 발생한 것이었다면 프로그램이 비정상 종료되지 않았을 것이다.
그러나 System.exit(0)은 JVM 자체를 종료시키는 것이기 때문에
 */