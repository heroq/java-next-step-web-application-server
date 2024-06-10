# 실습을 위한 개발 환경 세팅
* https://github.com/slipp/web-application-server 프로젝트를 자신의 계정으로 Fork한다. Github 우측 상단의 Fork 버튼을 클릭하면 자신의 계정으로 Fork된다.
* Fork한 프로젝트를 eclipse 또는 터미널에서 clone 한다.
* Fork한 프로젝트를 eclipse로 import한 후에 Maven 빌드 도구를 활용해 eclipse 프로젝트로 변환한다.(mvn eclipse:clean eclipse:eclipse)
* 빌드가 성공하면 반드시 refresh(fn + f5)를 실행해야 한다.

# 웹 서버 시작 및 테스트
* webserver.WebServer 는 사용자의 요청을 받아 RequestHandler에 작업을 위임하는 클래스이다.
* 사용자 요청에 대한 모든 처리는 RequestHandler 클래스의 run() 메서드가 담당한다.
* WebServer를 실행한 후 브라우저에서 http://localhost:8080으로 접속해 "Hello World" 메시지가 출력되는지 확인한다.

# 각 요구사항별 학습 내용 정리
* 구현 단계에서는 각 요구사항을 구현하는데 집중한다. 
* 구현을 완료한 후 구현 과정에서 새롭게 알게된 내용, 궁금한 내용을 기록한다.
* 각 요구사항을 구현하는 것이 중요한 것이 아니라 구현 과정을 통해 학습한 내용을 인식하는 것이 배움에 중요하다.

### 요구사항 1 - http://localhost:8080/index.html로 접속시 응답
* [maven to gradle로 변환 후 서버 실행](https://www.notion.so/hhero/maven-to-gradle-271a580ec4db4dc5bc089a1a4844916c?pvs=4)
* [gradle .gradle 폴더 차이](https://www.notion.so/hhero/gradle-gradle-eecf7b1578654f7a91d54953764cd905?pvs=4)
* [WebServer, RequestHandler 코드 분석](https://www.notion.so/hhero/WebServer-RequestHandler-b5347b0cf9df4621bab971729365642e?pvs=4)
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

### 요구사항 2 - get 방식으로 회원가입
* [Socket에서 InputStream을 어떤 방식으로 읽나요?](https://www.notion.so/hhero/Socket-InputStream-73a3c00cb8cf460bb032b933bedbbf76?pvs=4)

### 요구사항 3 - post 방식으로 회원가입
* 

### 요구사항 4 - redirect 방식으로 이동
* 

### 요구사항 5 - cookie
* 

### 요구사항 6 - stylesheet 적용
* 

### heroku 서버에 배포 후
* 
