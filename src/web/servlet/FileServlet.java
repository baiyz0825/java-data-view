package web.servlet;

import bean.Book;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.imp.BookServiceImpl;
import utils.FilelUtils;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author BaiYZ
 * @program JavaDataView
 * @description 处理文件上传的Servlet程序
 * @date 2021-12-14 14:06:31
 */
public class FileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移出提交保留的参数
        req.removeAttribute("BookImg");
        //判断上传的数据是否是多段的，如果是多段的才进行上传
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建文件信息工厂类，使用其磁盘信息工厂类的子类进行实现
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建ServletUpload文件上传类，使用disk工厂类进行创建
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                //解析数据
                //获取上传的多段数据的List集合
                List<FileItem> list = servletFileUpload.parseRequest(req);
                String number = null;
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println(fileItem.getFieldName());
                        number = fileItem.getString("UTF-8");
                        System.out.println(number);
                    } else {
                        //获取表单项的值
                        System.out.println(fileItem.getFieldName());
                        //获取文件名
                        System.out.println(fileItem.getName());
                        //输出文件进行保存
                        try {
                            //获取后缀名称
                            String filename = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                            //获取存盘路径
                            String StoreRootPath = FilelUtils.getSavePath();
                            //设置写入路径
                            String ImgPath = "\\Img\\Book";
                            String randomUUID = WebUtils.getUUID();
                            filename = randomUUID + filename;
                            String finalName = StoreRootPath + ImgPath + "\\" + filename;
                            //配置相对路径存入数据库
                            String relativeFilePath = "BookImg/" + filename;
                            //输出到文件夹中
                            System.out.println("输出的目标文件名称为：" + finalName);
                            File output = new File(finalName);
                            fileItem.write(output);
                            //地址存入数据库
                            BookServiceImpl bookService = new BookServiceImpl();
                            if (number != null) {
                                Book book = bookService.searchBookById(number);
                                book.setSrc(relativeFilePath);
                                book.setAuthor("我是利辛县");
                                bookService.updateBook(book);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            //判断是否为普通表单
            //是的话输出
            //不是的话进行存储
        }
        //重定向回上传成功页面
        resp.sendRedirect(req.getContextPath() + "/pages/adminManager/uploadSuccess.html");//防止刷新重复提交
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}