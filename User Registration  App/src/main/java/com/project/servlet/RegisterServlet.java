package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/RegisterServlet")



public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Result</title>");
            out.println("<style>");
           
            out.println("body "
            		+ "{ font-family: 'Arial', sans-serif; "
            		+ "background: green; margin: 0; "
            		+ "display: flex; justify-content: "
            		+ "center; align-items: center; "
            		+ "height: 100vh; }");
            out.println(".result-container { text-align: center; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='result-container'>");

            // Retrieve form parameters
            String userName = request.getParameter("user_name");
            String userPassword = request.getParameter("user_password");
            String userEmail = request.getParameter("user_email");
            String userGender = request.getParameter("user_gender");
            String userCourse = request.getParameter("user_course");
            String termsAgreed = request.getParameter("condition");

            // Check if terms are agreed
            if (termsAgreed != null && termsAgreed.equals("checked")) {
                // Display registration information
                out.println("<h2>Registration Successful!</h2>");
                out.println("<p>Name: " + userName + "</p>");
                out.println("<p>Password: " + userPassword + "</p>");
                out.println("<p>Email: " + userEmail + "</p>");
                out.println("<p>Gender: " + userGender + "</p>");
                out.println("<p>Course: " + userCourse + "</p>");
                
            } else {
                out.println("<h2>Registration Failed</h2>");
                out.println("<p>Please agree to the terms and conditions.</p>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
