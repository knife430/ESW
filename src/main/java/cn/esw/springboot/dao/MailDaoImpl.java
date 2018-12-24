package cn.esw.springboot.dao;

import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MailDaoImpl {

    /*
    将商品信息存入数据库  暂用jdbc
     */
    private static String insertmail = "INSERT INTO esw.mail (name,type,number) VALUES (?, ?, ?) ";
    private static String selectSql = "select * from esw.handler where type = ?";
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
    public List<Mail> getId(int id) {
        try {
            List<Mail> list = jdbcTemplate.query(selectSql, new Object[] {id},new MaillRowMapper());
            return list;
        } catch (Exception e) {

            throw e;
        }
    }








    private class MaillRowMapper implements RowMapper<Mail>{


        @Override
        public Mail mapRow(ResultSet rs, int i) throws SQLException {
            Mail mail = null;
            try {

                mail.setName(rs.getString("Name"));
                mail.setType(rs.getInt("Type"));
                mail.setNumber(rs.getInt("Number"));
                mail.setState(rs.getInt("State"));
                return mail;
            } catch (Exception ex) {
                return null;
            }
        }
    }

}
