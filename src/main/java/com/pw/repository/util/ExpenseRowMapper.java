package com.pw.repository.util;

import com.pw.model.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseRowMapper implements RowMapper<Expense> {
    @Override
    public Expense mapRow(ResultSet resultSet, int i) throws SQLException {
        Expense expense = new Expense();
        expense.setDate(resultSet.getTimestamp("date"));
        expense.setId(resultSet.getInt("id"));
        expense.setCategory(resultSet.getString("category"));
        expense.setName(resultSet.getString("name"));
        expense.setMoney(resultSet.getDouble("money"));
        return expense;
    }
}
