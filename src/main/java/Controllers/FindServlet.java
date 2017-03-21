package Controllers;
import DAO.StudentDAO;
import Models.StudentsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="findservlet", urlPatterns = "/findservlet")
public class FindServlet extends HttpServlet {

    private StudentDAO studentDAO;

    public FindServlet() {
        this.studentDAO = new StudentDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pib = request.getParameter("pib");

        List<StudentsEntity> studentsEntities = this.studentDAO.getAll();
        StudentsEntity res = null;
        for (StudentsEntity studentsEntity:studentsEntities) {
            if (studentsEntity.getPib().equals(pib)) {
                res = studentsEntity;
                break;
            }
        }


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (null != res) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Hostels</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + res.getPassportSeries() + res.getPassportNumber() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } finally {
            out.close();
        }
    }

}
