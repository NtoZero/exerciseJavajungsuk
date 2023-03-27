//[8-3] 다음 중 오버라이딩이 잘못된 것은? (모두 고르시오)
//		void add(int a, int b)
//				throws InvalidNumberException, NotANumberException {}
//
//		class NumberException extends Exception {}
//		class InvalidNumberException extends NumberException {}
//		class NotANumberException extends NumberException {}
//
//        a.    void add(int a, int b) throws InvalidNumberException, NotANumberException {}
//        b.	void add(int a, int b) throws InvalidNumberException {}
//        c.	void add(int a, int b) throws NotANumberException {}
//        d.	void add(int a, int b) throws Exception {}
//        e.	void add(int a, int b) throws NumberException {}

//

/*
<내 풀이>
해당 문제는 메서드 오버라이딩의 주의사항 중 예외의 상속에 관한 내용이다.
메서드 오버라이딩 시에는 부모 메서드의 예외 개수와 범위를 모두 고려해서,
자손 메서드가 부모 메서드 보다 같거나 적은 범위의 또는 적은 개수의 예외를 선언할 수 있도록 해야 한다.

본문의 void add(int a, int b)는 InvalidNumberException, NotANumberException 두 개의 예외를 선언하고 있다.

❓a는 옳지 않다. 부모와 같은 범위의 예외를 선언할 수 없다. ➡️ ⭐ 부모 메서드와 자손 메서드 모두 같은 범위의 예외를 선언할 수 있다.
b는 옳다. 부모 메서드 보다 예외의 개수가 적고, 범위도 좁아졌다.
c는 옳다. InvalidNumberException에 대한 예외 선언이 없어지고  NotANumberException만 남았다.
💡d는 옳지 않다. 개수는 줄어들었지만 Exception 예외 선언이 되어 있다. Exception은 모든 예외의 조상이므로, 처리해야하는 예외 개수 자체가 더 많다.
💡e는 옳지 않다. NumberException은 InvalidNumberException의 상위 클래스이므로 더 많은 예외를 처리할 가능성이 있다.

<모범>
[정답] d, e
[해설] 오버라이딩(overriding)을 할 때, 조상 클래스의 메서드보다 많은 수의 예외를 선 언할 수 없다.
아래의 코드를 보면 Child클래스의 parentMethod()에 선언된 예외의 개수가 조상인 Parent클래스의 parentMethod()에 선언된 예외의 개수보다 적으므로 바르게 오버라이딩 되었다.


Class Parent {
void parentMethod() throws IOException, SQLException {
//..
}
}

Class Child extends Parent {
void parentMethod() throws IOException {
//..
}
//..
}

💡여기서 주의해야할 점은 단순히 선언된 예외의 개수의 문제가 아니라는 것이다.


Class Child extends Parent {
void parentMethod() throws Exception {
//..
}
//..
}

만일 위와 같이 오버라이딩을 하였다면, 분명히 조상클래스에 정의된 메서드보다 적은 개 수의 예외를 선언한 것처럼 보이지만
Exception은 모든 예외의 최고 조상이므로 가장 많은 개수의 예외를 던질 수 있도록 선언한 것이다.
그래서 예외의 개수는 적거나 같아야 한다는 조건을 만족시키지 못하는 잘못된 오버라이딩인 것이다.

 */

/*
아래의 코드로 이 문제를 직접 테스트할 수 있다.
 */

class NumberException extends Exception {}
class InvalidNumberException extends NumberException {} class NotANumberException extends NumberException {}

class Parent {
    int a;
    int b;

    Parent() {
        this(0, 0);
    }

    Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void add(int a, int b)
            throws InvalidNumberException, NotANumberException {
    }

}

class Child extends Parent {
    Child() {
    }

    Child(int a, int b) {
        super(a, b);
    }

    void add(int a, int b)
            throws InvalidNumberException, NotANumberException {
    }
}