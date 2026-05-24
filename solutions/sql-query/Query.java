/*
 * Query.java
 * 
 * This class demonstrates the **Builder Pattern** applied to a dynamic
 * SQL query generation system. It allows constructing SQL SELECT queries
 * in a flexible, readable, and maintainable way.
 * 
 * Scenario:
 * -----------
 * We are building a backend system that interacts with a database.
 * Different parts of the application need to generate SQL queries
 * dynamically depending on user input or business requirements.
 * 
 * Problem:
 * ----------
 * Building SQL queries manually using string concatenation causes:
 * - Poor readability
 * - High risk of syntax errors
 * - Difficult maintenance
 * - Hard-to-extend query logic
 * 
 * Using constructors for every combination of query parameters would lead to:
 * - Too many constructors
 * - Unclear parameter order
 * - Tight coupling between construction and representation
 * 
 * Solution:
 * ----------
 * Use the Builder Pattern to construct Query objects step by step.
 * This separates construction logic from the final object and provides:
 * - Fluent API using method chaining
 * - Immutable query objects after building
 * - Mandatory field enforcement (table name)
 * - Easy extension for future SQL features
 */

package QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Query class represents a SQL SELECT query.
 */
public class Query {

    // Mandatory field
    private final String tableName;

    // Optional fields
    private final List<String> columns;
    private final List<String> whereConditions;
    private final List<String> joins;
    private final String orderBy;
    private final int limit;

    /**
     * Private constructor called by Builder.
     * Only Builder can create Query objects.
     */
    private Query(Builder builder) {
        this.tableName = builder.tableName;
        this.columns = builder.columns;
        this.whereConditions = builder.whereConditions;
        this.joins = builder.joins;
        this.orderBy = builder.orderBy;
        this.limit = builder.limit;
    }

    // =======================
    // Getters (immutability)
    // =======================

    public String getTableName() {
        return tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<String> getWhereConditions() {
        return whereConditions;
    }

    public List<String> getJoins() {
        return joins;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public int getLimit() {
        return limit;
    }

    // =======================
    // Convert Query to SQL String
    // =======================

    /**
     * Generates the final SQL query string.
     *
     * @return SQL query
     */
    public String generateSQL() {

        StringBuilder sql = new StringBuilder();

        // SELECT
        sql.append("SELECT ");

        if (columns.isEmpty()) {
            sql.append("*");
        } else {
            sql.append(String.join(", ", columns));
        }

        // FROM
        sql.append(" FROM ").append(tableName);

        // JOIN
        for (String join : joins) {
            sql.append(" ").append(join);
        }

        // WHERE
        if (!whereConditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", whereConditions));
        }

        // ORDER BY
        if (!orderBy.isEmpty()) {
            sql.append(" ORDER BY ").append(orderBy);
        }

        // LIMIT
        if (limit > 0) {
            sql.append(" LIMIT ").append(limit);
        }

        return sql.toString();
    }

    // =======================
    // Builder Class
    // =======================

    public static class Builder {

        // Mandatory field
        private final String tableName;

        // Optional fields
        private List<String> columns = new ArrayList<>();
        private List<String> whereConditions = new ArrayList<>();
        private List<String> joins = new ArrayList<>();
        private String orderBy = "";
        private int limit = 0;

        /**
         * Builder constructor enforces mandatory table name.
         *
         * @param tableName Database table name
         */
        public Builder(String tableName) {

            if (tableName == null || tableName.isEmpty()) {
                throw new IllegalArgumentException("Table name is required");
            }

            this.tableName = tableName;
        }

        /**
         * Adds a column to SELECT.
         *
         * @param column Column name
         * @return Builder instance for chaining
         */
        public Builder selectColumn(String column) {
            columns.add(column);
            return this;
        }

        /**
         * Adds a WHERE condition.
         *
         * @param condition SQL condition
         * @return Builder instance for chaining
         */
        public Builder where(String condition) {
            whereConditions.add(condition);
            return this;
        }

        /**
         * Adds a JOIN clause.
         *
         * @param join SQL JOIN statement
         * @return Builder instance for chaining
         */
        public Builder join(String join) {
            joins.add(join);
            return this;
        }

        /**
         * Adds ORDER BY clause.
         *
         * @param orderBy ORDER BY statement
         * @return Builder instance for chaining
         */
        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Adds LIMIT clause.
         *
         * @param limit Maximum number of rows
         * @return Builder instance for chaining
         */
        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds and returns the final Query object.
         *
         * @return Constructed Query object
         */
        public Query build() {
            return new Query(this);
        }
    }
}
