# 각 요구사항별 학습 내용 정리
* 구현 단계에서는 각 요구사항을 구현하는데 집중한다. 
* 구현을 완료한 후 구현 과정에서 새롭게 알게된 내용, 궁금한 내용을 기록한다.
* 각 요구사항을 구현하는 것이 중요한 것이 아니라 구현 과정을 통해 학습한 내용을 인식하는 것이 배움에 중요하다.

### 요구사항 1 (requirements-1) - http://localhost:8080/index.html로 접속시 응답
* [maven to gradle로 변환 후 서버 실행](https://www.notion.so/hhero/maven-to-gradle-271a580ec4db4dc5bc089a1a4844916c?pvs=4)
* [gradle .gradle 폴더 차이](https://www.notion.so/hhero/gradle-gradle-eecf7b1578654f7a91d54953764cd905?pvs=4)
* [WebServer, RequestHandler 코드 분석](https://www.notion.so/hhero/WebServer-RequestHandler-b5347b0cf9df4621bab971729365642e?pvs=4)
* [새로운 스레드가 생성 될 때마다 포트가 바뀌는 이유는 뭔가요 ?](https://www.notion.so/hhero/e528090919fb4517bb0aae47015f40ff?pvs=4)
* [동적 포트를 하는 이유는 뭔가요?](https://www.notion.so/hhero/d52788e03e054d3ab7edd5e46dbc6791?pvs=4)
* [웹 서버 접근 시 2번 로그가 찍히는 이유](https://www.notion.so/hhero/2-abc7bca9ae8c43e5aa43d0e8ee3e8b4c?pvs=4)
* [localhost:8080 접근 시 index.html 응답하기](https://www.notion.so/hhero/localhost-8080-index-html-847fc4538bc14c00bb62c84cd87aa2e4?pvs=4)
* [thread에서 InputStream, OutputStream in하고 out의 역할은 무엇인가요?](https://www.notion.so/hhero/thread-InputStream-OutputStream-in-out-0e24c29c1aa8453ea3c8c2181fde8170?pvs=4)
* [ServerSocket이란 무엇인가요?](https://www.notion.so/hhero/ServerSocket-8a0374292fc445ee943f7682fd9561fe?pvs=4)
* [Socket 객체는 무엇인가요?](https://www.notion.so/hhero/Socket-20143a050ec94fc2b975872260614cd4?pvs=4)
* [Socket이 어떻게 서버에 연결 요청을 할 수 있는건가요?](https://www.notion.so/hhero/Socket-a91385f69a10476d9567c6de44d8bf34?pvs=4)
* [왜 연결 할 땐 3-way handshake고 연결 종료 할 때는 4-way handshake 인가요 ?](https://www.notion.so/hhero/3-way-handshake-4-way-handshake-fd9a6a192c674284accd060c4beccf1d?pvs=4)
* [class DataOutputStream는 무엇인가요?](https://www.notion.so/hhero/class-DataOutputStream-0ea2e0681cde4da08932e1cc69c8c9f5?pvs=4)
* [class FilterOutputStream는 무엇인가요?](https://www.notion.so/hhero/class-FilterOutputStream-87760426333542a5b7c8af479f3851a8?pvs=4)
* [interface DataOutput은 무엇인가요?](https://www.notion.so/hhero/interface-DataOutput-c39d2a1a823e4a6a94766c62125f197f?pvs=4)
* [데코레이터 패턴이란?](https://www.notion.so/hhero/17924c0c8bfa4ee1850e854451b3331d?pvs=4)
* [객체 조합이란게 뭔가요?](https://www.notion.so/hhero/4dd714e7bb414220bc7b298d7dabecc9?pvs=4)
* [Thread의 private static native void registerNatives() 는 무슨 역할을 하나요 ?](https://www.notion.so/hhero/Thread-private-static-native-void-registerNatives-a6497341d03247ad86b6a86e3f78feb2?pvs=4)
* [static { registerNatives(); } 블록은 어떤건가요 ?](https://www.notion.so/hhero/static-registerNatives-60d16b494c4644edb2938c27e09c7b61?pvs=4)
* [Thread하고 Runnable의 차이점](https://www.notion.so/hhero/Thread-Runnable-04f468f3294d487ba01c025017827df4?pvs=4)
* [File 클래스는 어떻게 되어 있나요?](https://www.notion.so/hhero/File-cd7b2927c2cf448fbae527e3bf433ead?pvs=4)
* [FileInputStream에서 생성자에서 File을 받아서 뭘 하나요?](https://www.notion.so/hhero/FileInputStream-File-13111d8d49444315a5d580adbddf909f?pvs=4)
* [SecurityManager는 무슨 역할을 하나요?](https://www.notion.so/hhero/SecurityManager-dda262ad6fa849ccb6664bd788bab8e9?pvs=4)

### 요구사항 2 (requirements-2) - get 방식으로 회원가입
* [Socket에서 QueryString 받기](https://www.notion.so/hhero/Socket-InputStream-73a3c00cb8cf460bb032b933bedbbf76?pvs=4)
* [HTTP Request Header 정보](https://www.notion.so/hhero/HTTP-Request-Header-8c5b9046bd5a4b3e8ba34d929eba4b52?pvs=4)
* [HTTP GET Method란 무엇인가요?](https://www.notion.so/hhero/HTTP-GET-Method-da3b872f21ff4bd08f777d8e297ad9d5?pvs=4)
* [private static Map<String, User> users = Maps.newHashMap()는 어떤식으로 작동이 되는건가요?](https://www.notion.so/hhero/private-static-Map-String-User-users-Maps-newHashMap-8c02b720295c413786ef7fb74f41dba5?pvs=4)
* [Sec-Fetch-Dest 헤더를 사용하여 요청을 식별하는게 정확한 방법 인가요?](https://www.notion.so/hhero/Sec-Fetch-Dest-74ebfbdcb9254845a6d7557522a5ea46?pvs=4)
* [클라이언트가 GET으로 웹 서버에 요청 했을 때 어떻게 웹 서버가 요청을 받는거죠 ?](https://www.notion.so/hhero/GET-0fc8bfc808b240b2a53eca131dd1bae2?pvs=4)
* [왜 프리플라이트는 TCP 핸드 쉐이크를 안하죠 ?](https://www.notion.so/hhero/TCP-84480d229ffd474b9c23546a84e51187?pvs=4)
* [Connection: keep-alive 연결을 유지한다는게 어떤 개념인가요?](https://www.notion.so/hhero/Connection-keep-alive-1a660255ae3448d69ee5cf710af4ba05?pvs=4)

### 요구사항 3 (requirements-3) - post 방식으로 회원가입
* [Socket에서 Body 받기](https://www.notion.so/hhero/Socket-Body-0390e7ed4071430c891d89326a99f257?pvs=4)
* [GET은 응답헤더를 읽는데 POST는 대기중으로 뜨는 이유는 뭔가요?](https://www.notion.so/hhero/get-post-e22b1ecdff2b40858d6b209f3b38999f?pvs=4)
* [HTTP POST Method란 무엇인가요?](https://www.notion.so/hhero/HTTP-POST-Method-9a4395d5bd2c48f384e44d212e0ea74c?pvs=4)
* [HTTP Request POST Body를 Web Server에서 받을 때 왜 꼭 Length에 맞게 읽어야하나요?](https://www.notion.so/hhero/HTTP-Request-POST-Body-Web-Server-Length-2575a7e3e8364858a8905e6ee395ac50?pvs=4)
* [HTTP POST는 왜 GET보다 안전하다고 하나요?](https://www.notion.so/hhero/HTTP-POST-GET-81cfca66a10e40efbed42d2f75de311a?pvs=4)
* [HTTPS가 어떻게 암호화하고 탈취는 어떻게 해서 확인을 한다는건가요 ?](https://www.notion.so/hhero/HTTPS-ff7b4f72167d48b68c63169ba3b66609?pvs=4)
* [HTTP 데이터 탈취 예시가 있나요 ?](https://www.notion.so/hhero/HTTP-d77947d8cd5b4aec88a19017ef23e482?pvs=4)

### 요구사항 4 (requirements-4) - redirect 방식으로 이동
* [HTTP 상태 코드 유래](https://www.notion.so/hhero/HTTP-0dcc9eed723242b0906af0b88054bcb1?pvs=4)
* [Content-Type, Cache-Control, Authorization, Set-Cookie에 대해](https://www.notion.so/hhero/Content-Type-Cache-Control-Authorization-Set-Cookie-a5ad33e43ad44f559dccd3aabe9065b7?pvs=4)
* [Body 불러온 후 Request 첫번째 줄 NULL 오류](https://www.notion.so/hhero/Body-Request-NULL-86617a542d224cc6971e92db35387a28?pvs=4)

### 요구사항 5 (requirements-5) - cookie
* [HTTP Cookie가 생긴 이유는 뭔가요 ?](https://www.notion.so/hhero/HTTP-Cookie-62820fb4a8f94daeb859fe9eb0b6079a?pvs=4)
* [HTTP Cookie의 유래는 뭔가요 ?](https://www.notion.so/hhero/HTTP-Cookie-666384284f3a4c1584d4bc5d02d72c43?pvs=4)
* [HTTP  Session은 어떻게 작동하는 건가요 ?](https://www.notion.so/hhero/HTTP-Session-13b74a6df0884366a5ff036a8022caeb?pvs=4)

### 요구사항 6 (requirements-6) - 사용자 목록 출력
* [AtomicInteger이란 어떤 객체 인가요 ?](https://www.notion.so/hhero/AtomicInteger-2e03ffc3610c4ee694304412b83251d9?pvs=4)
* [volatile 지시어는 무엇인가요 ?](https://www.notion.so/hhero/volatile-2d83dc8067e545548762134abe3b68d2?pvs=4)
* [Map의 forEach는 어떻게 작동 되는건가요 ?](https://www.notion.so/hhero/Map-forEach-30ac849d3ffa4ec6a588504d4b10a8e9?pvs=4)

### 요구사항 7 (requirements-7) - stylesheet 적용
* [Content-Type은 어떤건가요 ?](https://www.notion.so/hhero/Content-Type-7a21058b79894f78950271d3ec692a6d?pvs=4)
* [RFC란 무엇인가요?](https://www.notion.so/hhero/RFC-0a19bc9c012e4d8698580ab845ebb302?pvs=4)

### 책 참고 없이 리팩터링 및 테스트 코드 작성 (test-junit5)
* [어노테이션, 리플랙션 정리](https://www.notion.so/hhero/47a1437cd9144259b583d2e6f2e7d6ce?pvs=4)
* [ServerSocket 접근 시 Client IP, Port](https://www.notion.so/hhero/ServerSocket-Client-IP-Port-86a48e60641a417083fc522b9355b3d2?pvs=4)
* [String, StringBuffer 차이](https://www.notion.so/hhero/String-StringBuffer-61d842e5b2de4dec91f2637848412bb7?pvs=4)
* [HTTP 통신과 소켓 통신의 차이](https://www.notion.so/hhero/HTTP-39c54720da4e4e668472bf8182d9d5dd?pvs=4)
* [Openfeign, RestTemplate 차이](https://www.notion.so/hhero/Openfeign-RestTemplate-74f94e23eff34b13829fb8cca02a627a?pvs=4)
* [자바 스레드 상호 배제 동기화 기법 확인](https://www.notion.so/hhero/337955132f0f4e67957e8e78eef8f955?pvs=4)
* [스레드의 start()와 run()](https://www.notion.so/hhero/start-run-b7f0274f861b451491b8116abcd223af?pvs=4)
* [JUnit5 시작하기](https://www.notion.so/hhero/JUnit5-019bc3538d9f433aad8c0fb2e969a7ec?pvs=4)
* [JUnit5 No matching tests found in any candidate test task. 오류](https://www.notion.so/hhero/JUnit5-No-matching-tests-found-in-any-candidate-test-task-ef11a31aec3640d2bba087e15ba1992a?pvs=4)
* [JUnit5 assert 사용](https://www.notion.so/hhero/JUnit5-assert-01d818e241bd402e943957361ba6217b?pvs=4)
* [gradle useJUnitPlatform은 무슨 역할을 하나요 ?](https://www.notion.so/hhero/gradle-useJUnitPlatform-5606d96f6ea0455b9ba9a049ba5a0dea?pvs=4)

### 리팩터링 1 (refactor-1) - 요청 처리 분리
* [리팩터링이란?](https://www.notion.so/hhero/f83191bcfa6845b694def9d993e9e82c?pvs=4)
* [리팩터링을 할 때 가장 많이 사용하는 기술은?](https://www.notion.so/hhero/db3a5d14ad564599970c3de5274817f7?pvs=4)

### 리팩터링 2 (refactor-2) - 응답 처리 분리

### 리팩터링 3 (refactor-3) - 다형성 활용하여 요청 분기 처리 제거
* [자바 다형성이란?](https://www.notion.so/hhero/a4ba3bc2d84b427f8f5124eaa863c3dd?pvs=4)

### 톰캣(WAS) 1 (tomcat-1) - Tomcat 의존 받아서 Hello World 띄우기
* [톰캣 8 이전, 이후 서블릿 등록 차이](https://www.notion.so/hhero/8-b2526b1d049648bebb4c89e9647c1a51?pvs=4)
