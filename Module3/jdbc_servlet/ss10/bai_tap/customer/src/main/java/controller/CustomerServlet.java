package controller;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Mai Van hoan", "1983-08-20", "Ha Noi", "images/anh1.jpg"));
        customerList.add(new Customer("Nguyen Van Nam", "1983-08-21", "Sai Gon", "images/anh2.jpg"));
        customerList.add(new Customer("Nguyen Thai Hoa", "1983-08-22", "Da Nang", "images/anh3.jpg"));
        customerList.add(new Customer("Tran Dang Khoa", "1983-08-23", "Hue", "images/anh4.jpg"));
        customerList.add(new Customer("Nguyen Dinh Thi", "1983-08-24", "Nha Trang", "images/anh5.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("customer/customerlist.jsp").forward(request, response);
    }
}
