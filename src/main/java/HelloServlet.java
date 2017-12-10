import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    private String firstName;
    private String lastName;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ServletsUtil.RESPONSE_CONTENT_TYPE);
        PrintWriter printWriter = resp.getWriter();
        String title = "Using GET Method to Read Form Data";

        firstName = req.getParameter("first_name");
        lastName = req.getParameter("last_name");

        printWriter.println(generateResponse(title, firstName, lastName));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ServletsUtil.RESPONSE_CONTENT_TYPE);
        PrintWriter printWriter = resp.getWriter();
        String title = "Using POST Method to Read Form Data";

        firstName = req.getParameter("first_name");
        lastName = req.getParameter("last_name");

        printWriter.println(generateResponse(title, firstName, lastName));
    }

    private String generateResponse(String title, String firstName, String lastName) {
        return "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n" +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + firstName + "\n" +
                "  <li><b>Last Name</b>: "
                + lastName + "\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";
    }


}
