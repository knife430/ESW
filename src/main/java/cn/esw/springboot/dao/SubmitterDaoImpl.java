package cn.esw.springboot.dao;

import cn.esw.springboot.model.Mail;
import cn.esw.springboot.model.Submitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class SubmitterDaoImpl {
    private static String selectRank = "select rank from esw.submitter where name = ? ";
    private static String insertsql = "INSERT INTO esw.submitter (name,rank) VALUES (?, ?) ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getRank(String name) {
        try {
            int rank = jdbcTemplate.queryForObject(selectRank,int.class, new Object[]{name});
            return rank;
        } catch (DataAccessException e) {

            throw e;
        }
    }
    public void addSubmitter(final Submitter submitter) {

        jdbcTemplate.update(insertsql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, submitter.getName());
                        ps.setInt(2,submitter.getRank());
                    }

                });
    }
}
