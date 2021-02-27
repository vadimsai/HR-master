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


    DbJdbcOperations dbJdbcOperations;

    @Override
    public void init() throws ServletException {
        dbJdbcOperations=new OperationsDb();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id= Integer.parseInt(request.getParameter("id"));
        Users users=new Users();
        users.setName(request.getParameter("name"));
        users.setSurname(request.getParameter("surname"));
        users.setBirthDate(request.getParameter("birthDate"));
        users.setAddress(request.getParameter("address"));
        dbJdbcOperations.updateDB(users, id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
