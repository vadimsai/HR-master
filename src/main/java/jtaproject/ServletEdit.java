package jtaproject;

import jtaproject.Users;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet {

    @EJB
    DBOperations dbOperations;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String birthDate= request.getParameter("birthDate");
        String address=request.getParameter("address");
        dbOperations.merge(id,name, surname, birthDate, address);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DB.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


     //   dbOperations.persist(new Users("VadimchikSAIRAM", "Novikov", "17.06.1984", "AUM", "170684", "Maykop", "I am good", "@vad"));
     //   dbOperations.selectAll();
     //   dbOperations.remove(21);



    }
}
