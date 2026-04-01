package controller;

import model.GameState;
import model.Scene;
import service.SceneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GameState state = (GameState) req.getSession().getAttribute("game");
        if (state == null) {
            resp.sendRedirect("start");
            return;
        }

        Scene scene = SceneService.getScene(state.getCurrentScene());

        req.setAttribute("scene", scene);

        req.getRequestDispatcher("/WEB-INF/jsp/game.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        GameState state = (GameState) req.getSession().getAttribute("game");
        if (state == null) {
            resp.sendRedirect("start");
            return;
        }

        int nextId = Integer.parseInt(req.getParameter("step"));

        state.setSteps(state.getSteps() + 1);

        if (nextId == 0) {
            resp.sendRedirect("result?win=true");
            return;
        }

        if (nextId == -1) {
            resp.sendRedirect("result?win=false");
            return;
        }

        state.setCurrentScene(nextId);

        resp.sendRedirect("game");
    }
}
