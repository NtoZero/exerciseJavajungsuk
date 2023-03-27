//[8-10] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.

class Sol_Exercise8_10 {
    public static void main(String[] args) {
        try {
            method1();              //throw e로 던져진 예외에는 NullPointerException이 존재한다. 바로 catch구문
            System.out.println(6);
        } catch (Exception e) {     //🔥이 부분에서 NullPointerException을 잡아 7을 실행한다.
            System.out.println(7);
        }
    }

    static void method1() throws Exception {
        try {
            method2();  //🔥NullPointerException 인스턴스 생성
            System.out.println(1);
        } catch (NullPointerException e) {  //🔥instanceof 연산자로 잡힘
            System.out.println(2);  //🔥 2 출력
            throw e;    //🔥 예외 되던지기 method1()을 호출한 main단으로 던져진다.
        } catch (Exception e) {
            System.out.println(3);
        } finally {
            System.out.println(4);  //🔥finally는 무조건 실행되므로 4 출력
        }

        System.out.println(5);  //🔥 예외되던지기로 예외가 처리되지 않은 상태이므로 실행x
    } // method1()

    static void method2() {
        throw new NullPointerException();
    }   //🔥NullPointerException 생성
}

/*
<내 풀이>
main 메서드가 method1()을 호출하고 method1()이 method2()를 호출한다.
method2()는 NullPointerException 인스턴스를 생성하는데 예외처리 되어 있지 않으므로 종료될 때 method1으로 예외를 넘긴다.
method1()은 method2()를 실행할 때 해당 예외 객체를 생성하고 이에 따른 catch 블럭으로 이동한다. 2를 출력한다.
main단으로 다시 예외를 던진다. (throw e)
finally는 무조건 실시되어야 하므로 4가 출력된다.
(throw e)로 예외가 되던져진 상황이므로 여전히 예외처리가 안된 상황이라 5는 출력되지 않는다.
main단으로 throw e로 던져진 예외에는 NullPointerException 인스턴스가 존재한다.
바로 catch구문으로 가서 7을 출력한다.
2
4
7

<해설>
method2()에서 발생한 예외를 method1()의 try-catch문에서 처리했다가 다시 발생 시킨다.
예외가 발생한 catch블럭 내에 이 예외(NullPointerException)를 처리할 try-catch블럭이 없기 때문에 method1()이 종료되면서 main메서드에 예외가 전달된다.
이 때 예외가 처리 되진 않았지만, finally블럭의 문장이 수행되어 4가 출력된다.
main메서드의 try-catch블럭은 method1()으로부터 전달된 예외를 처리할 catch블럭이 있
으므로 해당 catch블럭이 수행되어 7을 출력하고 try-catch블럭을 벗어난다.
그리고 더 이상 수행할 코드가 없으므로 프로그램이 종료된다.

 */

