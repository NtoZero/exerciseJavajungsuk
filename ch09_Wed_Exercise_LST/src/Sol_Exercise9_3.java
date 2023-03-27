//[9-3] 다음과 같은 실행결과가 나오도록 코드를 완성하시오.
class Exercise9_3 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        /*
        (1) 알맞은 코드를 넣어 완성하시오.
        */

        int LastIndexOfRegex = fullPath.lastIndexOf("\\");
        path = fullPath.substring(0, LastIndexOfRegex);
        fileName = fullPath.substring(LastIndexOfRegex+1); //✔️⭐ 시작인덱스는 포함이기 때문에 시작인덱스+1을 해주어야함!

        System.out.println("fullPath:"+fullPath);
        System.out.println("path:"+path);
        System.out.println("fileName:"+fileName);

    }
}

/*
<실행결과>
fullPath:c:\jdk1.8\work\PathSeparateTest.java
path:c:\jdk1.8\work
fileName:PathSeparateTest.java
 */

/*
<🤪문제접근>
해당 문제는 이미 참조변수에 빈 문자열로 초기화된 String 값을 바꾸는 문제이다.
⭐그러나 String 클래스는 immutable 클래스이므로 값이 바뀔 수 없다.
대신, 문자열이 다른 객체를 참조하게 할 수 있는데, 간단히 참조변수 값을 재지정해주면 된다.
이렇게 되면 기존 객체는 참조하고 있던 변수와의 연결이 사라지므로, GC에 의해 메모리에서 제거당한다.
그리고 새로 할당한 String 객체가 Heap의 Metaplace 라는 공간의 상수 풀에 저장되게 된다.
참조변수와 연결도 이어져 있으므로 해당 String 객체는 상수 풀에 잔존하게 되며,
추후 큰따옴표"" 연산자로 String 객체를 생성하면 해당 객체가 String pool에 존재하는지 여부를 살피고,
존재한다면 객체 생성 없이 해당 값을 참조하도록 참조변수의 연결을 조작한다.
존재하지 않는다면 상수 풀에 또다른 객체를 생성한다.



<수정된 문제 접근>
❗자세히 살펴보니, fullpath가 path와 fileName의 결합으로 이루어진 문자열이었다.
이를 분할하여 저장하기 위해서 다음과 같은 방식을 생각했다.
1. 구분자로 나누는 split메서드를 사용한다.
➡️ \\를 기준으로 나눠야 한다. 문자열 배열을 만들어 path와 fileName으로 적절하게 나눠야 한다.
2. subString()으로 일부 문자열을 발췌한다.
➡️ 어느 지점에서 자를 것인지 index를 알아야 한다.

String을 구분자로 분할하는 문제였다.


*/

/*
<정답>
class Exercise9_3 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";
        int pos = fullPath.lastIndexOf("\\");
        if (pos != -1) {	//💡💡 lastIndexOf를 사용할 때는
            path = fullPath.substring(0, pos);
            fileName = fullPath.substring(pos + 1);
        }

        System.out.println("fullPath:" + fullPath);
        System.out.println("path:" + path);
        System.out.println("fileName:" + fileName);
    }
}
 */