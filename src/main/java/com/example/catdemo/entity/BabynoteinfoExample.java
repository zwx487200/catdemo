package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;

/**
* 宝宝记 Example
*
* @author zhanhuibin
* @since 2024-12-04 16:54
*/
public class BabynoteinfoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BabynoteinfoExample() {
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

        public Criteria andBabynoteidIsNull() {
            addCriterion("babyNoteId is null");
            return (Criteria) this;
        }

        public Criteria andBabynoteidIsNotNull() {
            addCriterion("babyNoteId is not null");
            return (Criteria) this;
        }

        public Criteria andBabynoteidEqualTo(String value) {
            addCriterion("babyNoteId =", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidNotEqualTo(String value) {
            addCriterion("babyNoteId <>", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidGreaterThan(String value) {
            addCriterion("babyNoteId >", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidGreaterThanOrEqualTo(String value) {
            addCriterion("babyNoteId >=", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidLessThan(String value) {
            addCriterion("babyNoteId <", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidLessThanOrEqualTo(String value) {
            addCriterion("babyNoteId <=", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidLike(String value) {
            addCriterion("babyNoteId like", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidNotLike(String value) {
            addCriterion("babyNoteId not like", value, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidIn(List<String> values) {
            addCriterion("babyNoteId in", values, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidNotIn(List<String> values) {
            addCriterion("babyNoteId not in", values, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidBetween(String value1, String value2) {
            addCriterion("babyNoteId between", value1, value2, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andBabynoteidNotBetween(String value1, String value2) {
            addCriterion("babyNoteId not between", value1, value2, "babynoteid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeIsNull() {
            addCriterion("babyNoteType is null");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeIsNotNull() {
            addCriterion("babyNoteType is not null");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeEqualTo(String value) {
            addCriterion("babyNoteType =", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeNotEqualTo(String value) {
            addCriterion("babyNoteType <>", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeGreaterThan(String value) {
            addCriterion("babyNoteType >", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeGreaterThanOrEqualTo(String value) {
            addCriterion("babyNoteType >=", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeLessThan(String value) {
            addCriterion("babyNoteType <", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeLessThanOrEqualTo(String value) {
            addCriterion("babyNoteType <=", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeLike(String value) {
            addCriterion("babyNoteType like", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeNotLike(String value) {
            addCriterion("babyNoteType not like", value, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeIn(List<String> values) {
            addCriterion("babyNoteType in", values, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeNotIn(List<String> values) {
            addCriterion("babyNoteType not in", values, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeBetween(String value1, String value2) {
            addCriterion("babyNoteType between", value1, value2, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotetypeNotBetween(String value1, String value2) {
            addCriterion("babyNoteType not between", value1, value2, "babynotetype");
            return (Criteria) this;
        }

        public Criteria andBabynotedateIsNull() {
            addCriterion("babyNoteDate is null");
            return (Criteria) this;
        }

        public Criteria andBabynotedateIsNotNull() {
            addCriterion("babyNoteDate is not null");
            return (Criteria) this;
        }

        public Criteria andBabynotedateEqualTo(Date value) {
            addCriterionForJDBCDate("babyNoteDate =", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("babyNoteDate <>", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateGreaterThan(Date value) {
            addCriterionForJDBCDate("babyNoteDate >", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("babyNoteDate >=", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateLessThan(Date value) {
            addCriterionForJDBCDate("babyNoteDate <", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("babyNoteDate <=", value, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateIn(List<Date> values) {
            addCriterionForJDBCDate("babyNoteDate in", values, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("babyNoteDate not in", values, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("babyNoteDate between", value1, value2, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("babyNoteDate not between", value1, value2, "babynotedate");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeIsNull() {
            addCriterion("babyNoteStartTime is null");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeIsNotNull() {
            addCriterion("babyNoteStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeEqualTo(Date value) {
            addCriterion("babyNoteStartTime =", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeNotEqualTo(Date value) {
            addCriterion("babyNoteStartTime <>", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeGreaterThan(Date value) {
            addCriterion("babyNoteStartTime >", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("babyNoteStartTime >=", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeLessThan(Date value) {
            addCriterion("babyNoteStartTime <", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeLessThanOrEqualTo(Date value) {
            addCriterion("babyNoteStartTime <=", value, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeIn(List<Date> values) {
            addCriterion("babyNoteStartTime in", values, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeNotIn(List<Date> values) {
            addCriterion("babyNoteStartTime not in", values, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeBetween(Date value1, Date value2) {
            addCriterion("babyNoteStartTime between", value1, value2, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynotestarttimeNotBetween(Date value1, Date value2) {
            addCriterion("babyNoteStartTime not between", value1, value2, "babynotestarttime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeIsNull() {
            addCriterion("babyNoteEndTime is null");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeIsNotNull() {
            addCriterion("babyNoteEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeEqualTo(Date value) {
            addCriterion("babyNoteEndTime =", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeNotEqualTo(Date value) {
            addCriterion("babyNoteEndTime <>", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeGreaterThan(Date value) {
            addCriterion("babyNoteEndTime >", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("babyNoteEndTime >=", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeLessThan(Date value) {
            addCriterion("babyNoteEndTime <", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeLessThanOrEqualTo(Date value) {
            addCriterion("babyNoteEndTime <=", value, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeIn(List<Date> values) {
            addCriterion("babyNoteEndTime in", values, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeNotIn(List<Date> values) {
            addCriterion("babyNoteEndTime not in", values, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeBetween(Date value1, Date value2) {
            addCriterion("babyNoteEndTime between", value1, value2, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynoteendtimeNotBetween(Date value1, Date value2) {
            addCriterion("babyNoteEndTime not between", value1, value2, "babynoteendtime");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentIsNull() {
            addCriterion("babyNoteContent is null");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentIsNotNull() {
            addCriterion("babyNoteContent is not null");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentEqualTo(String value) {
            addCriterion("babyNoteContent =", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentNotEqualTo(String value) {
            addCriterion("babyNoteContent <>", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentGreaterThan(String value) {
            addCriterion("babyNoteContent >", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentGreaterThanOrEqualTo(String value) {
            addCriterion("babyNoteContent >=", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentLessThan(String value) {
            addCriterion("babyNoteContent <", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentLessThanOrEqualTo(String value) {
            addCriterion("babyNoteContent <=", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentLike(String value) {
            addCriterion("babyNoteContent like", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentNotLike(String value) {
            addCriterion("babyNoteContent not like", value, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentIn(List<String> values) {
            addCriterion("babyNoteContent in", values, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentNotIn(List<String> values) {
            addCriterion("babyNoteContent not in", values, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentBetween(String value1, String value2) {
            addCriterion("babyNoteContent between", value1, value2, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotecontentNotBetween(String value1, String value2) {
            addCriterion("babyNoteContent not between", value1, value2, "babynotecontent");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusIsNull() {
            addCriterion("babyNoteStatus is null");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusIsNotNull() {
            addCriterion("babyNoteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusEqualTo(String value) {
            addCriterion("babyNoteStatus =", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusNotEqualTo(String value) {
            addCriterion("babyNoteStatus <>", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusGreaterThan(String value) {
            addCriterion("babyNoteStatus >", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusGreaterThanOrEqualTo(String value) {
            addCriterion("babyNoteStatus >=", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusLessThan(String value) {
            addCriterion("babyNoteStatus <", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusLessThanOrEqualTo(String value) {
            addCriterion("babyNoteStatus <=", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusLike(String value) {
            addCriterion("babyNoteStatus like", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusNotLike(String value) {
            addCriterion("babyNoteStatus not like", value, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusIn(List<String> values) {
            addCriterion("babyNoteStatus in", values, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusNotIn(List<String> values) {
            addCriterion("babyNoteStatus not in", values, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusBetween(String value1, String value2) {
            addCriterion("babyNoteStatus between", value1, value2, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynotestatusNotBetween(String value1, String value2) {
            addCriterion("babyNoteStatus not between", value1, value2, "babynotestatus");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkIsNull() {
            addCriterion("babyNoteRemark is null");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkIsNotNull() {
            addCriterion("babyNoteRemark is not null");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkEqualTo(Integer value) {
            addCriterion("babyNoteRemark =", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkNotEqualTo(Integer value) {
            addCriterion("babyNoteRemark <>", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkGreaterThan(Integer value) {
            addCriterion("babyNoteRemark >", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("babyNoteRemark >=", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkLessThan(Integer value) {
            addCriterion("babyNoteRemark <", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkLessThanOrEqualTo(Integer value) {
            addCriterion("babyNoteRemark <=", value, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkIn(List<Integer> values) {
            addCriterion("babyNoteRemark in", values, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkNotIn(List<Integer> values) {
            addCriterion("babyNoteRemark not in", values, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkBetween(Integer value1, Integer value2) {
            addCriterion("babyNoteRemark between", value1, value2, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabynoteremarkNotBetween(Integer value1, Integer value2) {
            addCriterion("babyNoteRemark not between", value1, value2, "babynoteremark");
            return (Criteria) this;
        }

        public Criteria andBabyidIsNull() {
            addCriterion("babyId is null");
            return (Criteria) this;
        }

        public Criteria andBabyidIsNotNull() {
            addCriterion("babyId is not null");
            return (Criteria) this;
        }

        public Criteria andBabyidEqualTo(String value) {
            addCriterion("babyId =", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidNotEqualTo(String value) {
            addCriterion("babyId <>", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidGreaterThan(String value) {
            addCriterion("babyId >", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidGreaterThanOrEqualTo(String value) {
            addCriterion("babyId >=", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidLessThan(String value) {
            addCriterion("babyId <", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidLessThanOrEqualTo(String value) {
            addCriterion("babyId <=", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidLike(String value) {
            addCriterion("babyId like", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidNotLike(String value) {
            addCriterion("babyId not like", value, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidIn(List<String> values) {
            addCriterion("babyId in", values, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidNotIn(List<String> values) {
            addCriterion("babyId not in", values, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidBetween(String value1, String value2) {
            addCriterion("babyId between", value1, value2, "babyid");
            return (Criteria) this;
        }

        public Criteria andBabyidNotBetween(String value1, String value2) {
            addCriterion("babyId not between", value1, value2, "babyid");
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
