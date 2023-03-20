//[8-4] 다음과 같은 메서드가 있을 때, 예외를 잘못 처리한 것은? (모두 고르시오)
//  void method() throws InvalidNumberException, NotANumberException {}
//  class NumberException extends RuntimeException {}
//  class InvalidNumberException extends NumberException {}
//  class NotANumberException extends NumberException {}
//
//a.	try {method();} catch(Exception e) {}
//b.	try {method();} catch(NumberException e) {} catch(Exception e) {}
//c.	try {method();} catch(Exception e) {} catch(NumberException e) {}
//d.	try {method();} catch(InvalidNumberException e) {} catch(NotANumberException e) {}
//e.	try {method();} catch(NumberException e) {}
//f.	try {method();} catch(RuntimeException e) {}


/*
<내 풀이>
void method()를 호출하는 메서드에서는 InvalidNumberException과 NotANumberExeption을 예외 처리 하거나 떠넘기기 해야한다.
a는 옳다. Exception이 모든 예외의 조상클래스이므로 catch 구문에서 성공적으로 예외를 잡을 수 있다.
⭐b는 옳다. NumberException에서는 InvalidNumberException을 잡을 수 있고 NotANumberException이나 다른 예외에 대한 처리는 Exception이 한다.❓❓
⭐⭐c는 옳지 않다. 부모 예외와 자손 예외 중 부모 예외가 먼저 catch로 잡게된다면 뒤의 구문은 동작하지 않게 되므로 의미 없는 문법에 대해 오류가 발생한다.
d는 옳다. 요청한 두 예외에 대한 예외 처리가 정상적으로 이뤄진다.
e는 옳다. InvalidNumberException이 NumberException를 상속받았으며, InvalidNumberException이 NumberException을 상속받았으므로 공통조상이다.
f는 옳다. 공통조상인 NumberException이 RuntimeException을 상속받았으므로 공통 조상으로 형변환이 가능하기 때문에 예외를 처리할 수 있다.

<모범>
[정답] c
[해설] try블럭 내에서 예외가 발생하면, catch블럭 중에서 예외를 처리할 수 있는 것을 을 차례대로 찾아 내려간다.
발생한 예외의 종류와 일치하는 catch블럭이 있으면 그 블럭의 문장들을 수행하고 try-catch문을 빠져나간다.
일치하는 catch 블럭이 없으면 예외는 처리되지 않는다.
발생한 예외의 종류와 일치하는 catch블럭을 찾을 때, instanceof로 검사를 하기 때문에, 모든 예외의 최고조상인 Exception이 선언된 catch블럭은 모든 예외를
다 처리할 수 있다.
한 가지 주의할 점은 Exception을 처리하는 catch블럭은 모든 catch 블럭 중 제일 마지막에 있어야 한다는 것이다.

try {
method();
} catch(Exception e) { // 컴파일 에러 발생!!!

} catch(NumberException e) {

}

위의 코드에서는 Exception을 선언한 catch블럭이 마지막
 catch블럭이 아니기 때문에 컴파일 에러가 발생한다.

<❓궁금한 점❓>
한 코드에서 예외가 동시에 2개 이상 발생할 수는 없나?
그리고 이 경우에도 Exception 하나가 2개의 예외를 catch할 수 있나?
그 흐름이 어떻게 되는건지 궁금하다.
해당 catch블럭에서 예외의 경우의 수에 따라 if문에 따른 처리를 해주면 되는건가?

 */