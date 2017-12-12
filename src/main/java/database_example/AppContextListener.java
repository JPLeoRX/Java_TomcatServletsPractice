package database_example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String dbURL = servletContext.getInitParameter(ContextParameters.DB_URL);
        String dbUser = servletContext.getInitParameter(ContextParameters.DB_USER);
        String dbPassword = servletContext.getInitParameter(ContextParameters.DB_PASSWORD);

        // Try to initialize database connection
        try {
            DBConnectionManager connectionManager = new DBConnectionManager(dbURL, dbUser, dbPassword);
            servletContext.setAttribute(ContextParameters.DB_CONNECTION, connectionManager.getConnection());
        }

        catch (SQLException e) {

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Connection con = (Connection) servletContext.getAttribute(ContextParameters.DB_CONNECTION);

        // Try to close database connection
        try {
            con.close();
        }

        catch (SQLException e) {

        }
    }
}
