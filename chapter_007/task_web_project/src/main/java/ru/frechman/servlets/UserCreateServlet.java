package ru.frechman.servlets;

import ru.frechman.model.User;
import ru.frechman.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String createForm = "<form actions= " + req.getContextPath() + "/ method='post'>" +
                "Name: <input type='text' name='name'/></br>" +
                "Login: <input type='text' name='login'/></br>" +
                "Email: <input type='text' name='email'/></br>" +
                "<input type='submit' class=\"btn btn-primary\"/>" +
                "</form>";
        writer.append(Utils.getPageHtml(createForm));
        writer.flush();
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User user = new User(login, name, email);

        User add = validateService.add(user);
        PrintWriter writer = resp.getWriter();
        if (add != null) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect(req.getContextPath() + "/list");
        } else {
            writer.append("<script type=\"text/javascript\">")
                    .append("alert('User not created!');")
                    .append("</script>");
        }
    }
}