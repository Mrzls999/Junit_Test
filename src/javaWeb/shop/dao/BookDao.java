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

    /**
     * 根据id修改时的数据回显
     * @param sql
     * @return
     */
    public Book displayDataById(String sql);

    /**
     * 根据id进行book的数据修改
     * @param sql
     * @return
     */
    public int updateBookById(String sql);

    /**
     * 得到总记录数
     * @return
     */
    public int getTotalRecordCount();

    /**
     * 得到每页数据集合
     * @param begin
     * @param i
     * @return
     */
    List<Book> getPageList(int begin, int i);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int getTotalRecordCountFromCondition(String bookTitle);

    /**
     * 根据条件查询当页数据集合
     * @param begin
     * @param pageSize
     * @param bookTitle
     * @return
     */
    List<Book> getPageListFromCondition(int begin, int pageSize, String bookTitle);
}
