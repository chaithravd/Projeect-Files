import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;


public class Sdatabase extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Connecting servlet";

        out.println("<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "1603");

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from tb1");
            while (rs.next()) {
                String name = rs.getString("Name");
                String subject = rs.getString("Subject");
                int id = rs.getInt("id");
                int sub_code = rs.getInt("sub_code");


                out.println("Name :" + name );
                out.println(", Subject :" + subject );
                out.println(", Id :"+ id );
                out.println(", Sub_Code :" + sub_code + "<br>");

            }
            out.println("</body></html>");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
