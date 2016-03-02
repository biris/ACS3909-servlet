package project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by owner_ on 2016-02-05.
 */

@WebServlet(name = "Controller", urlPatterns = {"Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        {

            final Cookie count = null;
            final Boolean[] found = {false};

            String address = "WEB-INF/selectView.jsp";
            HttpSession session = request.getSession();

            if (session.isNew()) {
                request.setAttribute("isNewUser?", true);
            } else {
                request.setAttribute("isNewUSer?", false);
            }


            Cookie cookie = project.Helpers.getCookie(request, "studentID");

//            Cookie cookie = Helpers.getCookie(request, "studentID");
            Map<String, Student> allStudents = DatabaseStuff.INSTANCE.getALlStudents();
            getServletContext().setAttribute("students", allStudents);


            if (request.getParameter("studentID") != null && project.Helpers.isValidID(request.getParameter("studentID"))) {
                cookie = new Cookie("studentID", request.getParameter("studentID"));
                cookie.setMaxAge(60 * 60 * 7 * 24);
                response.addCookie(cookie);
            }


            if (cookie !=null) {
                State state = new State();
                String stdID = cookie.getValue();
                state.setStudentID(stdID);
                request.setAttribute("state", state);

                if (project.Helpers.getParameterCheck(request, "submit").equals("submit")) {
                    allStudents.get(stdID).setSelected(Helpers.stringParameters(request, "selected"));
                    DatabaseStuff.INSTANCE.updateStudent(allStudents.get(stdID));

                }

                state.setSelctedStudents(allStudents.get(stdID).getSelected());
                state.setFilteredStudents(project.Helpers.filterStudents(allStudents.values(), stdID));
                state.setWhoSelected(project.Helpers.getWhoSelectedStudent(allStudents.values(), allStudents.get(stdID)));

                state.setName(allStudents.get(stdID).getName());

                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);

            } else {
                address = "WEB-INF/getIDView.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }


}
