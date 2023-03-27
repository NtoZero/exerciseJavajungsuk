//[10-4] 화면으로부터 날짜를 “2007/05/11”의 형태로 입력받아서 무슨 요일인지 출력하는 프로그램을 작성하시오.
//단, 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다.

/*
<실행결과>
날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)
>>2009-12-12
날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)
>>2009/12/12
입력하신 날짜는 토요일입니다.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Sol_Exercise10_4 {
    static Scanner sc = new Scanner(System.in);

    static void dataProces() throws ParseException { //⭐ ParseException을 메인으로 넘겨줘서 처리하게 하는 이유? 잘못된 값을 입력받으면 다시 받을 수 있도록!
        System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2007/05/11)");
        String input = sc.nextLine();
        //⭐ 일회용 객체를 생성하여 parse로 바로 Date화 함.
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(input);    //⭐ParseException 발생가능
        //⭐ Date 클래스 기능을 다시 형식화 하려면 SimpleDateFormat 객체가 필요하다.
        DateFormat df = new SimpleDateFormat("입력하신 날짜는 E요일 입니다.");
        System.out.println(df.format(date));
    }

    public static void main(String[] args) {

        while(true) {
            try {
                dataProces();
                break;//⭐ 출력이 정상적으로 완료되면 메서드를 끝내야 한다.
            } catch (ParseException e) {
                continue;
            }
        }

    }
}

/*
"2007/05/11"은 형식화 문자열이라고 볼 수 있다.
Date 날짜 형태로 다시 되돌리려면 SimpleDateFormat객체.parse(String 형식화문자열)을 사용해야 한다.
입력된 날짜의 형식이 잘못된 경우 메시지를 보여주고 다시 입력받아야 하는데,
parse 같은 경우에는 내부 형식이 잘못된 경우 ParseException 예외 객체를 호출하므로,
반복문 안에서 해당 메서드를 사용하고 catch(ParseException) { }에서 다시 입력받으면 된다.
Date 객체를 다시 형식화 할때는 new SimpleDateFormat(패턴).format(Date d)를 활용하면 된다.
 */

/*
<해설>
import java.util.*; import java.text.*;

class Exercise10_4 {
    public static void main(String[] args) { String pattern = "yyyy/MM/dd";
        String pattern2 = "입력하신 날짜는 E요일입니다."; // 'E'는 일~토 중의 하나가 된다.

        DateFormat df = new SimpleDateFormat(pattern); DateFormat df2 = new SimpleDateFormat(pattern2);

        Scanner s = new Scanner(System.in); Date inDate = null;

        do {


            System.out.println("날짜를 " + pattern
                    + "의 형태로 입력해주세요.(입력예:2007/05/11)");


            try {
                System.out.print(">>");
                inDate = df.parse(s.nextLine()); // 입력받은 날짜를 Date로 변환한다.
                break; // parse()에서 예외가 발생하면  이 문장은 수행되지  않는다.
            } catch(Exception e) {}
        } while(true);

        System.out.println(df2.format(inDate));
    } // main
}
[해설] SimpleDateFormat은 날짜를 지정된 형식으로 출력하거나 문자열을 지정된 형식으
        로 변환 또는 유효성 검사에 사용할 수 있다. 이 문제에서는 입력된 날짜가 지정된 형식 에 맞는지 검사하고, 변환하는 역할을 한다.
        Scanner를 이용해서 화면으로 부터 날짜를 입력받고, 형식과 다르면 parse()에서 ParseException이 발생한다.


do {
        System.out.println("날짜를 " + pattern
        + "의 형태로 입력해주세요.(입력예:2007/05/11)");
        try {
        System.out.print(">>");
        inDate = df.parse(s.nextLine()); // ParseException이 발생할 수 있다.
        break; // parse()에서 예외가 발생하면 이 문장은 수행되지 않는다.
        } catch(Exception e) {}
        } while(true);

parse()에서 예외가 발생하면 break문이 수행되지 않기 때문에 예외가 발생하지 않을 때 까지, 즉 지정된 형식에 맞게 날짜가 입력될 때까지 반복하게 된다.*/
