package download;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数文件名称
        String filename=request.getParameter("filename");
        System.out.println(filename);
        ServletContext servletContext=getServletContext();
        //设置content-type 头 文件的mime类型
        String mimeType=servletContext.getMimeType(filename);
        System.out.println(mimeType);
        response.setHeader("content-type",mimeType);
        //设置cointent-disposition 头
        String userAgent = request.getHeader("user-agent");
        String newFileName= DownLoadUtils.getFileName(userAgent,filename);
        response.setHeader("content-disposition","attachment;filename="+newFileName);

        //输入 输出 对接
        String realPath=servletContext.getRealPath("/WEB-INF/img/"+filename);
        System.out.println(realPath);
        FileInputStream fis = new FileInputStream(realPath);

        ServletOutputStream sos = response.getOutputStream();
        int len=-1;
        byte[]bys = new byte[1024];
        System.out.println("1");
        while ((len = fis.read(bys)) !=-1){

            sos.write(bys,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
