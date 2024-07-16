package hello.core.singleton;

public class StatefulService {
    // command+shift+t => test 파일 생성
    private int price; // 상태를 유지하는 필드

    public void order(String name, int Price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
