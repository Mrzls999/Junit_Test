package javaWeb.shop.dao;

import javaWeb.shop.entity.Book;

import java.util.List;

public interface BookDao {
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
    public int addBook(String sql);

    /**
     * 删除一本书
     * @param sql
     * @return
     */
    public int delBookFromID(String sql);
}
