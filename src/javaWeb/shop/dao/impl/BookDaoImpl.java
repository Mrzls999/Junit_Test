package javaWeb.shop.dao.impl;

import javaWeb.shop.dao.BookDao;
import javaWeb.shop.entity.Book;
import javaWeb.shop.utils.BaseDBUtils;

import java.util.List;

public class BookDaoImpl implements BookDao {
    /**
     * 获得所有图书信息
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        return new BaseDBUtils().getBeanList("SELECT * FROM books", Book.class);
    }

    /**
     * 添加一行图书信息
     * @return
     */
    @Override
    public int addBook(String sql) {
        return new BaseDBUtils().update(sql);
    }

    /**
     * 删除一本书
     * @param sql
     * @return
     */
    @Override
    public int delBookFromID(String sql) {
        return new BaseDBUtils().update(sql);
    }
}
