package javaWeb.shop.service.impl;

import javaWeb.shop.dao.impl.BookDaoImpl;
import javaWeb.shop.entity.Book;
import javaWeb.shop.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    /**
     * 获得所有图书信息
     * 因为在jsp页面使用el表达式获取值时，如果为空，直接不进行显示，所以，这地方不需要进行非空判断
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        return new BookDaoImpl().getAllBooks();
    }
}
