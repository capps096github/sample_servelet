package com.cephas.sample_servelet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "formServlet", value = "/form-servlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the parameter from the request
        String selectedValue = request.getParameter("options");

        // writetr
        PrintWriter writer = response.getWriter();

        // sesssions
        HttpSession session = request.getSession();

        // cookies
        Cookie[] cookies = request.getCookies();

        // Send the response back to the user
        try {
            response.setContentType("text/html");

            // switch
            switch (selectedValue) {

                case "create_cookie":
                    createCookies(request, response);
                    break;
                case "check_if_cookie_exists":
                    checkIfCookieExists(cookies, writer);
                    break;
                case "remove_session_variables":
                    removeSessionVariables(session);
                    break;
                case "show_cookies_session_attributes":
                    showAttributes(request, response, writer, session, cookies);

                    break;

                default:
                    // create session
                    createSession(request, response, session);
                    break;
            }

            writer.println("<html><body>");
            writer.println("You Selected, " + selectedValue);
            writer.println("</body></html>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void createCookies(HttpServletRequest request, HttpServletResponse response) {
        // create cookie
        Cookie cookie = new Cookie("name", "cephas");
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
    }

    private void checkIfCookieExists(Cookie[] cookies, PrintWriter writer) {
        // check if cookie exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    writer.println("Cookie exists");
                }
            }
        } else {
            writer.println("Cookie does not exist");
        }
    }

    private void removeSessionVariables(HttpSession session) {
        // remove session variables
        session.removeAttribute("name");
        session.removeAttribute("age");
    }

    private void showAttributes(HttpServletRequest request, HttpServletResponse response, PrintWriter writer, HttpSession session, Cookie[] cookies) {
        // show session attributes
        writer.println("<html><body>");
        writer.println("<h1>Session Attributes</h1>");
        writer.println("<p>Name: " + session.getAttribute("name") + "</p>");
        writer.println("<p>Age: " + session.getAttribute("age") + "</p>");
        writer.println("<p>Cookies: " + Arrays.toString(cookies) + "</p>");
        writer.println("</body></html>");
    }

    private void createSession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // create session
        session.setAttribute("name", "cephas");
        session.setAttribute("age", "30");
    }

}
