package controller;

import model.MatBang;
import model.TrangThai;
import model.VanPhong;
import service.IMatBangService;
import service.ITrangThaiService;
import service.IVanPhongService;
import service.impl.MatBangService;
import service.impl.TrangThaiService;
import service.impl.VanPhongService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "Servlet", urlPatterns = "/product")
public class Servlet extends HttpServlet {
    private IMatBangService<MatBang> iMatBangService = new MatBangService();
    private ITrangThaiService<TrangThai> iTrangThaiService = new TrangThaiService();
    private IVanPhongService<VanPhong>iVanPhongService = new VanPhongService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");
        switch (action) {
            case "delete": {
                deleteProduct(request, response);
                break;
            }
            case "create":{
                createProduct(request, response);
                break;
            }

        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String ma_mb = request.getParameter("ma_mb");
        int dien_tich = Integer.parseInt(request.getParameter("dien_tich"));
        int trang_thai = Integer.parseInt(request.getParameter("status"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        int van_phong = Integer.parseInt(request.getParameter("van_phong"));
        int gia = Integer.parseInt(request.getParameter("gia"));
        Date ngay_vao = Date.valueOf(request.getParameter("ngay_vao"));
        Date ngay_het = Date.valueOf(request.getParameter("ngay_het"));
        Map<String,String> mapError = iMatBangService.add(new MatBang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het));
        if (mapError.isEmpty()) {
            request.setAttribute("message", "Create Success!!!");
            showFormCreate(request, response);
            return;
        }
        request.setAttribute("message", "Create Fail !!!");
        request.setAttribute("error", mapError);
        showFormCreate(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        iMatBangService.delete(id);
        showUserList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("display");

        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "searchName":
//                searchName(request, response);
//                break;
            default:
                showUserList(request, response);
                break;

        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("target", new MatBang());
        request.setAttribute("trangThaiList", iTrangThaiService.findAll());
        request.setAttribute("vanPhongList", iVanPhongService.findAll());
//        List<VanPhong> vanPhongList = iVanPhongService.findAll();
//        List<TrangThai>trangThaiList = iTrangThaiService.findAll();
//        request.setAttribute("trangThaiList",trangThaiList);
//        request.setAttribute("vanPhongList",vanPhongList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/form.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");

        request.setAttribute("nameList", this.iMatBangService.findAll());
        request.setAttribute("trangThaiList", iTrangThaiService.findAll());
        request.setAttribute("vanPhongList", iVanPhongService.findAll());

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

