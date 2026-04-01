package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

class ResultServletTest {

    private ResultServlet servlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private HttpSession session;
    private RequestDispatcher dispatcher;

    @BeforeEach
    void setUp() {
        servlet = new ResultServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void testDoGetForwardsToResultJsp() throws Exception {
        when(req.getRequestDispatcher("/WEB-INF/jsp/result.jsp")).thenReturn(dispatcher);

        servlet.doGet(req, resp);

        verify(dispatcher).forward(req, resp);
    }

    @Test
    void testDoPostInvalidatesSessionAndRedirects() throws Exception {
        when(req.getSession()).thenReturn(session);

        servlet.doPost(req, resp);

        verify(session).invalidate();
        verify(resp).sendRedirect("start");
    }
}