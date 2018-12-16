package cn.esw.springboot.dao;

import cn.esw.springboot.model.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HandlerDaoImpl {
    //根据快递类型，查找空闲的小哥
    private static String selectName = "select name from esw.handler where type = ? ";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getName(int type) {
        try {
            String name = jdbcTemplate.queryForObject(selectName,String.class, new Object[]{type});
            return name;
        } catch (DataAccessException e) {

            throw e;
        }
    }

}
