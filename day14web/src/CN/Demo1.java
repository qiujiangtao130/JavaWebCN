package CN;

import Domain.BOOK;
import Utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

@WebServlet("/dd1")
public class Demo1 extends HttpServlet {
    JdbcTemplate jdbcTemplate= new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //构建JDBCtemplate对象
       List<BOOK> list= jdbcTemplate.query("select*from book", new BeanPropertyRowMapper<>(BOOK.class));
        for (BOOK b: list
             ) {
         System.out.println(b.toString());

        }
    }
}
