package servlets;

import func.Functions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "TabulationServlet", urlPatterns = {"/funcList", "/tabulation"}, loadOnStartup = 1)
public class TabulationServlet extends HttpServlet {
    private Functions functions = new Functions();
    private int index;
    private double min;
    private double max;
    private double delta;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        if (uri[uri.length - 1].equals("tabulation")) {
            try {
                tabulateFunction(request, response);
            } catch (Exception e) {
                sendError(e,request,response);
            }
        } else {
            listFunctions(request, response);
        }
    }

    private void sendError(Exception e,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("exc",e);
        request.getRequestDispatcher("exception.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       processRequest(request,response);
    }

    private void listFunctions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("functions", functions);
        request.getRequestDispatcher("table.jsp").forward(request, response);
    }

    private void tabulateFunction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] tabulation;
        String[] values;
        double newValue =0 ;
        try {
    index = Integer.valueOf(request.getParameter("index"));
    min = Double.valueOf(request.getParameter("min"));
    max = Double.valueOf(request.getParameter("max"));
    delta = Double.valueOf(request.getParameter("delta"));
    tabulation = new String[(int) Math.ceil((max - min) / delta) + 1];
    values = new String[(int) Math.ceil((max - min) / delta) + 1];

        }catch (Exception e){
    throw new Exception("Произошла ошибка обработки входных данных\n"+e.getMessage());
}
        int j=0;
        for (double i=min;i<=max;i+=delta){
            try {
                newValue=Math.round(i * 1000000) / 1000000d;
                tabulation[j] = String.valueOf(newValue);
                values[j] = String.valueOf(functions.getValueFromFunction(index - 1, newValue));
                j++;
            }catch (Exception e){
                throw new Exception(String.format("Ошибка в табуляции функции %s\n%s",String.format(functions.getFunctionFormattedNameAtIndex(index),newValue),e.getMessage()));
            }
        }
        request.setAttribute("tabulation",tabulation);
        request.setAttribute("values",values);
        request.setAttribute("functionName",functions.getFunctionNameAtIndex(index-1));
        request.getRequestDispatcher("tabulation.jsp").forward(request, response);

    }

}
