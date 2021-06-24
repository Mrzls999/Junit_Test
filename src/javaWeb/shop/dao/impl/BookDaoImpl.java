package javaWeb.shop.dao.impl;

import javaWeb.shop.dao.BookDao;
import javaWeb.shop.entity.Book;
import javaWeb.shop.entity.PageBean;
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

    /**
     * 根据id修改时的数据回显
     * @param sql
     * @return
     */
    @Override
    public Book displayDataById(String sql) {
        return new BaseDBUtils().getBean(sql,Book.class);
    }

    /**
     * 根据id进行book的数据修改
     * @param sql
     * @return 受影响的行数
     */
    @Override
    public int updateBookById(String sql) {
        return new BaseDBUtils().update(sql);
    }

    /**
     * 得到总记录数
     * @return
     */
    public int getTotalRecordCount() {
        String sql = "SELECT count(1) FROM books";
        Object totalRecordCount = new BaseDBUtils().getOneValue(sql);
        return Integer.parseInt(totalRecordCount+"");
    }

    /**
     * 得到每页数据集合
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Book> getPageList(int begin, int pageSize) {
        String sql = "SELECT * FROM books LIMIT ?,?";
        return new BaseDBUtils().getBeanList(sql, Book.class, begin, pageSize);
    }

    /**
     * 根据条件查询总记录数
     * @return
     */
    @Override
    public int getTotalRecordCountFromCondition(String bookTitle) {
        String sql = "";
        Object oneValue = null;
        if(bookTitle==null||"".equals(bookTitle)){
            sql = "SELECT COUNT(1) FROM books";
            oneValue = new BaseDBUtils().getOneValue(sql);
        }else{
            sql = "SELECT COUNT(1) FROM books WHERE title LIKE ?";
            oneValue = new BaseDBUtils().getOneValue(sql, "%" + bookTitle + "%");
        }
        return Integer.parseInt(oneValue+"");
    }

    /**
     * 根据条件查询当页数据集合
     * @param begin
     * @param pageSize
     * @param bookTitle
     * @return
     */
    @Override
    public List<Book> getPageListFromCondition(int begin, int pageSize, String bookTitle) {
        String sql = "";
        if(bookTitle==null||"".equals(bookTitle)){
            sql = "SELECT * FROM books LIMIT ?,?";
            return new BaseDBUtils().getBeanList(sql, Book.class, begin, pageSize);
        }else {
            sql = "SELECT * FROM books WHERE title LIKE ? LIMIT ?,?";
            return new BaseDBUtils().getBeanList(sql, Book.class,"%"+bookTitle+"%", begin, pageSize);
        }
    }
}
