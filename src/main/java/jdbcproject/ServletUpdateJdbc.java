package jdbcproject;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletUpdateJdbc")
public class ServletUpdateJdbc extends HttpServlet {
    @Inject
    OperationsDb operationsDb;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String birthDate= request.getParameter("birthDate");
        String address=request.getParameter("address");
        operationsDb.updateDB(id,name, surname, birthDate, address);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
