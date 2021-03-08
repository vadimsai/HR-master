package jdbcproject;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Servlet insert user for JDBC module
 *
 */


@WebServlet("/ServletInsertJdbc")
public class ServletInsertJdbc extends HttpServlet {

    DbJdbcOperations dbJdbcOperations;

    @Override
    public void init() throws ServletException {
        dbJdbcOperations=new OperationsDb();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        Users users=new Users();
        users.setName(request.getParameter("name"));
        users.setSurname(request.getParameter("surname"));
        users.setEmail(request.getParameter("email"));
        users.setAddress(request.getParameter("address"));
        String ins=dbJdbcOperations.insertDB(users);
        request.setAttribute("ins",ins);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("site2.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
