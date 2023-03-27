//[10-3] 문자열 “123,456,789.5”를 소수점 첫 번째 자리에서 반올림하고, 그 값을 만 단위마다 콤마(,)로 구분해서 출력하시오.

/*
<실행결과>
data:123,456,789.5
반올림:123456790
만단위:1,2345,6790
 */

import java.text.DecimalFormat;
import java.text.ParseException;

class Sol_Exercise10_3 {
    public static void main(String[] args) throws ParseException {
        String data = "123,456,789.5"; //data :123,456,789.5
        System.out.println("data :" + data);
        DecimalFormat df1 = new DecimalFormat("###,###.#");
        Number d = df1.parse(data); //⭐data의 형식문자열을 Number d로 내장된 패턴에 의거해 parse
        System.out.println("d :"+ d); //⭐d :1.234567895E8   //❓ parse 되었을 때 자동으로 지수표현이 붙는건가? ⭐Number클래스에는 지수부가 붙는구나!
        System.out.println("다시 data :"+new DecimalFormat("###,###.#").format(d));

        DecimalFormat df2= new DecimalFormat("#########");  //⭐숫자가 잘리면 자동으로 반올림된다.
        System.out.println("반올림:"+df2.format(d));

        //⭐⭐ 객체를 참조변수에 담지 않고 바로 패턴생성후 포맷화. (일회성이므로)
        System.out.println("만단위:"+ new DecimalFormat("#,####").format(d));

    }
}

/*
<문제 접근>
해당 문제는 숫자형식화 클래스 DecimalFormat에 대한 문제이다. DecimalFormat의 객체를 생성할 때 생성자에 패턴을 입력해서 초기화하면,
DF객체.format(숫자)로 형식 문자열을 반환받을 수 있으며,
반대로 DF객체.parse(형식 문자열)로 숫자(Number클래스)를 반환받을 수 있다.
문자열을 다른 형식문자열로 변환하기 위해서는 형식 문자열 -> 숫자 -> 형식문자열의 과정을 거쳐야 한다.
 */

/*
<모범풀이>
import java.text.*;

class Exercise10_3
{
    public static void main(String[] args)
    {
        String data = "123,456,789.5";

        DecimalFormat df = new DecimalFormat("#,###.##"); // 변환할 문자열의 형식을 지정
        DecimalFormat df2 = new DecimalFormat("#,####");

        try {
            Number num = df.parse(data);

            double d = num.doubleValue(); //⭐
            System.out.println("data:"+data);
             System.out.println("반올림:"+Math.round(d));
             System.out.println("만단위:"+df2.format(d));
        } catch(Exception e) {}
    } // main
}

 */
