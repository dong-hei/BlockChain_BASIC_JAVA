# BlockChain_BASIC_JAVA

<h3>-여기서 사용하는 MessageDigest클래스는 무엇인가?</h3>

자바에서 단방향 해시 함수 값을 구할 때 사용한다.

- 비밀번호를 해시화하여 저장하고 싶을 때
- 파일의 유효성을 해시 값을 통해 확인하고 싶을 때
- 특정 정보를 암호화하고 싶을 때

('해시화한다'는 '암호화한다'와 유사하다.)

-​해시화하는데 사용되는 알고리즘은 여러 가지가 있는데 대표적으로 MD5, SHA-1 SHA-256 등이 있다.
해시라는 개념 특성상, 비둘기집의 원리가 발생할 수밖에 없다.

MD5
128bit 암호화 해시 함수, RFC 1321로 지정되어 있다. (설계상 결함 발견)

SHA-1
160bit 암호화 해시 함수, SHA 함수들 중 가장 많이 쓰이며, MD5를 대신해서 사용한다. (충돌 발견)

SHA-256
256bit 암호화 해시 함수, SHA-2 함수로 중요한 기술에는 SHA-1을 대신하여 사용한다.

<h3>-자주 사용되는 메소드</h3>

getInstance(String algorithm)
입력한 해시 알고리즘을 수행하는 MessageDigest 객체를 생성.
파라미터로 받는 알고리즘은 NoSuchAlgorithmException 때문에 try / catch로 감싸줘야 한다.

update(byte[] input)
객체 내에 저장된 digest 값을 갱신시킨다.

digest()
update()를 실행, 해시 계산 완료 후 해시화된 값을 반환한다.
