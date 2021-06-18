package javaWeb.shop.service;

import javaWeb.shop.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 获得所有图书信息
     * @return
     */
    public List<Book> getAllBooks();
}
