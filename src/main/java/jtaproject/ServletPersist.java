package jtaproject;

import interfaseanduser.DBOperations;
import interfaseanduser.Users;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@autor VADIM NOVIKOV
 * Servlet insert user for JTA module
 *
 */

@WebServlet("/ServletPersist")
public class ServletPersist extends HttpServlet {

    @EJB
    DBOperations dbOperations;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String pers=dbOperations.insert(new Users(name,surname,email,address));
        request.setAttribute("pers",pers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("site2.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
