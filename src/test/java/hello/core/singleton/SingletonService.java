package hello.core.singleton;

public class SingletonService {
    //1. 자기 자신을 static 영역에 하나만 생성
    private static final SingletonService instance = new SingletonService();
    //2. 오직 하나의 동일한 인스턴스만 호출하게 된다
    public static SingletonService getInstance() {
        return instance;
    }
    //3. 외부 클래스에서 생성하지 못 하도록 생성자를 private 처리
    private SingletonService() {}
}
