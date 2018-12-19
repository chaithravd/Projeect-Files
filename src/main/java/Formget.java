import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;


public class Formget extends HttpServlet{

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{


        Cookie firstname =new Cookie("first_name",request.getParameter("first_name"));
        Cookie lastname =new Cookie("last_name",request.getParameter("last_name"));

        //firstname.setMaxAge(60*60*24);
        //lastname.setMaxAge(60*60*24);

        response.addCookie(firstname);
        response.addCookie(lastname);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


/*


        Cookie ch[] = request.getCookies();
        out.print("Hello"+ch[0].getName());
*/

        String title ="Using Get method";

        String doctype ="<doctype html public \\\"-//w3c//dtd html 4.0 \" + \"transitional//en\">";

        out.println(doctype + "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + request.getParameter("first_name") + "\n" +
                "  <li><b>Last Name</b>: "
                + request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                "</body>" +
                "</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        try{
            doGet(request, response);
            String[] intersts = request.getParameterValues("Interests");
            pw.println("Your Interests are:");
                    for(int i=0;i<intersts.length;i++){
                        pw.println("<li>"+intersts[i]+"</li>");
                    }

        }
        finally {
            pw.println("Welcome!!!! Happy Shopping");
        }
    }
}