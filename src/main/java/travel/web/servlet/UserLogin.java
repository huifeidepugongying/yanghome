package travel.web.servlet;


import travel.domain.ResultInfo;
import travel.domain.User;
import travel.service.UserService;
import travel.service.impl.UserServiceImpl;
import travel.util.ResponseUtil;
import travel.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkServer = (String) session.getAttribute("CHECKCODE_SERVER");
        ResultInfo result = new ResultInfo(true, "登录成功");
        if (StringUtil.isNullOrEmpty(check)) {
            result.setErrorMsg("验证码为空");
            result.setFlag(false);
            ResponseUtil.write(response, result);

        } else if (!check.equals(checkServer)) {
            result.setErrorMsg("验证码错误");
            result.setFlag(false);
            ResponseUtil.write(response, result);
        }
        try {
            Method add = this.getClass().getDeclaredMethod("add", HttpServletRequest.class, HttpServletResponse.class);
            add.setAccessible(true);
//            Math.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (!result.isFlag()) return;
        UserService service = new UserServiceImpl();
        User user = service.getUser(userName, password);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("傻逼金和");
        response.getWriter().write("傻逼金和");
        response.getWriter().write(getServletContext().getRealPath("login.html"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
