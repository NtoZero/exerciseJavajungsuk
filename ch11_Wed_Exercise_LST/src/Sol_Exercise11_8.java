//[11-8] 문제11-7의 Student클래스에 총점(total)과 전교등수(schoolRank)를 저장하기 위한 인스턴스변수를 추가하였다.
//        Student클래스의 기본정렬을 이름(name)이 아닌 총점 (total)을 기준으로 한 내림차순으로 변경한 다음,
//        총점을 기준으로 각 학생의 전교등수를 계산하고 전교등수를 기준으로 오름차순 정렬하여 출력하시오.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student8 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;    //⭐ 총점
    int schoolRank;    //⭐ 전교등수

    Student8(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    public int compareTo(Object o) {
    /*
    (1)	알맞은 코드를 넣어 완성하시오.
    */
        //🔥 인스턴스 형변환 검사를 진행한다.
        if(o instanceof Student8) {
            Student8 stu = (Student8) o;
            //🔥 이 객체의 total값에 비교하는 stu의 total값을 뺀 다음 -1을 곱해주어야 내림차순
            return (this.total-stu.total)*(-1);
        } else {
            System.out.println("학생 객체가 아닙니다.");
            //❓❓ 얘도 -1을 곱해줘야 하는건가? 어차피 Student가 아니라 어떤값을 줘도 상관없나?
            return -1*(-1);
        }
    }

    public String toString() {
        return name
                + "," + ban
                + "," + no
                + "," + kor
                + "," + eng
                + "," + math
                + "," + getTotal()
                + "," + getAverage()
                + "," + schoolRank // 새로추가
                ;
    }
} // class Student

class Sol_Exercise11_8 {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다. (🔥 Comparable로 구현)

        int prevRank = -1;    // ⭐이전 전교등수
        int prevTotal = -1;		// ⭐이전 총점
        int length = list.size();   //⭐전교 학생 수

        /*
        (2)	아래의 로직에 맞게 코드를 작성하시오.
        1.	반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
        1.1	총점(total)이   이전총점(prevTotal)과   같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다. (🔥 이해 안됨.)
        1.2	총점이 서로 다르면,
        등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
        이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고)
        1.3	현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
        */
        Iterator it = list.iterator();
        for(int i=0; it.hasNext(); i++) {
            Object itSud = it.next();
            if(itSud instanceof  Student8) {
                Student8 s = (Student8) itSud;
                if(s.total==prevTotal) {
                    s.schoolRank = prevRank;
                } else {
                    //⭐⭐i는 계속해서 진행하고, 동점자가 아닐경우에만 학교등수를 매기므로 동점자는 자연스럽게 건너뛰게 된다.
                    s.schoolRank = i+1;
                }
                //⭐⭐ s.total로 s.schoolRank 연산이 완료되면 prevTotal, prevRank에 각각 저장하여 등수를 비교하는 기준으로 삼는다.
                prevTotal = s.total;
                prevRank = s.schoolRank;
            }
        }
//        while(it.hasNext()) {
//            Object itStud = it.next();
//            if(itStud instanceof Student8) {
//                Student8 s = (Student8) itStud;
//                if(s.total==prevTotal) {
//                    s.schoolRank = prevRank;
//                 //if(s.total !=prevTotal)
//                } else {
//                    if(s.total>prevTotal) {
//                        s.schoolRank = prevTotal-1; //단, 동점자 고려가 안됨
//                    } else if(s.total<prevTotal) {
//                        s.schoolRank = prevTotal+1; //단, 동점자 고려가 안됨
//                    }
//                }
//                prevRank = s.schoolRank;
//                prevTotal = s.total;
//            }
//        }
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student8("이자바", 2, 1, 70, 90, 70));
        list.add(new Student8("안자바", 2, 2, 60, 100, 80));
        list.add(new Student8("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student8("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student8("김자바", 1, 2, 80, 80, 90));
        calculateSchoolRank(list);
        Iterator it = list.iterator();

        while (it.hasNext()) System.out.println(it.next());
    }
}

/*
<실행결과>
홍길동,1,3,100,100,100,300,100.0,1
김자바,1,2,80,80,90,250,83.3,2
안자바,2,2,60,100,80,240,80.0,3
남궁성,1,1,90,70,80,240,80.0,3
이자바,2,1,70,90,70,230,76.7,5
 */

/*
<풀이접근>
총점을 기준으로 내림차순을 한다면,
총점끼리 비교한 값을 뺐을 때 return 값에 -1을 붙여주면된다.
<=> s1.total-s2.total에서 s1이 더 작으면 1, 같으면 0, 크면 -1을 반환하도록 해도 된다.
혹은, 총점의 순서를 s2.total-s1.total로 변경하면 된다.

단, 위의 설명은 Comparator의 구현에서 작동하는 것이었고,
⭐기본정렬은 Comparable이므로 int compareTo(Object o)를 구현해야 한다.
this.total-(비교하는 학생객체).total 값에 (-1)을 곱해서 순서를 바꿔주어야 내림차순이다.

❓ 궁금증이 생긴다. 형변환에 실패하면 내림차순일 경우 -1을 반환한다.
그렇다면 오름차순일 경우 +1을 반환해야 하는가?
애당초 Student 객체로 형변환 할 수 없는데 값을 비교해서 정렬하는게 맞나?


 */