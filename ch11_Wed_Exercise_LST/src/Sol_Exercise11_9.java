//[11-9] 문제11-8의 Student클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수를 추가하였다.
//        반등수를 계산하고 반과 반등수로 오름차순 정렬하여 결과를 출력하시오.
//        (1)~(2)에 알맞은 코드를 넣어 완성하시오.

import java.util.*;

class Student9 implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;


    int total;
    int schoolRank; // 전교등수

    int classRank; //⭐ 반등수

    Student9(String name, int ban, int no, int kor, int eng, int math) {
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

    //⭐ 기본정렬 방식은 '총점수'의 '내림차순'이다.
    public int compareTo(Object o) {
        if (o instanceof Student9) {
            Student9 tmp = (Student9) o;

            return tmp.total - this.total;
        } else {
            return -1;
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
                + "," + schoolRank

                + "," + classRank       //⭐ 마지막에 출력되는 것이 반 등수이다.
                ;
    }

// 새로추가

} // class Student

class ClassTotalComparator implements Comparator {
    //🔥🔥 실행 결과를 보니 반이 같으면 학급 석차로 오름차순, 반이 다르면 반으로 오름차순을 구성해야하는 문제이다.
    public int compare(Object o1, Object o2) {
    /*
    (1)	알맞은 코드를 넣어 완성하시오.
    */
        if(o1 instanceof Student9 && o2 instanceof Student9) {
            Student9 s1 = (Student9) o1;
            Student9 s2 = (Student9) o2;

            //🔥반이 다르면 반으로 오름차순
          if(s1.ban!=s2.ban)
                return s1.ban-s2.ban;
            //🔥반이 같으면 학급 석차로 오름차순 ❌❌ 아직 학급 석차 정해지기 전인데? total로 내림차순해야지
            else {
                //return s1.classRank-s2.classRank;
              return s2.total-s1.total;
            }
        } else
            return -1; //🔥 형변환이 실패했으면 Student9 객체가 아니라는 의미이므로, 우측으로 밀어버리자.
    }
}

class Sol_Exercise11_9 {
    public static void calculateClassRank(List list) {
        //⭐ 먼저 반별 총점기준 내림차순으로 정렬한다.
        //🔥 반 번호로 오름차순 이후 반이 같으면 반 석차로 오름차순
        Collections.sort(list, new ClassTotalComparator()); //🔥비교자도 객체를 사용해야함.
        /*Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());*/

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        /*
        (2)	아래의 로직에 맞게 코드를 작성하시오.
        1.	반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
        1.1	반이 달라지면,(ban과 prevBan이 다르면)
        이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다.
        1.2	총점(total)이 이전총점(prevTotal)과 같으면
        이전 등수(prevRank)를 등수(classRank)로 한다.
        1.3	총점이 서로 다르면,
        등수(classRank)의 값을 알맞게 계산해서 저장한다.
        이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고)
        1.4	현재 반과 총점과 등수를 이전 반(prevBan),
        이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
        */

        /*
        ⭐ 0. main단의 로직상 calculateSchoolRank(list)을 수행하는데,
        이 calculateSchoolRank(list)에는 Collections.sort(list)로 기본정렬을 수행한다.
        Student9의 기본정렬은 위의 int compareTo(Object o)에서 구현되어 있듯이, 총점수 내림차순이다.
        ⭐따라서 총점수 내림차순 이후 전교 석차를 매기는 로직이 이미 실행되고 난 이후라는 사실을 생각하자!
        ⭐게다가, Collections.sort(list, new ClassTotalComparator());를 수행했으니 반오름차순 다음 반 석차 오름차순이 수행된 상태이다.
         */

        int banGrade = 1; //🔥 int banGrade는 반 등수를 계산할 변수이다.
        //🔥 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다. (⭐총점수 내림차순된 순으로 정렬되어 있을 것)
        for(int i=0; i<length; i++) {
            Student9 s = (Student9) list.get(i);
            //🔥 1.1 반이 달라지면 이전 등수와 이전 총점을 초기화한다.
            if(s.ban!=prevBan) {
                prevTotal = -1; // prevBan을 초기화하는게 아니라 이전 총점prevTotal을 초기화해야함
                prevRank = -1; //🔥 반이 달라지면 반 석차를 1로 초기화되어야 함.
                banGrade = 1; //🔥 반이 달라지면 반 등수도 초기화해야 함.
            }
            //🔥 1.2 총점이 이전총점과 같으면 이전 등수를 반 등수로 한다.
            if(s.total==prevTotal) s.classRank = prevRank;
            //🔥 1.3 총점이 서로 다르면 등수의 값을 알맞게 계산해서 저장한다.
            if(s.total!=prevTotal) {
                s.classRank = banGrade;   //🔥banGrade는 반이 달라지면 0이되고, 반이 같으면 계속 1씩 증가한다.
            }
            //🔥 1.4 현재 반, 총점과 등수를 이전 반, 이전 총점, 이전 등수에 저장한다.
            prevBan =s.ban ;
            prevTotal = s.total;
            prevRank = s.classRank;
            banGrade++; //🔥 반 등수는 반이 달라질 때 0으로 초기화되며, 반이 같을 때 ++되어야 한다.
        }

    } //public static void calculateClassRank(List list) {
    public static void calculateSchoolRank(List list) {
        /* 내용 생략 */
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
            if(itSud instanceof  Student9) {
                Student9 s = (Student9) itSud;
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
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student9("이자바", 2, 1, 70, 90, 70));
        list.add(new Student9("안자바", 2, 2, 60, 100, 80));
        list.add(new Student9("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student9("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student9("김자바", 1, 2, 80, 80, 90));
        calculateSchoolRank(list);
        calculateClassRank(list);
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

/*
<실행결과>
홍길동,1,3,100,100,100,300,100.0,1,1
김자바,1,2,80,80,90,250,83.3,2,2
남궁성,1,1,90,70,80,240,80.0,3,3
안자바,2,2,60,100,80,240,80.0,3,1
이자바,2,1,70,90,70,230,76.7,5,2
 */

/*
<모범풀이>
import java.util.*;

class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;
    int schoolRank; // 전교등수
    int classRank; // 반등수

    Student(String name, int ban, int no, int kor, int eng, int math) {
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
        if (o instanceof Student) {
            Student tmp = (Student) o;

            return tmp.total - this.total;
        } else {
            return -1;
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
                + "," + schoolRank

                + "," + classRank
                ;
    }

// 새로추가

} // class Student

class ClassTotalComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        int result = s1.ban - s2.ban; // 반(ban) 기준 정렬(오름차순)

        if (result == 0)
            result = s2.total - s1.total;    // 총점(total) 기준 정렬(내림차순)
                                            //✔️ 나와 달리 반이 같으면 총점 기준으로 정렬했다. 생각해보니 반 석차는 아직 정해지기 전이잖아..

        return result;
    }
}

class Exercise11_9 {
    public static void calculateClassRank(List list) {
// 먼저 반별 총점기준 내림차순으로 정렬한다.
        Collections.sort(list, new ClassTotalComparator());

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        //💡💡✔️✔️ 반 석차를 위한 n이라는 등수를 for문에 추가했다. 마찬가지로 증감식에 n++를 추가했다!
        for (int i = 0, n = 0; i < length; i++, n++) {
        //⭐	1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
            Student s = (Student) list.get(i);

        //⭐	1.1 반이 달라지면,(ban와 prevBan이 다르면)
        //	이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화 한다.
            if (s.ban != prevBan) {
                prevRank = -1;  //❗❗ 나와 달리 prevRank를 1로 초기화하지 않았다.
                                //❓그런데 1반의 마지막 석차 학생의 총점과 2반의 1등 학생 총점이 같으면 1.2에서 반 등수로 -1을 반환하지 않나?
                                //✔️ 아니지, prevTotal을 초기화하는 데 상관없지!
                prevTotal = -1;
                n = 0;  //✔️ 마찬가지로 반이 바뀌면 n 초기화
            }

        //	1.2 총점(total)이 이전총점(prevTotal)과 같으면
        //	이전 등수(prevRank)를 등수(classRank)로 한다.
            if (s.total == prevTotal) {
                s.classRank = prevRank;
            } else {
        //	1.3 총점이  서로  다르면,
        //	등수(classRank)의 값을 알맞게 계산해서 저장한다.
        //	이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야한다.
                s.classRank = n + 1;
            }

        //	1.4 현재 반과 총점과 등수를 이전 반(prevBan),
        //	이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
            prevBan = s.ban;
            prevRank = s.classRank;
            prevTotal = s.total;
        }
    } // public static void calculateClassRank(List list) {

    public static void calculateSchoolRank(List list) {
        Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

        int prevRank = -1;    // 이전 전교등수 int prevTotal = -1;		// 이전 총점 int length = list.size();

        for (int i = 0; i < length; i++) {
            Student s = (Student) list.get(i);

            if (s.total == prevTotal) {
                s.schoolRank = prevRank;
            } else {
                s.schoolRank = i + 1;
            }

            prevRank = s.schoolRank;
            prevTotal = s.total;
        } // for
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 80));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 80, 80, 90));

        calculateSchoolRank(list);
        calculateClassRank(list);
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}

/*
실행결과
홍길동,1,3,100,100,100,300,100.0,1,1
김자바,1,2,80,80,90,250,83.3,2,2
남궁성,1,1,90,70,80,240,80.0,3,3
안자바,2,2,60,100,80,240,80.0,3,1
이자바,2,1,70,90,70,230,76.7,5,2

 */
 */