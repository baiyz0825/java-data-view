package web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import web.servlet.BaseServlet;

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
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用隐藏域判断上传的是用户头像还是图书照片


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
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString("UTF-8"));
                    } else {
                        //获取表单项的值
                        System.out.println(fileItem.getFieldName());
                        //获取文件名
                        System.out.println(fileItem.getName());
                        //输出文件进行保存
                        try {
                            //获取后缀名称
                            String filename = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                            //拼接文件名称
                            System.out.println(filename);
                            fileItem.write(new File("e:\\javadataviewTest\\" + filename));
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
    }
}