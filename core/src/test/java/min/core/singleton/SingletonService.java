package min.core.singleton;

public class SingletonService {

    //static 영역에 객체를 한개만 생성
    private static final SingletonService instance = new SingletonService();

    //public으로 열어서 필요하면 static 메서드를 통해서만 조회되도-록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언하여 외부에서 new 키워드를 이용한 객체 생성을 못하게 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
