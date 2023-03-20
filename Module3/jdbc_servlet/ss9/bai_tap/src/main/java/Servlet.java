import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet(name = "Servlet", value = "/myServlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String discount = request.getParameter("discount");
    double da = Double.parseDouble(price) * Double.parseDouble(discount) * 0.01;
    double total = Double.parseDouble(price) - da ;
//    String result = String.format("ten sp: %s, tien chiet khau:%.3f, tong tien:%.3f",name,da,total);
//    request.setAttribute("message",result);
//    request.getRequestDispatcher("index.jsp").forward(request,response);
    request.setAttribute("da",da);
    request.setAttribute("total",total);
    request.getRequestDispatcher("result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        switch (action) {
//            case "display": {
//                PrintWriter writer = response.getWriter();
//                writer.println("<html>");
//                Date today = new Date();
//                writer.println("<h1>" + today + "</h1>");
//                writer.println("</html>");
//                break;
//            }
//            case "name": {
//                PrintWriter writer = response.getWriter();
//                writer.println("<html>");
//                writer.println("<h1> NAME </h1>");
//                writer.println("</html>");
//                break;
//            }
//        }
    }
}
