/*
[9-13] 다음은 하나의 긴 문자열(source) 중에서 특정 문자열과 일치하는 문자열의 개수 를 구하는 예제이다.
빈 곳을 채워 예제를 완성하시오.

*/
public class Sol_Exercise9_13 {
    public static void main(String[] args) {
        String src = "aabbccAABBCCaa";
        System.out.println(src);
        System.out.println("aa를 "+stringCount(src,"aa")+"개 찾았습니다.");
    }

    static int stringCount(String src,String key){
        return stringCount(src,key,0);
    }

    static int stringCount(String src,String key,int pos){
        int count=0;
        int index=0;

        if(key==null||key.length()==0) return 0;

        /*
        (1) 알맞은 코드를 넣어 완성하시오.
        */
        for(pos=src.indexOf(key); pos<src.length(); ) { //🔥
            if(pos == -1) break;
            ++count;    //pos가 존재하면 ++count
            pos += key.length();    //pos는 key.length()값이 더해져야함.
            pos = src.indexOf(key, pos); //재할당된 pos 값부터 다시 key를 찾고 for문으로 되돌아감
        }   //🔥

        return count;
    }
}

/*
<실행결과>
aabbccAABBCCaa
aa를 2개 찾았습니다.
 */

/*
<풀이접근>
어떤 문자열 src에 속해있는 특정 문자열 key의 개수를 찾는 문제이다.
1. src.indexOf(key, pos) 조건을 이용한다.
2. pos의 값은 key값을 찾고 난 이후의 인덱스 값으로 변화해야 한다. 이 때, count는 +1 증가해야 한다.
3. pos의 값이 src.length()를 넘으면 그 전까지의 count를 return 한다.
❓. 그런데 static int stringCount(String src,String key,int pos)에서 index라는 지역변수는 왜 사용하는거지?
 */

/*
<모범풀이>
   static int stringCount(String src, String key, int pos) {
        int count = 0;
        int index = 0;

        if (key == null || key.length() == 0) return 0;

        while((index = src.indexOf(key, pos))!=-1) { //⭐ index에 src.indexOf(key, pos)를 저장한 값이 -1이 아닌 동안
            count++;    //⭐ count를 1 증가하고
            pos = index + key.length(); //⭐ pos 값을 재할당한다.
        }

        return count;
    }
 */

