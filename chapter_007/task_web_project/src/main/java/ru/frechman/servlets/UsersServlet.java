package ru.frechman.servlets;

import ru.frechman.model.User;
import ru.frechman.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//Presentation layout
public class UsersServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        List<User> users = validateService.findAll();
        StringBuilder htmlTableOfUser = new StringBuilder("<table class=\"table table-responsive w-75 .table-bordered" +
                "\">");
        htmlTableOfUser.append("<thead><tr><th>Users</th><th>Actions</th></tr></thead>")
                .append("<tbody>");
        for (User user : users) {
            htmlTableOfUser.append("<tr><td>").append(user.toString()).append("</td>")
                    //update
                    .append("<td>")
                    .append("<form action=\"" + req.getContextPath() + "/edit\" method=\"get\"><input type='hidden' name='id' value=\"" + user.getId() + "\"/></br>")
                    .append("<input type='submit' value='Edit' class=\"btn btn-primary\"/></form>")
                    //delete
                    .append("<form action=\"" + req.getContextPath() + "/delete\" method=\"post\"><input type='hidden' name='id' value=\"" + user.getId() + "\"/>")
                    .append("<input type='submit' value='Delete' class=\"btn btn-primary\"/></form>")
                    .append("</td></tr>");
        }
        htmlTableOfUser.append("</tbody></table>");

        writer.append(Utils.getPageHtml(htmlTableOfUser.toString()));
        writer.flush();
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}