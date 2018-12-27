package cn.esw.springboot.dao;

import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class MailDaoImpl {

    /*
    将商品信息存入数据库  暂用jdbc
     */
    private static String insertmail = "INSERT INTO esw.mail (name,type,number,state,time,rank) VALUES (?, ?, ?,?,?,?) ";
    private static String selectSql = "select * from esw.mail where state = ?";
    private static String updateSql = "update  esw.mail set name = ? , type = ? ,state = ? ,time = ? ,rank=? where number = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMail(final Mail mail) {

        jdbcTemplate.update(insertmail,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, mail.getName());
                        ps.setInt(2, mail.getType());
                        ps.setString(3, mail.getNumber());
                        ps.setInt(4,mail.getState());
                        ps.setTimestamp(5,mail.getTimestamp());
                        ps.setInt(6,mail.getRank());
                    }

       });
    }
    public List<Mail> getState(int id) {
        try {
            List<Mail> list = jdbcTemplate.query(selectSql, new Object[] {id},new MailRowMapper());
            return list;
        } catch (Exception e) {

            throw e;
        }
    }

    public void upDate(Mail mail) {
        try {
            jdbcTemplate.update(updateSql,
                    new Object[] { mail.getName(),mail.getType(),mail.getState(),mail.getTimestamp(),mail.getRank(), mail.getNumber()});

        } catch (DataAccessException e) {
            throw e;
        }
    }

    private class MailRowMapper implements RowMapper<Mail>{


        @Override
        public Mail mapRow(ResultSet rs, int i) throws SQLException {
            Mail mail = new Mail();
            try {
                mail.setName(rs.getString("Name"));
                mail.setType(rs.getInt("Type"));
                mail.setNumber(rs.getString("Number"));
                mail.setState(rs.getInt("State"));
                mail.setTimestamp(rs.getTimestamp("time"));
                mail.setRank(rs.getInt("rank"));
                return mail;
            } catch (Exception ex) {
                return null;
            }
        }
    }

}
