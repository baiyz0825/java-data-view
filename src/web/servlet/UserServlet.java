package web.servlet;

import bean.User;
import service.imp.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户Servlet服务程序接口
 * @date 2021-12-08 22:45:46
 */
public class UserServlet extends BaseServlet {
    private static final UserServiceImpl userService = new UserServiceImpl();

    /**
     * Called by the server (via the <code>service</code> method) to
     * allow a servlet to handle a GET request.
     *
     * <p>Overriding this method to support a GET request also
     * automatically supports an HTTP HEAD request. A HEAD
     * request is a GET request that returns no body in the
     * response, only the request header fields.
     *
     * <p>When overriding this method, read the request data,
     * write the response headers, get the response's noBodyWriter or
     * output stream object, and finally, write the response data.
     * It's best to include content type and encoding. When using
     * a <code>PrintWriter</code> object to return the response,
     * set the content type before accessing the
     * <code>PrintWriter</code> object.
     *
     * <p>The servlet container must write the headers before
     * committing the response, because in HTTP the headers must be sent
     * before the response body.
     *
     * <p>Where possible, set the Content-Length header (with the
     * {@link ServletResponse#setContentLength} method),
     * to allow the servlet container to use a persistent connection
     * to return its response to the client, improving performance.
     * The content length is automatically set if the entire response fits
     * inside the response buffer.
     *
     * <p>When using HTTP 1.1 chunked encoding (which means that the response
     * has a Transfer-Encoding header), do not set the Content-Length header.
     *
     * <p>The GET method should be safe, that is, without
     * any side effects for which users are held responsible.
     * For example, most form queries have no side effects.
     * If a client request is intended to change stored data,
     * the request should use some other HTTP method.
     *
     * <p>The GET method should also be idempotent, meaning
     * that it can be safely repeated. Sometimes making a
     * method safe also makes it idempotent. For example,
     * repeating queries is both safe and idempotent, but
     * buying a product online or modifying data is neither
     * safe nor idempotent.
     *
     * <p>If the request is incorrectly formatted, <code>doGet</code>
     * returns an HTTP "Bad Request" message.
     *
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     * Called by the server (via the <code>service</code> method)
     * to allow a servlet to handle a POST request.
     * <p>
     * The HTTP POST method allows the client to send
     * data of unlimited length to the Web server a single time
     * and is useful when posting information such as
     * credit card numbers.
     *
     * <p>When overriding this method, read the request data,
     * write the response headers, get the response's noBodyWriter or output
     * stream object, and finally, write the response data. It's best
     * to include content type and encoding. When using a
     * <code>PrintWriter</code> object to return the response, set the
     * content type before accessing the <code>PrintWriter</code> object.
     *
     * <p>The servlet container must write the headers before committing the
     * response, because in HTTP the headers must be sent before the
     * response body.
     *
     * <p>Where possible, set the Content-Length header (with the
     * {@link ServletResponse#setContentLength} method),
     * to allow the servlet container to use a persistent connection
     * to return its response to the client, improving performance.
     * The content length is automatically set if the entire response fits
     * inside the response buffer.
     *
     * <p>When using HTTP 1.1 chunked encoding (which means that the response
     * has a Transfer-Encoding header), do not set the Content-Length header.
     *
     * <p>This method does not need to be either safe or idempotent.
     * Operations requested through POST can have side effects for
     * which the user can be held accountable, for example,
     * updating stored data or buying items online.
     *
     * <p>If the HTTP POST request is incorrectly formatted,
     * <code>doPost</code> returns an HTTP "Bad Request" message.
     *
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the request
     * @throws ServletException if the request for the POST
     *                          could not be handled
     * @see ServletOutputStream
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //captcha会将请求的验证码存入session域之中，在web.xml配置谷歌验证码servlet之后其在每次访问验证码servlet程序都会生成验证码，保存到session域之中
        String captcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        //获取到验证码之后应该删除session域中的验证码吗，防止用户重复请求数据，导致servlet过多响应
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        //获取用户发送而来的验证码
        String checkCode = req.getParameter("checkCode");
        //        System.out.println(req.getParameterMap());
        User user = WebUtils.gernerateBean(req.getParameterMap(), new User());
        //从数据库中查询是否存在指定用户名
        User verifyUser = userService.searchUserByName(user.getName());
        //System.out.println(user);
        if (checkCode != null && checkCode.equalsIgnoreCase(captcha)) {
            if (verifyUser != null) {
                //登陆成功，生成用户cookie保存用户名
                Cookie userCookie = new Cookie("userName", verifyUser.getName());
                //设置cookie最大生命周期
                userCookie.setMaxAge(30 * 60);
                //将cookie存储到resp中
                resp.addCookie(userCookie);
                //保存用户到session域之中（方便权限检查以及登陆信息的显示（页面切换时也可以显示，只要是访问一次也就是不关闭浏览器都应存在））
                session.setAttribute("user", verifyUser);
                //请求转发
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMsg", "用户名或密码错误！");
                req.setAttribute("userName", user.getName());
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMsg", "验证码错误！");
            req.setAttribute("userName", user.getName());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String captcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        String checkCode = req.getParameter("checkCode");
        User user = WebUtils.gernerateBean(req.getParameterMap(), new User());
        if (checkCode != null && checkCode.equalsIgnoreCase(captcha)) {
            if (userService.searchUserByName(user.getName()) != null) {
                req.setAttribute("username", user.getName());
                req.setAttribute("number", user.getNumber());
//                System.out.println(user.getNumber());
                req.setAttribute("errorMsg", "用户名已存在！");
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {
                userService.addUser(user);
                req.setAttribute("successMsg", user.getName());
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("username", user.getName());
            req.setAttribute("number", user.getNumber());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("errorMsg", "验证码错误！");
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }

    /**
     * @param req:
     * @param resp:
     * @Description: 添加用户注销功能
     * @Author: BaiYZ
     * @Date: 2021/12/13 23:38
     * @return: void
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除当前session域中保存的信息
        req.getSession().invalidate();
        //请求重定向清除所有session以及req中的信息3zx
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}