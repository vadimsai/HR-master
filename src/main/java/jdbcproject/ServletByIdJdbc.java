package jdbcproject;

import jtaproject.Users;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletByIdJdbc")
public class ServletByIdJdbc extends HttpServlet {
    @Inject
    DbJdbcOperations dbJdbcOperations;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // int id= Integer.parseInt(request.getParameter("id"));
       // List<String> list=dbJdbcOperations.getById(id);
       // System.out.println(id);
       // request.setAttribute("list",list);
        int id= Integer.parseInt(request.getParameter("id"));
        UserModel model=new UserModel();
        model.setId(id);
        List<UserJdbc> list= dbJdbcOperations.getall(id);
        model.setList(list);
        request.setAttribute("model",model);

    /*    HttpSession session = req.getSession();

        String resultString = calcResult(x, y, operation);

        ArrayList<String> operationsList;

        if (session.isNew()) {
            operationsList = new ArrayList<>();
        } else {
            operationsList = (ArrayList<String>) session.getAttribute("operationsList");
        }

        operationsList.add(resultString);
        session.setAttribute("operationsList", operationsList);
        session.setAttribute("sessionID",session.getId());*/



        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);
    }
}
