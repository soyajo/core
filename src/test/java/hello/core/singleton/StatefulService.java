package hello.core.singleton;

public class StatefulService {

    private Integer price; //상태를 유지하는 필드

    public Integer order(String name, Integer price) {
        System.out.println("name = " + name + "  price = " + price);
//        this.price = price;//여기가 문제!
        return price;
    }

//    public Integer getPrice() {
//        return price;
//    }
}
