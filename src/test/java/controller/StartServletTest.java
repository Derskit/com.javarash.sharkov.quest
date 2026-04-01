package controller;

import model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StartServletTest {

    private StartServlet servlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        servlet = new StartServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void testDoGetForwardsToStartPage() throws Exception {
        when(req.getRequestDispatcher("/WEB-INF/jsp/start.jsp")).thenReturn(dispatcher);

        servlet.doGet(req, resp);

        verify(dispatcher).forward(req, resp);
    }

    @Test
    void testDoPostCreatesGameStateAndRedirects() throws Exception {
        when(req.getParameter("username")).thenReturn("testUser");
        when(req.getSession()).thenReturn(session);

        servlet.doPost(req, resp);

        verify(session).setAttribute(eq("game"), any(GameState.class));
        verify(resp).sendRedirect("game");
    }

    @Test
    void testGameStateValuesAfterPost() throws Exception {
        when(req.getParameter("username")).thenReturn("player1");
        when(req.getSession()).thenReturn(session);

        var captor = org.mockito.ArgumentCaptor.forClass(GameState.class);

        servlet.doPost(req, resp);

        verify(session).setAttribute(eq("game"), captor.capture());

        GameState state = captor.getValue();

        assertEquals("player1", state.getUsername());
        assertEquals(1, state.getCurrentScene());
        assertEquals(0, state.getSteps());
    }
}