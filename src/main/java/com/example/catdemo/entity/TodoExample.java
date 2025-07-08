package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
* 待办事项核心表 Example
*
* @author zhanhuibin
* @since 2025-03-24 17:16
*/
public class TodoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TodoExample() {
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

        public Criteria andTaskContentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTaskContentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTaskContentEqualTo(String value) {
            addCriterion("task_content =", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThan(String value) {
            addCriterion("task_content >", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThan(String value) {
            addCriterion("task_content <", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentLike(String value) {
            addCriterion("task_content like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotLike(String value) {
            addCriterion("task_content not like", value, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentIn(List<String> values) {
            addCriterion("task_content in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andTaskContentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "taskContent");
            return (Criteria) this;
        }

        public Criteria andCompletedIsNull() {
            addCriterion("completed is null");
            return (Criteria) this;
        }

        public Criteria andCompletedIsNotNull() {
            addCriterion("completed is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedEqualTo(Integer value) {
            addCriterion("completed =", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedNotEqualTo(Integer value) {
            addCriterion("completed <>", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedGreaterThan(Integer value) {
            addCriterion("completed >", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("completed >=", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedLessThan(Integer value) {
            addCriterion("completed <", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedLessThanOrEqualTo(Integer value) {
            addCriterion("completed <=", value, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedIn(List<Integer> values) {
            addCriterion("completed in", values, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedNotIn(List<Integer> values) {
            addCriterion("completed not in", values, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedBetween(Integer value1, Integer value2) {
            addCriterion("completed between", value1, value2, "completed");
            return (Criteria) this;
        }

        public Criteria andCompletedNotBetween(Integer value1, Integer value2) {
            addCriterion("completed not between", value1, value2, "completed");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNull() {
            addCriterion("due_date is null");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNotNull() {
            addCriterion("due_date is not null");
            return (Criteria) this;
        }

        public Criteria andDueDateEqualTo(Date value) {
            addCriterion("due_date =", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotEqualTo(Date value) {
            addCriterion("due_date <>", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThan(Date value) {
            addCriterion("due_date >", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("due_date >=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThan(Date value) {
            addCriterion("due_date <", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThanOrEqualTo(Date value) {
            addCriterion("due_date <=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateIn(List<Date> values) {
            addCriterion("due_date in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotIn(List<Date> values) {
            addCriterion("due_date not in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateBetween(Date value1, Date value2) {
            addCriterion("due_date between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotBetween(Date value1, Date value2) {
            addCriterion("due_date not between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdIsNull() {
            addCriterion("predecessor_id is null");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdIsNotNull() {
            addCriterion("predecessor_id is not null");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdEqualTo(Integer value) {
            addCriterion("predecessor_id =", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdNotEqualTo(Integer value) {
            addCriterion("predecessor_id <>", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdGreaterThan(Integer value) {
            addCriterion("predecessor_id >", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("predecessor_id >=", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdLessThan(Integer value) {
            addCriterion("predecessor_id <", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdLessThanOrEqualTo(Integer value) {
            addCriterion("predecessor_id <=", value, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdIn(List<Integer> values) {
            addCriterion("predecessor_id in", values, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdNotIn(List<Integer> values) {
            addCriterion("predecessor_id not in", values, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdBetween(Integer value1, Integer value2) {
            addCriterion("predecessor_id between", value1, value2, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andPredecessorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("predecessor_id not between", value1, value2, "predecessorId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingIsNull() {
            addCriterion("is_repeating is null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingIsNotNull() {
            addCriterion("is_repeating is not null");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingEqualTo(Integer value) {
            addCriterion("is_repeating =", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingNotEqualTo(Integer value) {
            addCriterion("is_repeating <>", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingGreaterThan(Integer value) {
            addCriterion("is_repeating >", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_repeating >=", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingLessThan(Integer value) {
            addCriterion("is_repeating <", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingLessThanOrEqualTo(Integer value) {
            addCriterion("is_repeating <=", value, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingIn(List<Integer> values) {
            addCriterion("is_repeating in", values, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingNotIn(List<Integer> values) {
            addCriterion("is_repeating not in", values, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingBetween(Integer value1, Integer value2) {
            addCriterion("is_repeating between", value1, value2, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andIsRepeatingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_repeating not between", value1, value2, "isRepeating");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternIsNull() {
            addCriterion("repeat_pattern is null");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternIsNotNull() {
            addCriterion("repeat_pattern is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternEqualTo(String value) {
            addCriterion("repeat_pattern =", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternNotEqualTo(String value) {
            addCriterion("repeat_pattern <>", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternGreaterThan(String value) {
            addCriterion("repeat_pattern >", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternGreaterThanOrEqualTo(String value) {
            addCriterion("repeat_pattern >=", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternLessThan(String value) {
            addCriterion("repeat_pattern <", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternLessThanOrEqualTo(String value) {
            addCriterion("repeat_pattern <=", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternLike(String value) {
            addCriterion("repeat_pattern like", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternNotLike(String value) {
            addCriterion("repeat_pattern not like", value, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternIn(List<String> values) {
            addCriterion("repeat_pattern in", values, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternNotIn(List<String> values) {
            addCriterion("repeat_pattern not in", values, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternBetween(String value1, String value2) {
            addCriterion("repeat_pattern between", value1, value2, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatPatternNotBetween(String value1, String value2) {
            addCriterion("repeat_pattern not between", value1, value2, "repeatPattern");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalIsNull() {
            addCriterion("repeat_interval is null");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalIsNotNull() {
            addCriterion("repeat_interval is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalEqualTo(Integer value) {
            addCriterion("repeat_interval =", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalNotEqualTo(Integer value) {
            addCriterion("repeat_interval <>", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalGreaterThan(Integer value) {
            addCriterion("repeat_interval >", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat_interval >=", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalLessThan(Integer value) {
            addCriterion("repeat_interval <", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("repeat_interval <=", value, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalIn(List<Integer> values) {
            addCriterion("repeat_interval in", values, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalNotIn(List<Integer> values) {
            addCriterion("repeat_interval not in", values, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalBetween(Integer value1, Integer value2) {
            addCriterion("repeat_interval between", value1, value2, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat_interval not between", value1, value2, "repeatInterval");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilIsNull() {
            addCriterion("repeat_until is null");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilIsNotNull() {
            addCriterion("repeat_until is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilEqualTo(Date value) {
            addCriterion("repeat_until =", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilNotEqualTo(Date value) {
            addCriterion("repeat_until <>", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilGreaterThan(Date value) {
            addCriterion("repeat_until >", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilGreaterThanOrEqualTo(Date value) {
            addCriterion("repeat_until >=", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilLessThan(Date value) {
            addCriterion("repeat_until <", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilLessThanOrEqualTo(Date value) {
            addCriterion("repeat_until <=", value, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilIn(List<Date> values) {
            addCriterion("repeat_until in", values, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilNotIn(List<Date> values) {
            addCriterion("repeat_until not in", values, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilBetween(Date value1, Date value2) {
            addCriterion("repeat_until between", value1, value2, "repeatUntil");
            return (Criteria) this;
        }

        public Criteria andRepeatUntilNotBetween(Date value1, Date value2) {
            addCriterion("repeat_until not between", value1, value2, "repeatUntil");
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
