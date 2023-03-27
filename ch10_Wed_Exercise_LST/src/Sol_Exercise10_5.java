/*
[10-5] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
메서드명 : getDayDiff
기	능 : yyyymmdd형식의 두 문자열을 넘겨받으면 두 날짜의 차이를 일(day)단위로 반환한다.
단, 첫 번째 날짜 빼기 두 번째 날짜의 결과를 반환한다.
만일 주어진 문자열이 유효하지 않으면 0을 반환한다.
반환타입 : int
매개변수 : String yyyymmdd1 - 시작날짜 String yyyymmdd2 - 끝 날짜
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Sol_Exercise10_5 {
/*
(1) getDayDiff메서드를 작성하시오.
*/
    static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = new SimpleDateFormat("yyyyMMdd").parse(yyyymmdd1);
            d2 = new SimpleDateFormat("yyyyMMdd").parse(yyyymmdd2);
        } catch (ParseException e) {
            //⭐주어진 문자열이 유효하지 않으면 0을 반환 (⭐⭐예외를 이 메서드에서 해결함)
            return 0;
        }
        // ⭐각 Date를 getTimeInMills()로 나타내서 차이를 구하기 위해 Calendar화
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        return (int)((c1.getTimeInMillis()-c2.getTimeInMillis())/(1000*60*60*24));
    }

    public static void main(String[] args){
        System.out.println(getDayDiff("20010103","20010101"));
        System.out.println(getDayDiff("20010103","20010103"));
        System.out.println(getDayDiff("20010103","200103"));
    }
}

/*
<실행결과>
2
0
0
 */

/*<모범답안>
import java.util.*;

class Exercise10_5 {
    static int getDayDiff(String yyyymmdd1, String yyyymmdd2) { int diff = 0;

        try {
            int year1 = Integer.parseInt(yyyymmdd1.substring(0,4));
            int month1 = Integer.parseInt(yyyymmdd1.substring(4,6)) - 1;
            int day1 = Integer.parseInt(yyyymmdd1.substring(6,8));

            int year2 = Integer.parseInt(yyyymmdd2.substring(0,4));
            int month2 = Integer.parseInt(yyyymmdd2.substring(4,6)) - 1;
            int day2 = Integer.parseInt(yyyymmdd2.substring(6,8));

            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();

            date1.set(year1, month1, day1);
            date2.set(year2, month2, day2);

            diff = (int)((date1.getTimeInMillis()-date2.getTimeInMillis())
                    /(24*60*60*1000));
        } catch(Exception e) {
            diff = 0; // substring(), parseInt()에서 예외가 발생하면 0을 반환한다.
        }

        return diff;
    }

    public static void main(String[] args){
        System.out.println(getDayDiff("20010103","20010101"));
        System.out.println(getDayDiff("20010103","20010103"));
        System.out.println(getDayDiff("20010103","200103"));
    }
}


*/


/*
<해설>
[해설] 넘겨받은 문자열을 substring()으로 잘라서 년, 월, 일을 각각 구한 다음,
        이 값들을 가지고 Calendar의 년월일을 설정한다.
[참고] Calendar클래스의 month값은 1이 아닌 0부터 시작하기 때문에 1을 빼주어야 한다.

        int year1 = Integer.parseInt(yyyymmdd1.substring(0,4));
        int month1 = Integer.parseInt(yyyymmdd1.substring(4,6)) - 1;
        int day1 = Integer.parseInt(yyyymmdd1.substring(6,8));

        Calendar date1 = Calendar.getInstance(); date1.set(year1, month1, day1);

        Calendar의 getTimeInMillis()는 날짜를 천분의 일초단위로 변환해서 반환한다. getTime
        Millis()를 이용해서 두 날짜를 천분의 일초로 변환해서 차이를 구한 다음에 일(day) 단 위로 변환하면 두 날짜의 날(day) 차이를 구할 수 있다.
        천분의 일초 단위를 일 단위로 바꾸려면 24*60*60*1000로 나눠주면 된다.
        (1일 = 24시간 = 24*60분 = 24*60*60초 = 24*60*60*1000밀리세컨드)

        date1.set(year1, month1, day1); date2.set(year2, month2, day2);

        diff = (int)((date1.getTimeInMillis()-date2.getTimeInMillis())
        /(24*60*60*1000));
*/

