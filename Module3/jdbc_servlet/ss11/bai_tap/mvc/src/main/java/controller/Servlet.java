package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "Servlet", urlPatterns = "/produces")
public class Servlet extends HttpServlet {
    static IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "edit": {
                update(request, response);
                break;
            }
            case "create": {
                createNewProduct(request, response);
                break;
            }

        }
    }


    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message;
        Product product = createProduct(request, response);
        Map<String, String> map = productService.save(product);
        if (!map.isEmpty()) {
            message = "Cannot add new";
        } else {
            message = "add new successfully";
        }
        request.setAttribute("mess", message);
        request.setAttribute("product", new Product());
        request.getRequestDispatcher("views/formEdit.jsp").forward(request, response);
    }

    private Product createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String status = request.getParameter("status");
        String manufacturer = request.getParameter("manufcl-aturer");
        return new Product(id, name, price, status, manufacturer);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message;
        Product product = createProduct(request, response);
        boolean check = productService.update(product);
        if (check) {
            message = "Edit successfully";
        } else {
            message = "Cannot Edit";
        }
        request.setAttribute("mess", message);
        request.setAttribute("product", product);
        request.getRequestDispatcher("views/formEdit.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "display": {
                display(request, response);
                break;
            }
            case "edit": {
                formUpdate(request, response);
                break;
            }
            case "delete": {
                delete(request, response);
                break;
            }
            case "create": {
                createForm(request, response);
                break;
            }
            case "search": {
                searchByName(request, response);
            }

            case "getInfo": {
                getInfo(request, response);
            }
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = new ArrayList<>();
        String nameSearch = request.getParameter("nameSearch");
        list.add(productService.findByName(nameSearch));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/product.jsp");
        request.setAttribute("list", list);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("target", product);
        display(request, response);
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        request.setAttribute("product", product);
        request.setAttribute("link", "create");
        request.getRequestDispatcher("views/formEdit.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.removeById(id);
        display(request, response);
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        request.setAttribute("link", "edit");
        request.getRequestDispatcher("views/formEdit.jsp").forward(request, response);
    }

    private void display(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = productService.findAll();
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("/views/product.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
