package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Date;

/**
* 宠物基本信息表 Example
*
* @author zhanhuibin
* @since 2025-05-14 14:56
*/
public class PetInfoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetInfoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNull() {
            addCriterion("species is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNotNull() {
            addCriterion("species is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesEqualTo(String value) {
            addCriterion("species =", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotEqualTo(String value) {
            addCriterion("species <>", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThan(String value) {
            addCriterion("species >", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThanOrEqualTo(String value) {
            addCriterion("species >=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThan(String value) {
            addCriterion("species <", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThanOrEqualTo(String value) {
            addCriterion("species <=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLike(String value) {
            addCriterion("species like", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotLike(String value) {
            addCriterion("species not like", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesIn(List<String> values) {
            addCriterion("species in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotIn(List<String> values) {
            addCriterion("species not in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesBetween(String value1, String value2) {
            addCriterion("species between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotBetween(String value1, String value2) {
            addCriterion("species not between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andBreedIsNull() {
            addCriterion("breed is null");
            return (Criteria) this;
        }

        public Criteria andBreedIsNotNull() {
            addCriterion("breed is not null");
            return (Criteria) this;
        }

        public Criteria andBreedEqualTo(String value) {
            addCriterion("breed =", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotEqualTo(String value) {
            addCriterion("breed <>", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedGreaterThan(String value) {
            addCriterion("breed >", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedGreaterThanOrEqualTo(String value) {
            addCriterion("breed >=", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLessThan(String value) {
            addCriterion("breed <", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLessThanOrEqualTo(String value) {
            addCriterion("breed <=", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedLike(String value) {
            addCriterion("breed like", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotLike(String value) {
            addCriterion("breed not like", value, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedIn(List<String> values) {
            addCriterion("breed in", values, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotIn(List<String> values) {
            addCriterion("breed not in", values, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedBetween(String value1, String value2) {
            addCriterion("breed between", value1, value2, "breed");
            return (Criteria) this;
        }

        public Criteria andBreedNotBetween(String value1, String value2) {
            addCriterion("breed not between", value1, value2, "breed");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterionForJDBCDate("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterionForJDBCDate("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_id like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_id not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
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
