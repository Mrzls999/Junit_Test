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
        BaseDBUtils baseDBUtils = new BaseDBUtils();
        return baseDBUtils.getBeanList("SELECT * FROM books", Book.class);
    }
}
