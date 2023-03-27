
//[8-5] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.
class Sol_Exercise8_5 {
    static void method(boolean b) {
        try {
            System.out.println(1);
            if (b)
                throw new ArithmeticException();
            System.out.println(2);
        } catch (RuntimeException r) {
            System.out.println(3);
            return; //❓ 메서드를 빠져나간다.(finally블럭을 수행한 후에)
        } catch (Exception e) {
            System.out.println(4);
            return;
        } finally {
            System.out.println(5);
        }

        System.out.println(6);
    }

    public static void main(String[] args) {
        method(true);
        method(false);
    } // main
}

/*
<내 풀이>
try-catch-finally 구문의 흐름은 이렇다.
try{}블럭 내에 예외가 발생할 경우와 예외가 발생하지 않을 경우로 나뉠 수 있다.

예외가 발생할 경우에는 해당 try{}블럭의 코드까지 실행하고 예외 인스턴스를 생성하여 바로 catch 단으로 넘긴다.
catch단을 차례로 넘어가며 instanceof 검사를 해 형변환이 가능한 매개변수타입을 만날 때 까지 검사한다.
해당 매개변수에 대입(동캐스팅 또는 업캐스팅)하여 catch{}블럭을 실행하고 다음 catch블럭은 실행하지 않고
finally가 존재하면 해당 블럭을 무조건 실행하지만, 없다면 다음 코드를 실행한다.

try{}블럭 내에 예외가 발생하지 않은 경우에는 try{}블럭을 모두 실행하고 바로 finally 블럭으로 넘어가서 코드를 실행한다.
실행 결과는 1, 3, 5, 6이다.
1은 오류없으므로 실행, 2는 ArithmeticException이 객체 생성되어 내던져진 이후이므로 실행되지 않는다.
3은 실행되는데 RuntimeException이 ArithmeticException의 부모 클래스이기 때문이다.
다음 catch는 실행되지 않으므로 4는 실행되지않는다.
finally는 무조건 실행되는 구문이므로 5를 출력한다.
이후 try-catch-finally 전체를 빠져나간다음 6을 출력한다.
 */

/*
<정답>
1
3
5
1
2
5
6

<모범>
[해설] ❓❓❓⭐⭐⭐ 예외가 발생하면 1,3,5가 출력되고 예외가 발생하지 않으면, 1,2,5,6이 출력된다.
ArithmeticException은 RuntimeException의 자손이므로 RuntimeException이 정의된 catch블럭에서 처리된다.
이 catch블럭에 return문이 있으므로 메서드를 종료하고 빠져나가게 되는데, 이 때도 finally블럭이 수행된다.

*/

/*
반성할점 :
코드를 잘 살피지 못했다. Boolean b의 존재를 놓쳤다.
또한 main단을 잘 살피지 못했다.
 */