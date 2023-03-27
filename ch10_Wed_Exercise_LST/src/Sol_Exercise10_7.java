// [10-7] 2016년 12월 네번째 화요일의 날짜를 아래의 실행결과와 같은 형식으로 출력하시오.

/*
<실행결과>
2016-12-27
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Sol_Exercise10_7 {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        c1.set(2016, 11, 1);    //⭐⭐ Month는 항상 -1을 붙여야 한다는 사실을 잊지말자!
        while (true) {
            if(c1.get(Calendar.DAY_OF_WEEK)==3) {   //첫 번째 화요일
                c1.add(Calendar.DAY_OF_MONTH, 21);  //3주 뒤 (4번째 화요일 날짜)
                String result = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTimeInMillis());
                System.out.println(result);
                break;
            }
            c1.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}

/*
<풀이 접근>
1. 2016년 1월 1일로 Calendar객체 set.
2. DAY_OF_WEEK가 3(화)이 나오는 순간을 날짜를 하나씩 add해가며 찾는다.
3. 해당 날짜 + 21일이 3주 뒤의 네 번째 화요일이므로 add(일, 21)을 한다.
4. DateFormat으로 "2016-12-27" 패턴을 통해 format(d)한다.

 */

/*
<정답 풀이>
💡[정답] ?째주 ?요일은 TemporalAdjusters클래스의 dayOfWeekInMonth()를 이용하면 된다.
import java.time.*;
        import static java.time.DayOfWeek.*;
        import static java.time.temporal.TemporalAdjusters.*;

class Exercise10_7 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 12, 1);
        System.out.println(date.with(dayOfWeekInMonth(4, TUESDAY)));
    }
}
 */

