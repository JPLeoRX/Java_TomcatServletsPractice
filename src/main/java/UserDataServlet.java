
import helpers.ServletsUtil;
import helpers.StringHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * In this example we obtain data from the input form and generate an output page
 */
public class UserDataServlet extends HttpServlet implements ServletsUtil {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(RESPONSE_CONTENT_TYPE);                             // Set the response message's MIME type
        PrintWriter out = resp.getWriter();                                     // Allocate a output writer to write the response message into the network socket

        // Obtain all the data
        String username = req.getParameter("username");                     // Retrieve the value of the query parameter "username" (from text field)
        String password = req.getParameter("password");                     // Retrieve the value of the query parameter "password" (from password field)
        String gender = req.getParameter("gender");                         // Retrieve the value of the query parameter "gender" (from radio button)
        String age = req.getParameter("age");                               // Retrieve the value of the query parameter "age" (from pull-down menu)
        String[] languages = req.getParameterValues("language");            // Retrieve the value of the query parameter "language" (from checkboxes). Multiple entries possible. Use getParameterValues() which returns an array of String.
        String instruction = req.getParameter("instruction");               // Retrieve the value of the query parameter "instruction" (from text area)
        String secret = req.getParameter("secret");                         // Retrieve the value of the query parameter "secret" (from hidden field)
        String params = StringHelper.getString(req.getParameterNames());       // Retrieve the parameters names

        // Read the output template
        String OUTPUT_FORM_FILENAME = getServletContext().getRealPath("user_data_form_output.html");
        String outputForm = new String(Files.readAllBytes(Paths.get(OUTPUT_FORM_FILENAME)));

        // Complete the output form
        outputForm = StringHelper.replace(outputForm,"@name", username);
        outputForm = StringHelper.replace(outputForm,"@password", password);
        outputForm = StringHelper.replace(outputForm,"@gender", gender);
        outputForm = StringHelper.replace(outputForm,"@age", age);
        outputForm = StringHelper.replace(outputForm,"@languages", StringHelper.getString(languages));
        outputForm = StringHelper.replace(outputForm,"@instruction", instruction);
        outputForm = StringHelper.replace(outputForm,"@secret", secret);
        outputForm = StringHelper.replace(outputForm,"@request_params", params);

        // Display the output form
        try {
            out.println(outputForm);
        }

        finally {
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}