//[7-8] 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은?
//a.	public-protected-(default)-private
//b.	public-(default)-protected-private
//c.	(default)-public-protected-private
//d.	private-protected-(default)-public

/*<내 풀이>
 * 접근제어자의 범위는 다음과 같다.
 * public : 접근 제한 없음
 * protect : 같은 패키지 + 상속받은 자손 클래스에서 접근 허용
 * (default) : 같은 패키지 내부에서만 접근 허용 
 * private : 같은 클래스 내부에서만 접근 허용
 * 
 * 별개로 class는 public과 (default)만이 허용된다.
 * 대신 내부클래스는 4개의 접근 제어자가 모두 허용된다.
 * 
 * 추가적으로 좋은 코드는 상속의 윗 계층에서 범위를 최대한 좁게 만든 코드이다.
 * 추후 유지보수에 바람직한 코드가된다.
 * 
 * 정답: a
 */