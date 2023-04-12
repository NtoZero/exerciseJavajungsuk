//[12-7] 애너테이션 TestInfo가 다음과 같이 정의되어 있을 대, 이 애너테이션이 올바르게 적용되지 않은 것은?

@interface TestInfo {
    int count() default 1;
    String[] value() default "aaa";
}


//a.	@TestInfo	class Exercise12_7 {}
//b.	@TestInfo(1)	class Exercise12_7 {}   ❌ value()가 String 타입이므로 불가능
//c.	@TestInfo("bbb")	class Exercise12_7 {}
//d.	@TestInfo("bbb","ccc") class Exercise12_7 {}


/*
[정답] b, d

        [해설]
        a.	@TestInfo	class Exercise12_7 {}
    default값이 지정되어 있는 요소는 애너테이션을 적용할 때값을 생략할 수 있다.
        b.	@TestInfo(1)	class Exercise12_7 {}
    요소의 이름이 value가 아닌 경우에는 요소의 이름을 생략할 수 없다. ‘@TestInfo(count=1)’이라고 써야 맞음.
        c.	@TestInfo("bbb")	class Exercise12_7 {} @TestInfo(count=1, value={"bbb"})의 생략된 형태
        d.	@TestInfo("bbb","ccc") class Exercise12_7 {}
    요소의 타입이 배열이고, 지정하려는 값이 여러 개인 경우 괄호{}가 필요함. @TestInfo({"bbb", "ccc"}) 또는 @TestInfo(value={"bbb","ccc"})와 같이 써야함
    */
