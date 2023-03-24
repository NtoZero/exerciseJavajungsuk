//[9-8] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
//        메서드명 : round
//        기	능 : 주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환한다.
//        예를 들어 n의 값이 3이면, 소수점 4째 자리에서 반올림하여 소수점 이하 3자리의 수를 반환한다.
//        반환타입 : double
//        매개변수 : double d , 변환할 값 int n - 반올림한 결과의 소수점 자리
//  [Hint] Math.round()와 Math.pow()를 이용하라.

class Exercise9_8 {
    /*
    (1) round메서드를 작성하시오.
    */


    public static void main(String[] args) {
        System.out.println(round(3.1415,1));
        System.out.println(round(3.1415,2));
        System.out.println(round(3.1415,3));
        System.out.println(round(3.1415,4));
        System.out.println(round(3.1415,5));
    }
}

/*
<실행결과>
3.1
3.14
3.142
3.1415
3.1415
 */

