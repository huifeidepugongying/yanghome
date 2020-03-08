package travel.web.servlet;


import org.apache.commons.beanutils.BeanUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkCodeServer = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        String checkCode = request.getParameter("check");
        String username = request.getParameter("username");
        ResultInfo info = new ResultInfo(true, "注册成功");
        UserService service = new UserServiceImpl();
        if (StringUtil.isNullOrEmpty(checkCode)) {
            info.setFlag(false);
            info.setErrorMsg("验证码为空");
        } else if (!checkCode.toLowerCase().equals(checkCodeServer.toLowerCase())) {
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        } else if (StringUtil.isNullOrEmpty(username)) {
            info.setFlag(false);
            info.setErrorMsg("用户名不能为空");
        } else if (service.userIsExist(username)) {
            info.setFlag(false);
            info.setErrorMsg("用户名已经存在");
        }
        if (!info.isFlag()) {
            ResponseUtil.write(response, info);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
            service.saveUser(user);
        } catch (IllegalAccessException e) {
            info.setFlag(false);
            info.setErrorMsg(e.getMessage());
        } catch (InvocationTargetException e) {
            info.setFlag(false);
            info.setErrorMsg(e.getMessage());
        }
        ResponseUtil.write(response, info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
