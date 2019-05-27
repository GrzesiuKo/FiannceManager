package com.pw.repository;

import com.pw.model.Category;
import com.pw.repository.util.CategoriesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCategory(final String category) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO categories(name) values (?)", new String[]{"id"});
                ps.setString(1, category);

                return ps;
            }
        }, keyHolder);
        Number id = keyHolder.getKey();
        return;
    }

    public void deleteCategory(int id) {
        jdbcTemplate.update("delete from categories where id = ?", id);
    }
    public List<Category> getCategories() {
        List<Category> categories = jdbcTemplate.query("Select * from categories", new CategoriesRowMapper());
        return categories;
    }
}
