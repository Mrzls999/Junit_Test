package javaWeb.shop.service;

import javaWeb.shop.entity.Book;
import javaWeb.shop.entity.PageBean;

import java.util.List;

public interface BookService {
    /**
     * 获得所有图书信息
     * @return
     */
    List<Book> getAllBooks();

    /**
     * 添加一行图书信息
     * @param sql
     * @return
     */
    boolean addBook(String sql);

    /**
     * 删除一本书
     * @param sql
     * @return
     */
    boolean delBookFromID(String sql);

    /**
     * 根据id修改时的数据回显
     * @param sql
     * @return
     */
    Book displayDataById(String sql);

    /**
     * 根据id进行book的数据修改
     * @param sql
     * @return 是否修改成功
     */
    boolean updateBookById(String sql);

    /**
     * 分页展示图书信息
     * @return
     */
    PageBean<Book> showPagination(int pageNo);

    /**
     * 根据查询条件，分页展示图书信息
     * @return
     */
    PageBean<Book> showPaginationFromCondition(int pageNo, String bookTitle);
}
