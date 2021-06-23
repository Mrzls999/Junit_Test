package javaWeb.shop.service.impl;

import javaWeb.shop.dao.impl.BookDaoImpl;
import javaWeb.shop.entity.Book;
import javaWeb.shop.entity.PageBean;
import javaWeb.shop.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    /**
     * 获得所有图书信息
     * 因为在jsp页面使用el表达式获取值时，如果为空，直接不进行显示，所以，这地方不需要进行非空判断
     *
     * @return
     */
    @Override
    public List<Book> getAllBooks() {
        return new BookDaoImpl().getAllBooks();
    }

    /**
     * 添加一行图书信息
     *
     * @param sql
     * @return
     */
    @Override
    public boolean addBook(String sql) {
        return new BookDaoImpl().addBook(sql) > 0;
    }

    /**
     * 删除一本书
     *
     * @param sql
     * @return
     */
    @Override
    public boolean delBookFromID(String sql) {
        return new BookDaoImpl().delBookFromID(sql) == 1;
    }

    /**
     * 根据id修改时的数据回显
     *
     * @param sql
     * @return
     */
    @Override
    public Book displayDataById(String sql) {
        return new BookDaoImpl().displayDataById(sql);
    }

    /**
     * 根据id进行book的数据修改
     *
     * @param sql
     * @return 是否修改了一行
     */
    @Override
    public boolean updateBookById(String sql) {
        return new BookDaoImpl().updateBookById(sql) == 1;
    }

    /**
     * 分页展示图书信息
     *
     * @return
     */
    @Override
    public PageBean<Book> showPagination(int pageNo) {
        //进行pageBean的封装
        PageBean<Book> bookPageBean = new PageBean<>();
        //1.当前页
        bookPageBean.setPageNo(pageNo);
        //2.每页显示记录数，固定为3
        int pageSize = 3;
        bookPageBean.setPageSize(pageSize);
        //3.总记录数
        //从数据库中获取总记录数
        int totalRecordCount = new BookDaoImpl().getTotalRecordCount();
        bookPageBean.setTotalRecord(totalRecordCount);
        //4.总页数
        bookPageBean.setTotalPageNo((int)Math.ceil((double) totalRecordCount / pageSize));
        //5.开始位置
        int begin = (pageNo - 1) * pageSize;
        bookPageBean.setBegin(begin);
        //6.每页数据集合
        List<Book> bookList = new BookDaoImpl().getPageList(begin, pageSize);
        bookPageBean.setList(bookList);

        return bookPageBean;
    }

    /**
     * 根据查询条件，分页展示图书信息
     * @return
     */
    @Override
    public PageBean<Book> showPaginationFromCondition(int pageNo, String bookTitle) {
        //进行pageBean的封装
        PageBean<Book> bookPageBean = new PageBean<>();
        //1.当前页
        bookPageBean.setPageNo(pageNo);
        //2.每页显示记录数，固定为3
        int pageSize = 3;
        bookPageBean.setPageSize(pageSize);
        //3.总记录数
        //从数据库中获取总记录数
        int totalRecordCount = new BookDaoImpl().getTotalRecordCount();
        bookPageBean.setTotalRecord(totalRecordCount);
        //4.总页数
        bookPageBean.setTotalPageNo((int)Math.ceil((double) totalRecordCount / pageSize));
        //5.开始位置
        int begin = (pageNo - 1) * pageSize;
        bookPageBean.setBegin(begin);
        //6.每页数据集合
        List<Book> bookList = new BookDaoImpl().getPageList(begin, pageSize);
        bookPageBean.setList(bookList);

        return bookPageBean;
    }
}