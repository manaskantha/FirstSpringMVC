
package com.jdbc.dao;

import com.jdbc.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by manask on 04-03-2017.
 */
@Component
public class CircleImpl {

    private DataSource dataSource;

    JdbcTemplate jdbcTemplate;

//    public Circle getCircle(Long circleId){
//        Connection connection = null;
//        Circle circle = null;
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        try{
//            connection = dataSource.getConnection();
//            String sql = "select * from circle where circle_id = ?";
//            ps = connection.prepareStatement(sql);
//            ps.setLong(1, circleId);
//            rs = ps.executeQuery();
//            if(rs.next()){
//                circle = new Circle(circleId, rs.getString("circle_name"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                connection.close();
//                rs.close();
//                ps.close();
//            }catch (SQLException se){
//                se.printStackTrace();
//            }
//        }
//        return  circle;
//    }

    public int getCircleCount(){
        String sql = "select count(*) from circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String getCircleName(Long circleId){
        String sql = "select circle_name from circle where circle_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }

    public Circle getCircleById(Long circleid){
        String sql = "select * from circle where circle_id = ?";
        return jdbcTemplate.queryForObject(sql, new CircleMapper(), new Object[]{circleid});
    }

    private static final class CircleMapper implements RowMapper<Circle>{

        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getLong("circle_id"));
            circle.setName(resultSet.getString("circle_name"));
            return  circle;
        }
    }

    public List<Circle> getAllCircle(){
        String sql = "select * from circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    public void addCircle(Circle circle){
        String sql = "insert into circle(circle_id, circle_name) values(?, ?)";
        jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
