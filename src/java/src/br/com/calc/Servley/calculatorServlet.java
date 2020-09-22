package src.br.com.calc.Servley;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandro
 */
@WebServlet(name = "calculatorServlet", urlPatterns = {"/calculatorServlet"})
public class calculatorServlet extends HttpServlet {
    
    private int totalAccess = 0;

    public calculatorServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        String svalorX = request.getParameter("valorX");
        String svalorY = request.getParameter("valorY");
        String soperacao = request.getParameter("operacao");
        
        double dvalorX = Double.parseDouble(svalorX);
        double dvalorY = Double.parseDouble(svalorY);
        double result = 0.0;
        
        processResponse(request, response, dvalorX, dvalorY, soperacao, result);
        
    }
    
    
    protected void processResponse(HttpServletRequest request, HttpServletResponse response,
            double valorX, double valorY, String operacao, double result)
            throws ServletException, IOException {
        
        if (operacao.equals("adicao")) {
            result = (valorX + valorY);
        }
        if (operacao.equals("subtracao")) {
            result = (valorX - valorY);
        }
        if (operacao.equals("multiplicacao")) {
            result = (valorX * valorY);
        }
        if (operacao.equals("divisao")) {
            result = (valorX / valorY);
        }
        
        totalAccess++;
        
        Cookie cookie = new Cookie("totalAccess", String.valueOf(totalAccess));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("calculatorResult.jsp").forward(request, response);
        
    }
}
