import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Demoservlet extends HttpServlet {

    public String message;

    @Override
    public void init() throws ServletException {
        message ="Hello Everyone!!!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>"+message+"</h1>");

    }

    public void destoy(){

    }
}
