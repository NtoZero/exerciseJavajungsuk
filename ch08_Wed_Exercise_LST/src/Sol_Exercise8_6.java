//[8-6] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.
class Sol_Exercise8_6 {
    public static void main(String[] args) {
        try {
            method1();              //🔥예외가 발생할 가능성이 있는 메소드
        } catch (Exception e) {
            System.out.println(5);  //🔥모든 예외는 Exception에서 무조건 잡힌다.
        }
    }

    static void method1() {
        try {
            method2();          //🔥method2는 NullPointerException 인스턴스 생성하고 발생시킴
            System.out.println(1);  //동작X
        } catch (ArithmeticException e) {   //NullPointerException이 아니기 때문에 타입매치x
            System.out.println(2);
        } finally { //🔥무조건 실행
            System.out.println(3);
        }

        System.out.println(4);  //🔥✔️✔️try-catch-finally 이후이므로 실행❓
    } // method1()

    static void method2() {
        throw new NullPointerException();
    }
}

/*
<내 풀이>
main 메서드가 method1을 호출하고 method1이 method2를 호출한다.
동작은 method2 -> method1 -> main 의 세부내용들이 실행될 것이다.
3, 4, 5가 실행된다.

<틀린 풀이>
✔️ 4는 실행되지 않는다.
⭐왜냐하면 method2는 throws가 아닌 throw를 사용해서 예외를 발생시켰기 때문에 try-catch도 없어 비정상 종료된다.
⭐그런데 method1에서도 NullPointerException에 대한 예외처리가 되어있지 않다. 비정상 종료된다.
  다만, 그 시점이 중요한데, try의 method2에서 인스턴스 발생 후 try{}블럭은 건너뛰어 catch를 점검한다.
  ⭐⭐catch에는 NullPointerException를 잡을 것이 없으므로 finally (println(3))를 실행하고 🔥비정상 종료🔥된다.
⭐main에서는 모든 예외를 잡을 수 있는 Exception이 있으므로 5가 실행된다.

<틀린 이유>
예외 발생(throw)과 예외 처리(throws)에 대한 착오가 있었다.
또한 예외처리를 하지 못하면 비정상 종료된다는 것과, 그 종료되는 시점에 대해 명확히 인지하지 못했다.

<모범>
<정답>
3
5
<해설>
main메서드가 method1()을 호출하고, method1()은 method2()를 호출한다.
method2()에서 NullPointerException이 발생했는데, 이 예외를 처리해줄 try-catch블럭이 없으므로
method2()는 종료되고,
이를 호출한 method1()으로 되돌아갔는데 ⭐여기에는 try-catch블럭이 있긴 하지만
NullPointerException을 처리해줄 catch블럭이 없으므로
method1()도 종료⭐되고, 이를 호출한 main메서드로 돌아간다. 이 때 finally블럭이 수행되어 '3'이 출력된다.

 */
