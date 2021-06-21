package javaWeb.shop.web.pro;

import javaWeb.shop.entity.Book;
import javaWeb.shop.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book")//@WebServlet(name = "BookServlet", urlPatters = "/book")
public class BookServlet extends BaseServlet {

    /**
     * 书籍curd
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBooks = new BookServiceImpl().getAllBooks();
        request.setAttribute("allBooks", allBooks);
        request.getRequestDispatcher("/shop/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 添加一行图书信息
     *
     * @return
     */
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            String sql = "INSERT INTO books VALUES(NULL,'" + book.getTitle() + "','" + book.getAuthor() + "'," + book.getPrice() + "," + book.getStock() + "," + book.getSales() + ")";
            boolean success_addBookFlag = new BookServiceImpl().addBook(sql);//成功插入标志
            if (success_addBookFlag) {
                request.setAttribute("success_addBookFlag", true);
            } else {
                request.setAttribute("success_addBookFlag", false);
            }
        } catch (IllegalAccessException | InvocationTargetException | ConversionException e) {
            request.setAttribute("success_addBookFlag", false);
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("/shop/pages/manager/book_add.jsp").forward(request, response);
        }
    }

    /**
     * 删除一本书，通过ID
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delBookFromID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("id");
        boolean delBookSuccess_Flag = new BookServiceImpl().delBookFromID("DELETE FROM books WHERE ID=" + bookId);
        if (delBookSuccess_Flag) {
            request.setAttribute("delBookSuccess_Flag",true);
        }else {
            request.setAttribute("delBookSuccess_Flag",false);
        }
        request.getRequestDispatcher("/book?meth=getAllBooks").forward(request,response);
    }


}
