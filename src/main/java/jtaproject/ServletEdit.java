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
 * Servlet update user for JTA module
 *
 */

@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet {

    @EJB
    DBOperations dbOperations;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id= Integer.parseInt(request.getParameter("id"));
        Users users=new Users();
        users.setName(request.getParameter("name"));
        users.setSurname(request.getParameter("surname"));
        users.setEmail(request.getParameter("email"));
        users.setAddress(request.getParameter("address"));
        String upd=dbOperations.update(id, users);
        request.setAttribute("upd",upd);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("site2.jsp");
        requestDispatcher.forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
