package javaSe;

import javaWeb.shop.entity.Book;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Book> map = new HashMap<>();
        map.put("1",new Book(1,"1","a", BigDecimal.valueOf(18L),23,32,"xx"));
        map.put("2",new Book(1,"1","a", BigDecimal.valueOf(18L),23,32,"xx"));
        Book book = map.get("2");
        book.setAuthor("bb");
        for (Book value : map.values()) {
            System.out.println(value.getAuthor());
        }
    }
}
