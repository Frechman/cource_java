package ru.frechman.servlets;

import ru.frechman.service.ValidateService;
import ru.frechman.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

//Presentation layout
public class UserServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    private final Map<String, Function<HttpServletRequest, Boolean>> actions = new ConcurrentHashMap<>();

    public static final String ADD = "add";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        validateService.findAll().forEach(user -> writer.append(user.toString()));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        initDispatch();
        actions.get(action).apply(req);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private Function<HttpServletRequest, Boolean> userAdd() {
        return req -> {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            User user = new User(name, login, email);
            return validateService.add(user) != null;
        };
    }

    private Function<HttpServletRequest, Boolean> userUpdate() {
        return req -> {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            Long id = Long.valueOf(req.getParameter("id"));
            User user = new User(name, login, email);
            return validateService.update(id, user);
        };
    }

    private Function<HttpServletRequest, Boolean> userDelete() {
        return req -> {
            Long id = Long.valueOf(req.getParameter("id"));
            return validateService.delete(id);
        };
    }

    private void initDispatch() {
        this.load(ADD, userAdd());
        this.load(UPDATE, userUpdate());
        this.load(DELETE, userDelete());
    }

    public void load(String action, Function<HttpServletRequest, Boolean> handler) {
        this.actions.put(action, handler);
    }
}