//[9-4] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
/*
메서드명 : printGraph
기	능 : 주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력한다.
반환타입 : 없음
매개변수 : int[] dataArr - 출력할 그래프의 데이터 char ch - 그래프로 출력할 문자.
 */
class Sol_Exercise9_4 {
    static void printGraph(int[] dataArr, char ch) {
    /*
    (1) printGraph메서드를 작성하시오.
    */
        for(int i=0; i<dataArr.length; i++) {
            int curElement = dataArr[i];
            for(int j=0; j<curElement; j++) {
                System.out.print(ch);
            }
            System.out.println(String.valueOf(curElement));
        }
    }

    public static void main(String[] args) { printGraph(new int[]{3,7,1,4},'*');
    }
}

/*

<결과>
 ***3
 *******7
 *1
 ****4

 */

/*
<문제접근>
int 배열 안에 담긴 각 요소의 int값 만큼의 문자를 출력하고 해당 요소값을 String 형태로 결합한 후, \n이 반복되도록 하면 된다.
int 배열의 요소 값을 꺼내는 것은 for문의 증가하는 i에서 인트배열[i]를 사용하고,
그 숫자를 문자로 바꾸는 것은 빈 문자열로 더하는 방식 또는 String.parseString() 또는 String.valueOf()를 사용하면 될 것이다.

 */

/*
<모범답안>

class Exercise9_4 {
    static void printGraph(int[] dataArr, char ch) {
        for(int i=0; i < dataArr.length;i++) {
            for(int j=0; j < dataArr[i];j++) {
                System.out.print(ch);
            }
                System.out.println(dataArr[i]);
            }
    }

    public static void main(String[] args) { printGraph(new int[]{3,7,1,4},'*');
    }
}
 */

