package jdbcproject;

import interfaseanduser.DBOperations;
import interfaseanduser.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *@autor VADIM NOVIKOV
 * Servlet get user by id for JDBC module
 *
 */

@WebServlet("/ServletByIdJdbc")
public class ServletByIdJdbc extends HttpServlet {

    DBOperations dbOperations;

    @Override
    public void init() throws ServletException {
        dbOperations=new OperationsDb();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        List<Users> listji= dbOperations.getById(id);
        request.setAttribute("listji",listji);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("site2.jsp");
        requestDispatcher.forward(request, response);
    }
}
