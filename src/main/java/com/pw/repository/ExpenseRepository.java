package com.pw.repository;

import com.pw.model.Category;
import com.pw.model.Expense;
import com.pw.repository.util.CategoriesRowMapper;
import com.pw.repository.util.ExpenseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository("expenseRepository")
public class ExpenseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Expense addExpense(final Expense expense) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert INTO expenses(date, category, name, money) values (?,?,?,?)", new String[]{"id"});

                System.out.println("Dane: category "+expense.getCategory()+" name: "+expense.getName()+" money: "+expense.getMoney()+" datetime: "+expense.getDate());

                preparedStatement.setTimestamp(1, expense.getDate());

                preparedStatement.setString(2,expense.getCategory());
                preparedStatement.setString(3, expense.getName());
                preparedStatement.setDouble(4, expense.getMoney());

                return preparedStatement;
            }
        }, keyHolder);

        Number id = keyHolder.getKey();
        return expense;


    }

    public List<Expense> getExpenses() {
        List<Expense> expenses = jdbcTemplate.query("select * from expenses", new ExpenseRowMapper());
        return expenses;
    }

    public void deleteExpense(Integer id) {
        jdbcTemplate.update("delete from expenses where id = ?", id);
    }

    public Expense getExpense(Integer id) {
        Expense expense = jdbcTemplate.queryForObject("select * from expenses where id=?", new ExpenseRowMapper(), id);
        return expense;
    }

    public List<Category> getCategories() {
        List<Category> categories = jdbcTemplate.query("Select * from categories", new CategoriesRowMapper());
        return categories;
    }
}
