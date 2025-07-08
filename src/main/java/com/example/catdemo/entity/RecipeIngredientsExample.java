package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
* 食谱食材明细表 Example
*
* @author zhanhuibin
* @since 2025-06-03 17:31
*/
public class RecipeIngredientsExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecipeIngredientsExample() {
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

        public Criteria andIngredientIdIsNull() {
            addCriterion("ingredient_id is null");
            return (Criteria) this;
        }

        public Criteria andIngredientIdIsNotNull() {
            addCriterion("ingredient_id is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientIdEqualTo(String value) {
            addCriterion("ingredient_id =", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotEqualTo(String value) {
            addCriterion("ingredient_id <>", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdGreaterThan(String value) {
            addCriterion("ingredient_id >", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdGreaterThanOrEqualTo(String value) {
            addCriterion("ingredient_id >=", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdLessThan(String value) {
            addCriterion("ingredient_id <", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdLessThanOrEqualTo(String value) {
            addCriterion("ingredient_id <=", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdLike(String value) {
            addCriterion("ingredient_id like", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotLike(String value) {
            addCriterion("ingredient_id not like", value, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdIn(List<String> values) {
            addCriterion("ingredient_id in", values, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotIn(List<String> values) {
            addCriterion("ingredient_id not in", values, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdBetween(String value1, String value2) {
            addCriterion("ingredient_id between", value1, value2, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andIngredientIdNotBetween(String value1, String value2) {
            addCriterion("ingredient_id not between", value1, value2, "ingredientId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIsNull() {
            addCriterion("recipe_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIsNotNull() {
            addCriterion("recipe_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipeIdEqualTo(String value) {
            addCriterion("recipe_id =", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotEqualTo(String value) {
            addCriterion("recipe_id <>", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdGreaterThan(String value) {
            addCriterion("recipe_id >", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdGreaterThanOrEqualTo(String value) {
            addCriterion("recipe_id >=", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLessThan(String value) {
            addCriterion("recipe_id <", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLessThanOrEqualTo(String value) {
            addCriterion("recipe_id <=", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLike(String value) {
            addCriterion("recipe_id like", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotLike(String value) {
            addCriterion("recipe_id not like", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIn(List<String> values) {
            addCriterion("recipe_id in", values, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotIn(List<String> values) {
            addCriterion("recipe_id not in", values, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdBetween(String value1, String value2) {
            addCriterion("recipe_id between", value1, value2, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotBetween(String value1, String value2) {
            addCriterion("recipe_id not between", value1, value2, "recipeId");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIsNull() {
            addCriterion("ingredient_name is null");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIsNotNull() {
            addCriterion("ingredient_name is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientNameEqualTo(String value) {
            addCriterion("ingredient_name =", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotEqualTo(String value) {
            addCriterion("ingredient_name <>", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameGreaterThan(String value) {
            addCriterion("ingredient_name >", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameGreaterThanOrEqualTo(String value) {
            addCriterion("ingredient_name >=", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLessThan(String value) {
            addCriterion("ingredient_name <", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLessThanOrEqualTo(String value) {
            addCriterion("ingredient_name <=", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameLike(String value) {
            addCriterion("ingredient_name like", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotLike(String value) {
            addCriterion("ingredient_name not like", value, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameIn(List<String> values) {
            addCriterion("ingredient_name in", values, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotIn(List<String> values) {
            addCriterion("ingredient_name not in", values, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameBetween(String value1, String value2) {
            addCriterion("ingredient_name between", value1, value2, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientNameNotBetween(String value1, String value2) {
            addCriterion("ingredient_name not between", value1, value2, "ingredientName");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionIsNull() {
            addCriterion("ingredient_portion is null");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionIsNotNull() {
            addCriterion("ingredient_portion is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionEqualTo(String value) {
            addCriterion("ingredient_portion =", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionNotEqualTo(String value) {
            addCriterion("ingredient_portion <>", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionGreaterThan(String value) {
            addCriterion("ingredient_portion >", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionGreaterThanOrEqualTo(String value) {
            addCriterion("ingredient_portion >=", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionLessThan(String value) {
            addCriterion("ingredient_portion <", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionLessThanOrEqualTo(String value) {
            addCriterion("ingredient_portion <=", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionLike(String value) {
            addCriterion("ingredient_portion like", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionNotLike(String value) {
            addCriterion("ingredient_portion not like", value, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionIn(List<String> values) {
            addCriterion("ingredient_portion in", values, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionNotIn(List<String> values) {
            addCriterion("ingredient_portion not in", values, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionBetween(String value1, String value2) {
            addCriterion("ingredient_portion between", value1, value2, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andIngredientPortionNotBetween(String value1, String value2) {
            addCriterion("ingredient_portion not between", value1, value2, "ingredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceableIsNull() {
            addCriterion("replaceable is null");
            return (Criteria) this;
        }

        public Criteria andReplaceableIsNotNull() {
            addCriterion("replaceable is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceableEqualTo(Integer value) {
            addCriterion("replaceable =", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableNotEqualTo(Integer value) {
            addCriterion("replaceable <>", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableGreaterThan(Integer value) {
            addCriterion("replaceable >", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableGreaterThanOrEqualTo(Integer value) {
            addCriterion("replaceable >=", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableLessThan(Integer value) {
            addCriterion("replaceable <", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableLessThanOrEqualTo(Integer value) {
            addCriterion("replaceable <=", value, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableIn(List<Integer> values) {
            addCriterion("replaceable in", values, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableNotIn(List<Integer> values) {
            addCriterion("replaceable not in", values, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableBetween(Integer value1, Integer value2) {
            addCriterion("replaceable between", value1, value2, "replaceable");
            return (Criteria) this;
        }

        public Criteria andReplaceableNotBetween(Integer value1, Integer value2) {
            addCriterion("replaceable not between", value1, value2, "replaceable");
            return (Criteria) this;
        }

        public Criteria andOmissibleIsNull() {
            addCriterion("omissible is null");
            return (Criteria) this;
        }

        public Criteria andOmissibleIsNotNull() {
            addCriterion("omissible is not null");
            return (Criteria) this;
        }

        public Criteria andOmissibleEqualTo(Integer value) {
            addCriterion("omissible =", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleNotEqualTo(Integer value) {
            addCriterion("omissible <>", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleGreaterThan(Integer value) {
            addCriterion("omissible >", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("omissible >=", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleLessThan(Integer value) {
            addCriterion("omissible <", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleLessThanOrEqualTo(Integer value) {
            addCriterion("omissible <=", value, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleIn(List<Integer> values) {
            addCriterion("omissible in", values, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleNotIn(List<Integer> values) {
            addCriterion("omissible not in", values, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleBetween(Integer value1, Integer value2) {
            addCriterion("omissible between", value1, value2, "omissible");
            return (Criteria) this;
        }

        public Criteria andOmissibleNotBetween(Integer value1, Integer value2) {
            addCriterion("omissible not between", value1, value2, "omissible");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameIsNull() {
            addCriterion("replace_ingredient_name is null");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameIsNotNull() {
            addCriterion("replace_ingredient_name is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameEqualTo(String value) {
            addCriterion("replace_ingredient_name =", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameNotEqualTo(String value) {
            addCriterion("replace_ingredient_name <>", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameGreaterThan(String value) {
            addCriterion("replace_ingredient_name >", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameGreaterThanOrEqualTo(String value) {
            addCriterion("replace_ingredient_name >=", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameLessThan(String value) {
            addCriterion("replace_ingredient_name <", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameLessThanOrEqualTo(String value) {
            addCriterion("replace_ingredient_name <=", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameLike(String value) {
            addCriterion("replace_ingredient_name like", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameNotLike(String value) {
            addCriterion("replace_ingredient_name not like", value, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameIn(List<String> values) {
            addCriterion("replace_ingredient_name in", values, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameNotIn(List<String> values) {
            addCriterion("replace_ingredient_name not in", values, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameBetween(String value1, String value2) {
            addCriterion("replace_ingredient_name between", value1, value2, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientNameNotBetween(String value1, String value2) {
            addCriterion("replace_ingredient_name not between", value1, value2, "replaceIngredientName");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionIsNull() {
            addCriterion("replace_ingredient_portion is null");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionIsNotNull() {
            addCriterion("replace_ingredient_portion is not null");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionEqualTo(String value) {
            addCriterion("replace_ingredient_portion =", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionNotEqualTo(String value) {
            addCriterion("replace_ingredient_portion <>", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionGreaterThan(String value) {
            addCriterion("replace_ingredient_portion >", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionGreaterThanOrEqualTo(String value) {
            addCriterion("replace_ingredient_portion >=", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionLessThan(String value) {
            addCriterion("replace_ingredient_portion <", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionLessThanOrEqualTo(String value) {
            addCriterion("replace_ingredient_portion <=", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionLike(String value) {
            addCriterion("replace_ingredient_portion like", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionNotLike(String value) {
            addCriterion("replace_ingredient_portion not like", value, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionIn(List<String> values) {
            addCriterion("replace_ingredient_portion in", values, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionNotIn(List<String> values) {
            addCriterion("replace_ingredient_portion not in", values, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionBetween(String value1, String value2) {
            addCriterion("replace_ingredient_portion between", value1, value2, "replaceIngredientPortion");
            return (Criteria) this;
        }

        public Criteria andReplaceIngredientPortionNotBetween(String value1, String value2) {
            addCriterion("replace_ingredient_portion not between", value1, value2, "replaceIngredientPortion");
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
