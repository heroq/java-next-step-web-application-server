1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
- 1. 클래스 로더 초기화
- 2. server.xml 파싱
- 3. 웹 애플리케이션 배포 시작
- 4. WAR 파일 or 디렉토리 구조 인식
- 5. 웹 애플리케이션 컨텍스트 생성
- 6. web.xml 파싱
- 7. 서블릿 컨테이너 초기화

2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
- 1. localhost:8080 접근
- 2. 서블릿 접근 전 필터 실행
- 3. 요청 처리가 "/"이므로 매핑되어 있는 DispatcherServlet service() 메소드 실행
- 4. service() 메소드는 내부적으로 doDispatch()을 실행한다.
- 5. doDispatch() 메소드에서 RequestMapping에 "/"가 연결되어있는 Controller를 찾아서 해당 메소드를 실행한다. 반환은 ModelAndView를 한다.
- 6. render() 메소드인 ViewResolver를 통해 논리적 뷰 이름을 실제 뷰 객체로 변환 (JSP, Thymeleef)
- 7. 필터 체인을 역순으로 통과 후 클라이언트에게 반환

7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
