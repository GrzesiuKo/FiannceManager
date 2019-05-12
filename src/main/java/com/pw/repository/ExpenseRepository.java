package com.pw.repository;

import com.pw.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("expenseRepository")
public class ExpenseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Expense addExpense(final Expense expense) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert INTO expenses(date, category, name, money) values (?,?,?,?,?)", new String[]{"id"});

                preparedStatement.setTimestamp(1, expense.getDate());

                preparedStatement.setString(2,expense.getCategory());
                preparedStatement.setString(3, expense.getName());
                preparedStatement.setDouble(4, expense.getMoney());

                return preparedStatement;
            }
        });

        return null;
    }
}
