package cn.esw.springboot.dao;

import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository
public class MailDaoImpl {

    /*
    将商品信息存入数据库  暂用jdbc
     */
    private static String insertmail = "INSERT INTO esw.mail (name,type,number) VALUES (?, ?, ?) ";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMail(final Mail mail) {

        jdbcTemplate.update(insertmail,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, mail.getName());
                        ps.setInt(2, mail.getType());
                        ps.setInt(3, mail.getNumber());
                    }

       });
    }

}
