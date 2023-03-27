//[10-6] 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.

/*
<실행결과>
birth day=2000-01-01
today	=2016-01-29
5872 days

 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Sol_Exercise10_6 {
    public static void main(String[] args) throws ParseException {
        String birth = "2000-01-01";
        String today = "2016-01-29";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateBirth = df.parse(birth);
        Date dateToday = df.parse(today);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(dateBirth);
        c2.setTime(dateToday);

        //⭐ 며칠이 지났는지는 getTimeInMills()의 차이를 통해 구할 수 있다.
        long diff = ((c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*60*60*24));  // 1995-10-27 ⭐ms는 초,분,시,일로 반드시 나누어 떨어짐.

        System.out.println(
                "birthday="+birth+"\n"+
                "today="+today+"\n"+
                diff+"days");
    }
}

/*
<모범풀이>
💡java.time 패키지의 LocalDate 이용하기
import java.time.*;
        import java.time.temporal.*;

class Exercise10_6 {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(2000, 1, 1); // 자신의 생일을 지정
        LocalDate now	= LocalDate.now();

        long days = birthDay.until(now, ChronoUnit.DAYS);

        System.out.println("birth day="+birthDay); System.out.println("today	="+now); System.out.println(days +" days");
    }
}
 */


/*
<문제 접근>

 */
