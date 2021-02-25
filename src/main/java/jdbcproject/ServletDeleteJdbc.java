package jdbcproject;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( "/ServletDeleteJdbc")
public class ServletDeleteJdbc extends HttpServlet {

    @Inject
    OperationsDb operationsDb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
            operationsDb.deleteDB(id);
        System.out.println(id);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);

    }
}
