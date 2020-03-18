package WebServlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建图像对象
        int width = 100;
        int height=34;
        BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2美化图片
        Graphics g=image.getGraphics();
        g.setColor(Color.lightGray);
        g.fillRect(0,0,width,height);
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        String str="QWERTYUIOPASDFGHJKLZXCVBNM123456789";
        //String str="1";
        Random random=new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=4; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            sb.append(c);
            g.setColor(Color.BLUE);
            g.drawString(c+"",width/5*i,height/2);
        }
        String codeSession = sb.toString();
        req.getSession().setAttribute("codeSession",codeSession);
        //2.4画干扰线
        g.setColor(Color.cyan);
        for (int i = 0; i <10 ; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }

        //3输出图片到页面
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
