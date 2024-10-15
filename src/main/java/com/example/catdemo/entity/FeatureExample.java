package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

/**
* 功能表 Example
*
* @author zhanhuibin
* @since 2025-02-18 09:54
*/
public class FeatureExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeatureExample() {
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

        public Criteria andFeatureIdIsNull() {
            addCriterion("feature_id is null");
            return (Criteria) this;
        }

        public Criteria andFeatureIdIsNotNull() {
            addCriterion("feature_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureIdEqualTo(String value) {
            addCriterion("feature_id =", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotEqualTo(String value) {
            addCriterion("feature_id <>", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdGreaterThan(String value) {
            addCriterion("feature_id >", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdGreaterThanOrEqualTo(String value) {
            addCriterion("feature_id >=", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLessThan(String value) {
            addCriterion("feature_id <", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLessThanOrEqualTo(String value) {
            addCriterion("feature_id <=", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLike(String value) {
            addCriterion("feature_id like", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotLike(String value) {
            addCriterion("feature_id not like", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdIn(List<String> values) {
            addCriterion("feature_id in", values, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotIn(List<String> values) {
            addCriterion("feature_id not in", values, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdBetween(String value1, String value2) {
            addCriterion("feature_id between", value1, value2, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotBetween(String value1, String value2) {
            addCriterion("feature_id not between", value1, value2, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhIsNull() {
            addCriterion("feature_title_zh is null");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhIsNotNull() {
            addCriterion("feature_title_zh is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhEqualTo(String value) {
            addCriterion("feature_title_zh =", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhNotEqualTo(String value) {
            addCriterion("feature_title_zh <>", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhGreaterThan(String value) {
            addCriterion("feature_title_zh >", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhGreaterThanOrEqualTo(String value) {
            addCriterion("feature_title_zh >=", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhLessThan(String value) {
            addCriterion("feature_title_zh <", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhLessThanOrEqualTo(String value) {
            addCriterion("feature_title_zh <=", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhLike(String value) {
            addCriterion("feature_title_zh like", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhNotLike(String value) {
            addCriterion("feature_title_zh not like", value, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhIn(List<String> values) {
            addCriterion("feature_title_zh in", values, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhNotIn(List<String> values) {
            addCriterion("feature_title_zh not in", values, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhBetween(String value1, String value2) {
            addCriterion("feature_title_zh between", value1, value2, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleZhNotBetween(String value1, String value2) {
            addCriterion("feature_title_zh not between", value1, value2, "featureTitleZh");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnIsNull() {
            addCriterion("feature_title_en is null");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnIsNotNull() {
            addCriterion("feature_title_en is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnEqualTo(String value) {
            addCriterion("feature_title_en =", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnNotEqualTo(String value) {
            addCriterion("feature_title_en <>", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnGreaterThan(String value) {
            addCriterion("feature_title_en >", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnGreaterThanOrEqualTo(String value) {
            addCriterion("feature_title_en >=", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnLessThan(String value) {
            addCriterion("feature_title_en <", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnLessThanOrEqualTo(String value) {
            addCriterion("feature_title_en <=", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnLike(String value) {
            addCriterion("feature_title_en like", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnNotLike(String value) {
            addCriterion("feature_title_en not like", value, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnIn(List<String> values) {
            addCriterion("feature_title_en in", values, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnNotIn(List<String> values) {
            addCriterion("feature_title_en not in", values, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnBetween(String value1, String value2) {
            addCriterion("feature_title_en between", value1, value2, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureTitleEnNotBetween(String value1, String value2) {
            addCriterion("feature_title_en not between", value1, value2, "featureTitleEn");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlIsNull() {
            addCriterion("feature_url is null");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlIsNotNull() {
            addCriterion("feature_url is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlEqualTo(String value) {
            addCriterion("feature_url =", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlNotEqualTo(String value) {
            addCriterion("feature_url <>", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlGreaterThan(String value) {
            addCriterion("feature_url >", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("feature_url >=", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlLessThan(String value) {
            addCriterion("feature_url <", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlLessThanOrEqualTo(String value) {
            addCriterion("feature_url <=", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlLike(String value) {
            addCriterion("feature_url like", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlNotLike(String value) {
            addCriterion("feature_url not like", value, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlIn(List<String> values) {
            addCriterion("feature_url in", values, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlNotIn(List<String> values) {
            addCriterion("feature_url not in", values, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlBetween(String value1, String value2) {
            addCriterion("feature_url between", value1, value2, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andFeatureUrlNotBetween(String value1, String value2) {
            addCriterion("feature_url not between", value1, value2, "featureUrl");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionIsNull() {
            addCriterion("requires_subscription is null");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionIsNotNull() {
            addCriterion("requires_subscription is not null");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionEqualTo(Integer value) {
            addCriterion("requires_subscription =", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionNotEqualTo(Integer value) {
            addCriterion("requires_subscription <>", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionGreaterThan(Integer value) {
            addCriterion("requires_subscription >", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("requires_subscription >=", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionLessThan(Integer value) {
            addCriterion("requires_subscription <", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionLessThanOrEqualTo(Integer value) {
            addCriterion("requires_subscription <=", value, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionIn(List<Integer> values) {
            addCriterion("requires_subscription in", values, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionNotIn(List<Integer> values) {
            addCriterion("requires_subscription not in", values, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionBetween(Integer value1, Integer value2) {
            addCriterion("requires_subscription between", value1, value2, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andRequiresSubscriptionNotBetween(Integer value1, Integer value2) {
            addCriterion("requires_subscription not between", value1, value2, "requiresSubscription");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceIsNull() {
            addCriterion("seven_days_subscription_price is null");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceIsNotNull() {
            addCriterion("seven_days_subscription_price is not null");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceEqualTo(BigDecimal value) {
            addCriterion("seven_days_subscription_price =", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceNotEqualTo(BigDecimal value) {
            addCriterion("seven_days_subscription_price <>", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceGreaterThan(BigDecimal value) {
            addCriterion("seven_days_subscription_price >", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("seven_days_subscription_price >=", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceLessThan(BigDecimal value) {
            addCriterion("seven_days_subscription_price <", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("seven_days_subscription_price <=", value, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceIn(List<BigDecimal> values) {
            addCriterion("seven_days_subscription_price in", values, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceNotIn(List<BigDecimal> values) {
            addCriterion("seven_days_subscription_price not in", values, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seven_days_subscription_price between", value1, value2, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSubscriptionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("seven_days_subscription_price not between", value1, value2, "sevenDaysSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceIsNull() {
            addCriterion("one_month_subscription_price is null");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceIsNotNull() {
            addCriterion("one_month_subscription_price is not null");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceEqualTo(BigDecimal value) {
            addCriterion("one_month_subscription_price =", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceNotEqualTo(BigDecimal value) {
            addCriterion("one_month_subscription_price <>", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceGreaterThan(BigDecimal value) {
            addCriterion("one_month_subscription_price >", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("one_month_subscription_price >=", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceLessThan(BigDecimal value) {
            addCriterion("one_month_subscription_price <", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("one_month_subscription_price <=", value, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceIn(List<BigDecimal> values) {
            addCriterion("one_month_subscription_price in", values, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceNotIn(List<BigDecimal> values) {
            addCriterion("one_month_subscription_price not in", values, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_month_subscription_price between", value1, value2, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneMonthSubscriptionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_month_subscription_price not between", value1, value2, "oneMonthSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceIsNull() {
            addCriterion("one_quarter_subscription_price is null");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceIsNotNull() {
            addCriterion("one_quarter_subscription_price is not null");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceEqualTo(BigDecimal value) {
            addCriterion("one_quarter_subscription_price =", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceNotEqualTo(BigDecimal value) {
            addCriterion("one_quarter_subscription_price <>", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceGreaterThan(BigDecimal value) {
            addCriterion("one_quarter_subscription_price >", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("one_quarter_subscription_price >=", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceLessThan(BigDecimal value) {
            addCriterion("one_quarter_subscription_price <", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("one_quarter_subscription_price <=", value, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceIn(List<BigDecimal> values) {
            addCriterion("one_quarter_subscription_price in", values, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceNotIn(List<BigDecimal> values) {
            addCriterion("one_quarter_subscription_price not in", values, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_quarter_subscription_price between", value1, value2, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneQuarterSubscriptionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_quarter_subscription_price not between", value1, value2, "oneQuarterSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceIsNull() {
            addCriterion("one_year_subscription_price is null");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceIsNotNull() {
            addCriterion("one_year_subscription_price is not null");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceEqualTo(BigDecimal value) {
            addCriterion("one_year_subscription_price =", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceNotEqualTo(BigDecimal value) {
            addCriterion("one_year_subscription_price <>", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceGreaterThan(BigDecimal value) {
            addCriterion("one_year_subscription_price >", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("one_year_subscription_price >=", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceLessThan(BigDecimal value) {
            addCriterion("one_year_subscription_price <", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("one_year_subscription_price <=", value, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceIn(List<BigDecimal> values) {
            addCriterion("one_year_subscription_price in", values, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceNotIn(List<BigDecimal> values) {
            addCriterion("one_year_subscription_price not in", values, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_year_subscription_price between", value1, value2, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andOneYearSubscriptionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("one_year_subscription_price not between", value1, value2, "oneYearSubscriptionPrice");
            return (Criteria) this;
        }

        public Criteria andHasDiscountIsNull() {
            addCriterion("has_discount is null");
            return (Criteria) this;
        }

        public Criteria andHasDiscountIsNotNull() {
            addCriterion("has_discount is not null");
            return (Criteria) this;
        }

        public Criteria andHasDiscountEqualTo(Integer value) {
            addCriterion("has_discount =", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountNotEqualTo(Integer value) {
            addCriterion("has_discount <>", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountGreaterThan(Integer value) {
            addCriterion("has_discount >", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_discount >=", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountLessThan(Integer value) {
            addCriterion("has_discount <", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("has_discount <=", value, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountIn(List<Integer> values) {
            addCriterion("has_discount in", values, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountNotIn(List<Integer> values) {
            addCriterion("has_discount not in", values, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountBetween(Integer value1, Integer value2) {
            addCriterion("has_discount between", value1, value2, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andHasDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("has_discount not between", value1, value2, "hasDiscount");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(BigDecimal value) {
            addCriterion("discount_rate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(BigDecimal value) {
            addCriterion("discount_rate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(BigDecimal value) {
            addCriterion("discount_rate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(BigDecimal value) {
            addCriterion("discount_rate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<BigDecimal> values) {
            addCriterion("discount_rate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<BigDecimal> values) {
            addCriterion("discount_rate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableIsNull() {
            addCriterion("is_trial_available is null");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableIsNotNull() {
            addCriterion("is_trial_available is not null");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableEqualTo(Integer value) {
            addCriterion("is_trial_available =", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableNotEqualTo(Integer value) {
            addCriterion("is_trial_available <>", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableGreaterThan(Integer value) {
            addCriterion("is_trial_available >", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_trial_available >=", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableLessThan(Integer value) {
            addCriterion("is_trial_available <", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("is_trial_available <=", value, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableIn(List<Integer> values) {
            addCriterion("is_trial_available in", values, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableNotIn(List<Integer> values) {
            addCriterion("is_trial_available not in", values, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableBetween(Integer value1, Integer value2) {
            addCriterion("is_trial_available between", value1, value2, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andIsTrialAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_trial_available not between", value1, value2, "isTrialAvailable");
            return (Criteria) this;
        }

        public Criteria andTrialDurationIsNull() {
            addCriterion("trial_duration is null");
            return (Criteria) this;
        }

        public Criteria andTrialDurationIsNotNull() {
            addCriterion("trial_duration is not null");
            return (Criteria) this;
        }

        public Criteria andTrialDurationEqualTo(Integer value) {
            addCriterion("trial_duration =", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationNotEqualTo(Integer value) {
            addCriterion("trial_duration <>", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationGreaterThan(Integer value) {
            addCriterion("trial_duration >", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("trial_duration >=", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationLessThan(Integer value) {
            addCriterion("trial_duration <", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationLessThanOrEqualTo(Integer value) {
            addCriterion("trial_duration <=", value, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationIn(List<Integer> values) {
            addCriterion("trial_duration in", values, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationNotIn(List<Integer> values) {
            addCriterion("trial_duration not in", values, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationBetween(Integer value1, Integer value2) {
            addCriterion("trial_duration between", value1, value2, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("trial_duration not between", value1, value2, "trialDuration");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitIsNull() {
            addCriterion("trial_duration_unit is null");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitIsNotNull() {
            addCriterion("trial_duration_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitEqualTo(String value) {
            addCriterion("trial_duration_unit =", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitNotEqualTo(String value) {
            addCriterion("trial_duration_unit <>", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitGreaterThan(String value) {
            addCriterion("trial_duration_unit >", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitGreaterThanOrEqualTo(String value) {
            addCriterion("trial_duration_unit >=", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitLessThan(String value) {
            addCriterion("trial_duration_unit <", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitLessThanOrEqualTo(String value) {
            addCriterion("trial_duration_unit <=", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitLike(String value) {
            addCriterion("trial_duration_unit like", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitNotLike(String value) {
            addCriterion("trial_duration_unit not like", value, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitIn(List<String> values) {
            addCriterion("trial_duration_unit in", values, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitNotIn(List<String> values) {
            addCriterion("trial_duration_unit not in", values, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitBetween(String value1, String value2) {
            addCriterion("trial_duration_unit between", value1, value2, "trialDurationUnit");
            return (Criteria) this;
        }

        public Criteria andTrialDurationUnitNotBetween(String value1, String value2) {
            addCriterion("trial_duration_unit not between", value1, value2, "trialDurationUnit");
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

        public Criteria andIconsIsNull() {
            addCriterion("icons is null");
            return (Criteria) this;
        }

        public Criteria andIconsIsNotNull() {
            addCriterion("icons is not null");
            return (Criteria) this;
        }

        public Criteria andIconsEqualTo(String value) {
            addCriterion("icons =", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsNotEqualTo(String value) {
            addCriterion("icons <>", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsGreaterThan(String value) {
            addCriterion("icons >", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsGreaterThanOrEqualTo(String value) {
            addCriterion("icons >=", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsLessThan(String value) {
            addCriterion("icons <", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsLessThanOrEqualTo(String value) {
            addCriterion("icons <=", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsLike(String value) {
            addCriterion("icons like", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsNotLike(String value) {
            addCriterion("icons not like", value, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsIn(List<String> values) {
            addCriterion("icons in", values, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsNotIn(List<String> values) {
            addCriterion("icons not in", values, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsBetween(String value1, String value2) {
            addCriterion("icons between", value1, value2, "icons");
            return (Criteria) this;
        }

        public Criteria andIconsNotBetween(String value1, String value2) {
            addCriterion("icons not between", value1, value2, "icons");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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
