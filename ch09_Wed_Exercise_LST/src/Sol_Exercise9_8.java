//[9-8] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
//        메서드명 : round
//        기	능 : 주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환한다.
//        예를 들어 n의 값이 3이면, 소수점 4째 자리에서 반올림하여 소수점 이하 3자리의 수를 반환한다.
//        반환타입 : double
//        매개변수 : double d , 변환할 값  int n - 반올림한 결과의 소수점 자리
//[Hint] Math.round()와 Math.pow()를 이용하라.

class Sol_Exercise9_8 {
    /*
    (1) round메서드를 작성하시오.
    */
    static double round(double d, int n) {
        double numDigits = Math.pow(10, n);
        double result = Math.round(d*numDigits)/numDigits;  //🔥d*해당자리수하여 반올림 한뒤 다시 해당자리수로 나눠준다.
        return result;
    }

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


/*
<🔥풀이접근>
Math 클래스의 round 메소드를 이용하여 적절한 반환값을 만드는 메서드이다.
소수점 이하 n자리 값까지 반환하는 메서드를 만들기 위해서는
round()가 소수점 첫째자리에서 반올림하여 double 타입으로 반환하는 성질을 이용하여
곱하기10^n과 나누기(10^n)을 잘 활용할 필요가 있다.
🔥단 나눌 때는 double이나 float 등의 실수형으로 나누어야 double형에 저장되었을 때 그 소수점까지 확인할 수 있다.
🔥클린 코드를 위해서 10^n을 일정한 변수 NumDigits로 저장하자.
n제곱은 Math.pow(10, n)을 사용한다.


 */

/*
<모범풀이>
class Exercise9_8 {
    public static double round(double d, int n) {
        return Math.round(d * Math.pow(10, n)) / Math.pow(10,n); //🔥
    }

    public static void main(String[] args) {
        System.out.println(round(3.1415,1));
        System.out.println(round(3.1415,2));
        System.out.println(round(3.1415,3));
        System.out.println(round(3.1415,4));
        System.out.println(round(3.1415,5));
    }
}

<🔥차이점>
Math.pow를 별도의 자리수 변수에 저장하지 않았다.
 */
