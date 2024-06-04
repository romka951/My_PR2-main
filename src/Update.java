import Model.Book;
import Model.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            Book book = new Book(id, title, author);
            BookDB.update(book);
            response.sendRedirect(request.getContextPath() + "/view");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Book book = BookDB.selectOne(id);
            if(book!=null) {
                request.setAttribute("book", book);
                getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
