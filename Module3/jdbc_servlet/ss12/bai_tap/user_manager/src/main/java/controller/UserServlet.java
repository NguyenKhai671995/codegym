package controller;

import model.User;
import service.IUsersService;
import service.impl.UsersService;

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

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private IUsersService usersService = new UsersService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                // lấy dữ liêu và lưu vào db
                save(request, response);
                break;
            case "edit":
                editUser(request, response);
                // edit

                break;
            default:
        }

    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        String message;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        boolean check = usersService.update(user);
        if (check) {
            message = "Edit successfully";
        } else {
            message = "Cannot Edit";
        }
        request.setAttribute("mess", message);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("User/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void save(HttpServletRequest request, HttpServletResponse response) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            User user = new User(name, email, country);
            Map<String, String> map = usersService.add(user);
            String mess = "Add New successfully";
            if (!map.isEmpty()) {
                mess = "Them moi khong thanh cong";
                request.setAttribute("error", map);
            }
            request.setAttribute("mess", mess);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/create.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                // thêm mới
                break;

            case "delete":
                delete(request, response);
                showUserList(request, response);
                // xoá
                break;


            case "edit":
                showEditForm(request, response);
                break;

            case "search":
                searchIdForm(request, response);
                searchCountryForm(request, response);
                break;

            case "sort":
                sortByName(request, response);
                break;
            default:
                // trả về trang list
                showUserList(request, response);
        }
    }

    private void searchCountryForm(HttpServletRequest request, HttpServletResponse response) {
        String countrySearch = request.getParameter("countrySearch");
        List<User> list = usersService.findByCountry(countrySearch);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");
        request.setAttribute("userList", list);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = usersService.sortByName();
        request.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void searchIdForm(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = new ArrayList<>();
        int idSearch = Integer.parseInt(request.getParameter("idSearch"));
        list.add(usersService.findById(idSearch));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");
        request.setAttribute("userList", list);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = usersService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("User/edit.jsp");
        request.setAttribute("user", user);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        boolean check = usersService.delete(idDelete);
        String mess = "xoa thành công";
        if (!check) {
            mess = " xoá không thành công";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");
        request.setAttribute("userList", this.usersService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = usersService.findAll();
        request.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/create.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");
        request.setAttribute("userList", this.usersService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
