/*
[9-12] 다음과 같이 작성된 메서드를 작성하고 테스트하시오.
[주의] Math.random()을 사용하는 경우 실행결과와 다를 수 있음.

메서드명 : getRand
기	능 : 주어진 범위(from~to)에 속한 임의의 정수값을 반환한다. (양쪽 경계값 모두 범위에 포함)
from의 값이 to의 값보다 클 경우도 처리되어야 한다.
반환타입 : int
매개변수 : int from - 범위의 시작값, int to - 범위의 끝값

[Hint] Math.random()과 절대값을 반환하는 Math.abs(int a),
그리고 둘 중에 작은 값을 반환하는 Math.min(int a, int b)를 사용하라.

 */

class Sol_Exercise9_12 {
    /*
    (1) getRand메서드를 작성하시오.
    */
    static int getRand(int from, int to) {
        if(from>to) {   //from이 to보다 클 경우 두 변수의 값 바꾸기
            int tmp = from;
            from = to;
            to = tmp;
        }
        int result = (int)(Math.random()*(to-from+1))+from;
        return result;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++)
            System.out.print(getRand(1, -3) + ",");
    }
}

/*
<실행결과>
0,-1,1,0,-2,-2,1,1,-3,0,-1,1,1,1,0,-1,1,0,-1,-3,
 */

/*
🔥풀이 접근
0<=x<1을 조작해 from<=x<to로 만들고 싶다면
양변에 (to-from)을 곱한 다음 + from 해주면 된다.
그리고 from<=x<=to로 끝 숫자 to까지 포함하고 싶으면
양변에 (to-from+1)을 곱한 다음 + from 해주면 된다.

원리는 다음과 같다.
최우변이 1이므로 to-from을 곱해주는 것은, 최우변을 to-from으로 만들어주는 것과 같다. (이 때, 최좌변은 0이다.)
최우변이 to-from일 때 다시 from을 더해주면 최우변은 to가 된다.
이 때, 최좌변은 from이 더해진 값이다.

 */

/*
<모범 풀이>
class Exercise9_12
{
    public static int getRand(int from, int to) {
        return (int)(Math.random() * (Math.abs(to-from)+1))+ Math.min(from,to);
    }

    public static void main(String[] args)
    {
        for(int i=0; i< 20; i++) System.out.print(getRand(1,-3)+",");
    }
}
<내 답과 다른점>
1. 조건문을 사용하지 않았다. (from, to의 대소비교 후 바꿔주는 조건문x)
2. 대신, Math.abs(to-from+1)을 곱해주고, Math.min(from, to)를 더해줬다. 이렇게 하면 조건문을 사용하지 않아도 대소비교에 따라서 적절한 값을 곱하고 더할 수 있다.
*/
