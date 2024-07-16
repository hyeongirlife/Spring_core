package hello.core.singleton;

public class SingletonService {

    // 객체의 인스턴스는 해당 서비스 내에서 딱 한번 생성된다.
    // 해당 service 를 통해서만 생성된 인스턴스를 가져올 수 있다.
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private 로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
