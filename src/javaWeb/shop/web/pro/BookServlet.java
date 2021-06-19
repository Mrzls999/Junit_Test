package javaWeb.shop.web.pro;

import javaWeb.shop.entity.Book;
import javaWeb.shop.service.impl.BookServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book")//@WebServlet(name = "BookServlet", urlPatters = "/book")
public class BookServlet extends BaseServlet {

    /**
     * 书籍curd
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBooks = new BookServiceImpl().getAllBooks();
        for (Book book : allBooks) {
            System.out.println(book.getAuthor());
        }
        request.setAttribute("allBooks",allBooks);
        request.getRequestDispatcher("/shop/pages/manager/book_manager.jsp").forward(request,response);
    }
}
