package Controllers;
import DAO.RoomDAO;
import DAO.StudentDAO;
import Models.RoomsEntity;
import Models.StudentsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="addservlet", urlPatterns = "/addservlet")
public class AddServlet extends HttpServlet {


    private RoomDAO roomDAO;
    private StudentDAO studentDAO;

    public AddServlet() {
        this.roomDAO = new RoomDAO();
        this.studentDAO = new StudentDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pib = request.getParameter("pib");
        Integer course = Integer.parseInt(request.getParameter("course"));
        String idcode = request.getParameter("idcode");
        String passportseries = request.getParameter("passportseries");
        String passportnumber = request.getParameter("passportnumber");

        List<RoomsEntity> roomsEntities = this.roomDAO.getAll();
        RoomsEntity roomsEntity = roomsEntities.get(0);
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setCourse(course);
        studentsEntity.setIdCode(idcode);
        studentsEntity.setPassportSeries(passportseries);
        studentsEntity.setPassportNumber(passportnumber);
        studentsEntity.setPib(pib);
        studentsEntity.setRoomsEntity(roomsEntity);
        this.studentDAO.add(studentsEntity);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hostels</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Student added</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
