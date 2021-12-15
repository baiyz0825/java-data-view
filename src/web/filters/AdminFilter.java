package web.filters;

import bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 用户权限过滤器
 * @date 2021-12-13 23:07:29
 */
public class AdminFilter implements Filter {
    /**
     * Called by the web container to indicate to a filter that it is being
     * placed into service. The servlet container calls the init method exactly
     * once after instantiating the filter. The init method must complete
     * successfully before the filter is asked to do any filtering work.
     * <p>
     * The web container cannot place the filter into service if the init method
     * either:
     * <ul>
     * <li>Throws a ServletException</li>
     * <li>Does not return within a time period defined by the web
     *     container</li>
     * </ul>
     * The default implementation is a NO-OP.
     *
     * @param filterConfig The configuration information associated with the
     *                     filter instance being initialised
     * @throws ServletException if the initialisation fails
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    /**
     * @param request:  ServletRequest最大父接口
     * @param response: ServletResponse最大父接口
     * @param chain:    FilterChain
     * @Description: 实现过滤器功能，过滤不是管理员不能访问系统资源
     * @Author: BaiYZ
     * @Date: 2021/12/13 23:18
     * @return: void
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强制转换对象到HttpServletRequest(是ServletRequest的子类)
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //获取域中存储的用户信息
        User verityUser = (User) httpServletRequest.getSession().getAttribute("user");
        //没登陆直接退出
        if (verityUser == null) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
        //登陆后判断是否存在权限
        if (verityUser != null && verityUser.getAdmin() == 1) {
            //存在用户并且权限完整过滤放行
            chain.doFilter(request, response);
        } else {
            //权限不够拦截
            httpServletRequest.getRequestDispatcher("/pages/common/adminAttention.html").forward(request, response);
        }
    }

    /**
     * Called by the web container to indicate to a filter that it is being
     * taken out of service. This method is only called once all threads within
     * the filter's doFilter method have exited or after a timeout period has
     * passed. After the web container calls this method, it will not call the
     * doFilter method again on this instance of the filter. <br>
     * <br>
     * <p>
     * This method gives the filter an opportunity to clean up any resources
     * that are being held (for example, memory, file handles, threads) and make
     * sure that any persistent state is synchronized with the filter's current
     * state in memory.
     * <p>
     * The default implementation is a NO-OP.
     */
    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}