package jdbcproject;

import interfaseanduser.DBOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@autor VADIM NOVIKOV
 * Servlet delete user for JDBC module
 *
 */

@WebServlet( "/ServletDeleteJdbc")
public class ServletDeleteJdbc extends HttpServlet {


    DBOperations dbOperations;

    @Override
    public void init() throws ServletException {
        dbOperations=new OperationsDb();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String del=dbOperations.remove(id);
        request.setAttribute("del",del);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("site2.jsp");
        requestDispatcher.forward(request, response);

    }
}
