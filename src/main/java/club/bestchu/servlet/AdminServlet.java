package club.bestchu.servlet;

import club.bestchu.entity.Admin;
import club.bestchu.service.AdminService;
import club.bestchu.service.impl.AdminServiceImpl;
import club.bestchu.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bestchu on 2017/7/16.
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    private String uri;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String currPage = request.getParameter("currentPage");
            if(currPage == null || "".equals(currPage.trim()))
                currPage = "1";
            int currentPage = Integer.parseInt(currPage);
            PageBean<Admin> pageBean = new PageBean<Admin>();
            pageBean.setCurrentPage(currentPage);
            adminService.getAll(pageBean);
            request.setAttribute("pageBean", pageBean);
            uri = "/WEB-INF/list.jsp";
        }catch(Exception e){
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
