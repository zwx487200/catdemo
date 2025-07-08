package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;

/**
*  Example
*
* @author zhanhuibin
* @since 2025-06-24 16:41
*/
public class TodoRepeatInstanceExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TodoRepeatInstanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTodoIdIsNull() {
            addCriterion("todo_id is null");
            return (Criteria) this;
        }

        public Criteria andTodoIdIsNotNull() {
            addCriterion("todo_id is not null");
            return (Criteria) this;
        }

        public Criteria andTodoIdEqualTo(String value) {
            addCriterion("todo_id =", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotEqualTo(String value) {
            addCriterion("todo_id <>", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdGreaterThan(String value) {
            addCriterion("todo_id >", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdGreaterThanOrEqualTo(String value) {
            addCriterion("todo_id >=", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdLessThan(String value) {
            addCriterion("todo_id <", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdLessThanOrEqualTo(String value) {
            addCriterion("todo_id <=", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdLike(String value) {
            addCriterion("todo_id like", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotLike(String value) {
            addCriterion("todo_id not like", value, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdIn(List<String> values) {
            addCriterion("todo_id in", values, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotIn(List<String> values) {
            addCriterion("todo_id not in", values, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdBetween(String value1, String value2) {
            addCriterion("todo_id between", value1, value2, "todoId");
            return (Criteria) this;
        }

        public Criteria andTodoIdNotBetween(String value1, String value2) {
            addCriterion("todo_id not between", value1, value2, "todoId");
            return (Criteria) this;
        }

        public Criteria andInstanceDateIsNull() {
            addCriterion("instance_date is null");
            return (Criteria) this;
        }

        public Criteria andInstanceDateIsNotNull() {
            addCriterion("instance_date is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceDateEqualTo(Date value) {
            addCriterionForJDBCDate("instance_date =", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("instance_date <>", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("instance_date >", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("instance_date >=", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateLessThan(Date value) {
            addCriterionForJDBCDate("instance_date <", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("instance_date <=", value, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateIn(List<Date> values) {
            addCriterionForJDBCDate("instance_date in", values, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("instance_date not in", values, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("instance_date between", value1, value2, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andInstanceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("instance_date not between", value1, value2, "instanceDate");
            return (Criteria) this;
        }

        public Criteria andIsDoneIsNull() {
            addCriterion("is_done is null");
            return (Criteria) this;
        }

        public Criteria andIsDoneIsNotNull() {
            addCriterion("is_done is not null");
            return (Criteria) this;
        }

        public Criteria andIsDoneEqualTo(Integer value) {
            addCriterion("is_done =", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotEqualTo(Integer value) {
            addCriterion("is_done <>", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThan(Integer value) {
            addCriterion("is_done >", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_done >=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThan(Integer value) {
            addCriterion("is_done <", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneLessThanOrEqualTo(Integer value) {
            addCriterion("is_done <=", value, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneIn(List<Integer> values) {
            addCriterion("is_done in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotIn(List<Integer> values) {
            addCriterion("is_done not in", values, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneBetween(Integer value1, Integer value2) {
            addCriterion("is_done between", value1, value2, "isDone");
            return (Criteria) this;
        }

        public Criteria andIsDoneNotBetween(Integer value1, Integer value2) {
            addCriterion("is_done not between", value1, value2, "isDone");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNull() {
            addCriterion("remind_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("remind_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Date value) {
            addCriterion("remind_time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Date value) {
            addCriterion("remind_time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Date value) {
            addCriterion("remind_time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remind_time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Date value) {
            addCriterion("remind_time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
            addCriterion("remind_time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Date> values) {
            addCriterion("remind_time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Date> values) {
            addCriterion("remind_time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Date value1, Date value2) {
            addCriterion("remind_time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
            addCriterion("remind_time not between", value1, value2, "remindTime");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

}
