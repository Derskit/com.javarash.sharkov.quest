package controller;

import model.GameState;
import model.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServletTest {

    private GameServlet servlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        servlet = new GameServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void testDoGetRedirectsIfNoSession() throws Exception {
        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(null);

        servlet.doGet(req, resp);

        verify(resp).sendRedirect("start");
    }

    @Test
    void testDoGetForwardsToGameJsp() throws Exception {
        GameState state = new GameState();
        state.setCurrentScene(1);
        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(state);
        when(req.getRequestDispatcher("/WEB-INF/jsp/game.jsp")).thenReturn(dispatcher);

        servlet.doGet(req, resp);

        ArgumentCaptor<Scene> captor = ArgumentCaptor.forClass(Scene.class);
        verify(req).setAttribute(eq("scene"), captor.capture());
        verify(dispatcher).forward(req, resp);

        assertEquals(1, captor.getValue().getId());
    }

    @Test
    void testDoPostVictory() throws IOException {
        GameState state = new GameState();
        state.setCurrentScene(4);
        state.setSteps(5);

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(state);
        when(req.getParameter("step")).thenReturn("0");

        servlet.doPost(req, resp);

        verify(resp).sendRedirect("result?win=true");
        assertEquals(6, state.getSteps());
    }

    @Test
    void testDoPostDeath() throws IOException {
        GameState state = new GameState();
        state.setCurrentScene(2);
        state.setSteps(2);

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(state);
        when(req.getParameter("step")).thenReturn("-1");

        servlet.doPost(req, resp);

        verify(resp).sendRedirect("result?win=false");
        assertEquals(3, state.getSteps());
    }

    @Test
    void testDoPostNextScene() throws IOException {
        GameState state = new GameState();
        state.setCurrentScene(1);
        state.setSteps(0);

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(state);
        when(req.getParameter("step")).thenReturn("2");

        servlet.doPost(req, resp);

        verify(resp).sendRedirect("game");
        assertEquals(2, state.getCurrentScene());
        assertEquals(1, state.getSteps());
    }
}