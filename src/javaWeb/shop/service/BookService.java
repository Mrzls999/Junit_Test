package javaWeb.shop.service;

import javaWeb.shop.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 获得所有图书信息
     * @return
     */
    public List<Book> getAllBooks();

    /**
     * 添加一行图书信息
     * @param sql
     * @return
     */
    public boolean addBook(String sql);

    /**
     * 删除一本书
     * @param sql
     * @return
     */
    public boolean delBookFromID(String sql);
}
