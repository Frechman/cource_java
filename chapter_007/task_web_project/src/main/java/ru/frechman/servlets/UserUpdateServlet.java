package ru.frechman.servlets;

import ru.frechman.model.User;
import ru.frechman.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        User foundUser = validateService.findById(Long.valueOf(id));
        if (foundUser != null) {
            PrintWriter writer = resp.getWriter();
            String formUpdateUsers = "<form actions= " + req.getContextPath() + "/ method='post'>" +
                    "Name: <input type='text' name='name' value='" + foundUser.getName() + "'/></br>" +
                    "Login: <input type='text' name='login' value='" + foundUser.getLogin() + "'/></br>" +
                    "Email: <input type='text' name='email' value='" + foundUser.getEmail() + "'/></br>" +
                    "<input type='submit'/>" +
                    "</form>";
            writer.append(Utils.getPageHtml(formUpdateUsers));
            writer.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User updateUser = validateService.findById(Long.valueOf(id));
        if (updateUser != null) {
            updateUser.setLogin(login);
            updateUser.setName(name);
            updateUser.setEmail(email);
            boolean isUpdateUser = validateService.update(updateUser.getId(), updateUser);

            if (isUpdateUser) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                resp.sendRedirect(req.getContextPath() + "/list");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        }
    }
}