package jtaproject;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletGetAll")
public class ServletGetAll extends HttpServlet {

    @EJB
    DBOperations dbOperations;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Users> list= dbOperations.selectAll();
       request.setAttribute("list",list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
