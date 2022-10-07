package controller;

import model.BaiHoc;
import model.Module;
import service.impl.SubjectService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExampleServlet", value = "/example")
public class ExampleServlet extends HttpServlet {
    SubjectService subjectService = new SubjectService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "listSubject":
                listSubject(request, response);
                break;
            case "showCreateSubject":
                break;
            default:
               home(request, response);
        }
    }

    private void listSubject(HttpServletRequest request, HttpServletResponse response) {
        List<BaiHoc> baiHocList = subjectService.findAll();
        List<Module> moduleList = subjectService.findModule();
        request.setAttribute("list", baiHocList);
        request.setAttribute("module", moduleList);
        RequestDispatcher rq = request.getRequestDispatcher("view/bai_hoc/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rq = request.getRequestDispatcher("home/home.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "CreateSubject":
                break;
            case "deleteSubject":
                delete(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idRemove"));
        subjectService.deleteSubject(id);
        List<BaiHoc> baiHocList = subjectService.findAll();
        List<Module> moduleList = subjectService.findModule();
        request.setAttribute("list", baiHocList);
        request.setAttribute("module", moduleList);
        RequestDispatcher rq = request.getRequestDispatcher("view/bai_hoc/list.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
