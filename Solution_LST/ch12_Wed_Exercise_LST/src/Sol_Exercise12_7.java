//[12-7] 애너테이션 TestInfo가 다음과 같이 정의되어 있을 대, 이 애너테이션이 올바르 게 적용되지 않은 것은?

@interface TestInfo {
    int count() default 1;
    String[] value() default "aaa";
}


//a.	@TestInfo	class Exercise12_7 {}
//b.	@TestInfo(1)	class Exercise12_7 {}
//c.	@TestInfo("bbb")	class Exercise12_7 {}
//d.	@TestInfo("bbb","ccc") class Exercise12_7 {}
