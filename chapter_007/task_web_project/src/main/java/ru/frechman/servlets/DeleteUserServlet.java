package ru.frechman.servlets;

import ru.frechman.service.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        boolean isDeleteUser = validateService.delete(Long.valueOf(userId));
        if (isDeleteUser) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect(req.getContextPath() + "/list");
        }
    }
}