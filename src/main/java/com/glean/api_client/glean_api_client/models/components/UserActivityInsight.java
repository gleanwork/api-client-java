/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class UserActivityInsight {

    @JsonProperty("user")
    private Person user;

    /**
     * Activity e.g. search, home page visit or all.
     */
    @JsonProperty("activity")
    private ActivityEnum activity;

    /**
     * Unix timestamp of the last activity (in seconds since epoch UTC).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("lastActivityTimestamp")
    private Optional<Long> lastActivityTimestamp;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("activityCount")
    private Optional<? extends CountInfo> activityCount;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("activeDayCount")
    private Optional<? extends CountInfo> activeDayCount;

    @JsonCreator
    public UserActivityInsight(
            @JsonProperty("user") Person user,
            @JsonProperty("activity") ActivityEnum activity,
            @JsonProperty("lastActivityTimestamp") Optional<Long> lastActivityTimestamp,
            @JsonProperty("activityCount") Optional<? extends CountInfo> activityCount,
            @JsonProperty("activeDayCount") Optional<? extends CountInfo> activeDayCount) {
        Utils.checkNotNull(user, "user");
        Utils.checkNotNull(activity, "activity");
        Utils.checkNotNull(lastActivityTimestamp, "lastActivityTimestamp");
        Utils.checkNotNull(activityCount, "activityCount");
        Utils.checkNotNull(activeDayCount, "activeDayCount");
        this.user = user;
        this.activity = activity;
        this.lastActivityTimestamp = lastActivityTimestamp;
        this.activityCount = activityCount;
        this.activeDayCount = activeDayCount;
    }
    
    public UserActivityInsight(
            Person user,
            ActivityEnum activity) {
        this(user, activity, Optional.empty(), Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Person user() {
        return user;
    }

    /**
     * Activity e.g. search, home page visit or all.
     */
    @JsonIgnore
    public ActivityEnum activity() {
        return activity;
    }

    /**
     * Unix timestamp of the last activity (in seconds since epoch UTC).
     */
    @JsonIgnore
    public Optional<Long> lastActivityTimestamp() {
        return lastActivityTimestamp;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CountInfo> activityCount() {
        return (Optional<CountInfo>) activityCount;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CountInfo> activeDayCount() {
        return (Optional<CountInfo>) activeDayCount;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public UserActivityInsight withUser(Person user) {
        Utils.checkNotNull(user, "user");
        this.user = user;
        return this;
    }

    /**
     * Activity e.g. search, home page visit or all.
     */
    public UserActivityInsight withActivity(ActivityEnum activity) {
        Utils.checkNotNull(activity, "activity");
        this.activity = activity;
        return this;
    }

    /**
     * Unix timestamp of the last activity (in seconds since epoch UTC).
     */
    public UserActivityInsight withLastActivityTimestamp(long lastActivityTimestamp) {
        Utils.checkNotNull(lastActivityTimestamp, "lastActivityTimestamp");
        this.lastActivityTimestamp = Optional.ofNullable(lastActivityTimestamp);
        return this;
    }

    /**
     * Unix timestamp of the last activity (in seconds since epoch UTC).
     */
    public UserActivityInsight withLastActivityTimestamp(Optional<Long> lastActivityTimestamp) {
        Utils.checkNotNull(lastActivityTimestamp, "lastActivityTimestamp");
        this.lastActivityTimestamp = lastActivityTimestamp;
        return this;
    }

    public UserActivityInsight withActivityCount(CountInfo activityCount) {
        Utils.checkNotNull(activityCount, "activityCount");
        this.activityCount = Optional.ofNullable(activityCount);
        return this;
    }

    public UserActivityInsight withActivityCount(Optional<? extends CountInfo> activityCount) {
        Utils.checkNotNull(activityCount, "activityCount");
        this.activityCount = activityCount;
        return this;
    }

    public UserActivityInsight withActiveDayCount(CountInfo activeDayCount) {
        Utils.checkNotNull(activeDayCount, "activeDayCount");
        this.activeDayCount = Optional.ofNullable(activeDayCount);
        return this;
    }

    public UserActivityInsight withActiveDayCount(Optional<? extends CountInfo> activeDayCount) {
        Utils.checkNotNull(activeDayCount, "activeDayCount");
        this.activeDayCount = activeDayCount;
        return this;
    }

    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserActivityInsight other = (UserActivityInsight) o;
        return 
            Objects.deepEquals(this.user, other.user) &&
            Objects.deepEquals(this.activity, other.activity) &&
            Objects.deepEquals(this.lastActivityTimestamp, other.lastActivityTimestamp) &&
            Objects.deepEquals(this.activityCount, other.activityCount) &&
            Objects.deepEquals(this.activeDayCount, other.activeDayCount);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            user,
            activity,
            lastActivityTimestamp,
            activityCount,
            activeDayCount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UserActivityInsight.class,
                "user", user,
                "activity", activity,
                "lastActivityTimestamp", lastActivityTimestamp,
                "activityCount", activityCount,
                "activeDayCount", activeDayCount);
    }
    
    public final static class Builder {
 
        private Person user;
 
        private ActivityEnum activity;
 
        private Optional<Long> lastActivityTimestamp = Optional.empty();
 
        private Optional<? extends CountInfo> activityCount = Optional.empty();
 
        private Optional<? extends CountInfo> activeDayCount = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder user(Person user) {
            Utils.checkNotNull(user, "user");
            this.user = user;
            return this;
        }

        /**
         * Activity e.g. search, home page visit or all.
         */
        public Builder activity(ActivityEnum activity) {
            Utils.checkNotNull(activity, "activity");
            this.activity = activity;
            return this;
        }

        /**
         * Unix timestamp of the last activity (in seconds since epoch UTC).
         */
        public Builder lastActivityTimestamp(long lastActivityTimestamp) {
            Utils.checkNotNull(lastActivityTimestamp, "lastActivityTimestamp");
            this.lastActivityTimestamp = Optional.ofNullable(lastActivityTimestamp);
            return this;
        }

        /**
         * Unix timestamp of the last activity (in seconds since epoch UTC).
         */
        public Builder lastActivityTimestamp(Optional<Long> lastActivityTimestamp) {
            Utils.checkNotNull(lastActivityTimestamp, "lastActivityTimestamp");
            this.lastActivityTimestamp = lastActivityTimestamp;
            return this;
        }

        public Builder activityCount(CountInfo activityCount) {
            Utils.checkNotNull(activityCount, "activityCount");
            this.activityCount = Optional.ofNullable(activityCount);
            return this;
        }

        public Builder activityCount(Optional<? extends CountInfo> activityCount) {
            Utils.checkNotNull(activityCount, "activityCount");
            this.activityCount = activityCount;
            return this;
        }

        public Builder activeDayCount(CountInfo activeDayCount) {
            Utils.checkNotNull(activeDayCount, "activeDayCount");
            this.activeDayCount = Optional.ofNullable(activeDayCount);
            return this;
        }

        public Builder activeDayCount(Optional<? extends CountInfo> activeDayCount) {
            Utils.checkNotNull(activeDayCount, "activeDayCount");
            this.activeDayCount = activeDayCount;
            return this;
        }
        
        public UserActivityInsight build() {
            return new UserActivityInsight(
                user,
                activity,
                lastActivityTimestamp,
                activityCount,
                activeDayCount);
        }
    }
}
