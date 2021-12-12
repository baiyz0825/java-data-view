package web;

import bean.Book;
import bean.Page;
import service.imp.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 提供图书类业务处理方法
 * @date 2021-12-05 17:40:46
 */
public class BookServlet extends BaseServlet {
    private static final BookServiceImpl bookService = new BookServiceImpl();
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

    /**
     * @param req:
     * @param resp:
     * @Description: 查询全部期刊信息，直接返回List(一次查询，返回全部)
     * @Author: BaiYZ
     * @Date: 2021/12/9 8:38
     * @return: void
     */
    public void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //初始化服务类对象
//        BookServiceImpl bookService = new BookServiceImpl();
        //返回查询的books
        List<Book> books = bookService.searchBookAll();
        //存入req 域中
        req.setAttribute("books", books);
        //请求转发-"/"为解析到项目路径
        req.getRequestDispatcher("/pages/book/bookManage.jsp").forward(req, resp);
    }

    /**
     * @param req:
     * @param resp:
     * @Description: 删除图书，使用传回的ID进行删除
     * @Author: BaiYZ
     * @Date: 2021/12/9 8:38
     * @return: void
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BookServiceImpl bookService = new BookServiceImpl();
        String id = req.getParameter("id");//获取传入的参数
        String pageNo = req.getParameter("pageNo");
//        System.out.println(id);
        bookService.deleteBookById(id);
        //重定向返回图书列表(还是访问servlet填充图书信息)
//        System.out.println(req.getContextPath());
        //重定向返回页面。需要获取工程路径getContextPath()
        resp.sendRedirect(req.getContextPath() + "/book/bookServlet?action=pages&pageNo="+pageNo);
    }

    /**
     * @param req:
     * @param resp:
     * @Description: 查询分页服务
     * @Author: BaiYZ
     * @Date: 2021/12/9 8:40
     * @return: void
     */
    public void pages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseIntFromString(req.getParameter("pageNo"), Page.defaultPageNo);
        Integer pageSize = WebUtils.parseIntFromString(req.getParameter("pageSize"), Page.defaultPageSize);

        Page<Book> page = bookService.pages(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/book/bookManage.jsp").forward(req, resp);
    }

    /**
     * @param req:
     * @param resp:
     * @Description: 模糊检索生成分页
     * @Author: BaiYZ
     * @Date: 2021/12/12 1:22
     * @return: void
     */
    public void searchPages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.gernerateBean(req.getParameterMap(), new Book());
        System.out.println(book);
        Integer pageNo = WebUtils.parseIntFromString(req.getParameter("pageNo"), Page.defaultPageNo);
        Integer pageSize = WebUtils.parseIntFromString(req.getParameter("pageSize"), Page.defaultPageSize);
        Page<Book> searchBookPage = bookService.searchBookPage(book, pageNo, pageSize);
        req.setAttribute("page", searchBookPage);
        req.getRequestDispatcher("/pages/book/bookManage.jsp").forward(req, resp);
    }

    /**
     * @param req:
     * @param resp:
     * @Description: 添加期刊
     * @Author: BaiYZ
     * @Date: 2021/12/10 0:20
     * @return: void
     */
    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.gernerateBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
      /*  这里使用重定向的原因是因为，
        如果使用请求转发，这个时候还是一个请求request域中的数据依旧存在还是一次请求，并且在浏览器中使用F5进行刷新其还是会再次提交页面（默认提交最后一次请求）、
        也就是会导致多次向服务器发送插入请求*/
        resp.sendRedirect(req.getContextPath() + "/book/bookServlet?action=pages");
    }

    /**
     * @Description: 获取一个图书存入request用于回显
     * @Author: BaiYZ
     * @Date: 2021/12/10 0:57
     * @param req:
     * @param resp:
     * @return: void
     */
    public void getBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String number = req.getParameter("number");
        Book book = bookService.searchBookById(number);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/book/bookEdit.jsp").forward(req, resp);//一次请求，需要request域中值
    }
    /**
     * @Description: 更新图书，更新完成重定向回去
     * @Author: BaiYZ
     * @Date: 2021/12/10 0:57
     * @param req:
     * @param resp:
     * @return: void
     */
    public void updateBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Book book = WebUtils.gernerateBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/book/bookServlet?action=pages");//防止刷新重复提交
    }
}