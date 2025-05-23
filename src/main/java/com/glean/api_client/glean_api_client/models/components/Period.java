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
import java.lang.Deprecated;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class Period {

    /**
     * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("minDaysFromNow")
    @Deprecated
    private Optional<Long> minDaysFromNow;

    /**
     * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("maxDaysFromNow")
    @Deprecated
    private Optional<Long> maxDaysFromNow;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("start")
    private Optional<? extends TimePoint> start;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("end")
    private Optional<? extends TimePoint> end;

    @JsonCreator
    public Period(
            @JsonProperty("minDaysFromNow") Optional<Long> minDaysFromNow,
            @JsonProperty("maxDaysFromNow") Optional<Long> maxDaysFromNow,
            @JsonProperty("start") Optional<? extends TimePoint> start,
            @JsonProperty("end") Optional<? extends TimePoint> end) {
        Utils.checkNotNull(minDaysFromNow, "minDaysFromNow");
        Utils.checkNotNull(maxDaysFromNow, "maxDaysFromNow");
        Utils.checkNotNull(start, "start");
        Utils.checkNotNull(end, "end");
        this.minDaysFromNow = minDaysFromNow;
        this.maxDaysFromNow = maxDaysFromNow;
        this.start = start;
        this.end = end;
    }
    
    public Period() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    @JsonIgnore
    public Optional<Long> minDaysFromNow() {
        return minDaysFromNow;
    }

    /**
     * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    @JsonIgnore
    public Optional<Long> maxDaysFromNow() {
        return maxDaysFromNow;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<TimePoint> start() {
        return (Optional<TimePoint>) start;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<TimePoint> end() {
        return (Optional<TimePoint>) end;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public Period withMinDaysFromNow(long minDaysFromNow) {
        Utils.checkNotNull(minDaysFromNow, "minDaysFromNow");
        this.minDaysFromNow = Optional.ofNullable(minDaysFromNow);
        return this;
    }

    /**
     * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public Period withMinDaysFromNow(Optional<Long> minDaysFromNow) {
        Utils.checkNotNull(minDaysFromNow, "minDaysFromNow");
        this.minDaysFromNow = minDaysFromNow;
        return this;
    }

    /**
     * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public Period withMaxDaysFromNow(long maxDaysFromNow) {
        Utils.checkNotNull(maxDaysFromNow, "maxDaysFromNow");
        this.maxDaysFromNow = Optional.ofNullable(maxDaysFromNow);
        return this;
    }

    /**
     * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
     * 
     * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
     */
    @Deprecated
    public Period withMaxDaysFromNow(Optional<Long> maxDaysFromNow) {
        Utils.checkNotNull(maxDaysFromNow, "maxDaysFromNow");
        this.maxDaysFromNow = maxDaysFromNow;
        return this;
    }

    public Period withStart(TimePoint start) {
        Utils.checkNotNull(start, "start");
        this.start = Optional.ofNullable(start);
        return this;
    }

    public Period withStart(Optional<? extends TimePoint> start) {
        Utils.checkNotNull(start, "start");
        this.start = start;
        return this;
    }

    public Period withEnd(TimePoint end) {
        Utils.checkNotNull(end, "end");
        this.end = Optional.ofNullable(end);
        return this;
    }

    public Period withEnd(Optional<? extends TimePoint> end) {
        Utils.checkNotNull(end, "end");
        this.end = end;
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
        Period other = (Period) o;
        return 
            Objects.deepEquals(this.minDaysFromNow, other.minDaysFromNow) &&
            Objects.deepEquals(this.maxDaysFromNow, other.maxDaysFromNow) &&
            Objects.deepEquals(this.start, other.start) &&
            Objects.deepEquals(this.end, other.end);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            minDaysFromNow,
            maxDaysFromNow,
            start,
            end);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Period.class,
                "minDaysFromNow", minDaysFromNow,
                "maxDaysFromNow", maxDaysFromNow,
                "start", start,
                "end", end);
    }
    
    public final static class Builder {
 
        @Deprecated
        private Optional<Long> minDaysFromNow = Optional.empty();
 
        @Deprecated
        private Optional<Long> maxDaysFromNow = Optional.empty();
 
        private Optional<? extends TimePoint> start = Optional.empty();
 
        private Optional<? extends TimePoint> end = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder minDaysFromNow(long minDaysFromNow) {
            Utils.checkNotNull(minDaysFromNow, "minDaysFromNow");
            this.minDaysFromNow = Optional.ofNullable(minDaysFromNow);
            return this;
        }

        /**
         * DEPRECATED - The number of days from now in the past to define upper boundary of time period.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder minDaysFromNow(Optional<Long> minDaysFromNow) {
            Utils.checkNotNull(minDaysFromNow, "minDaysFromNow");
            this.minDaysFromNow = minDaysFromNow;
            return this;
        }

        /**
         * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder maxDaysFromNow(long maxDaysFromNow) {
            Utils.checkNotNull(maxDaysFromNow, "maxDaysFromNow");
            this.maxDaysFromNow = Optional.ofNullable(maxDaysFromNow);
            return this;
        }

        /**
         * DEPRECATED - The number of days from now in the past to define lower boundary of time period.
         * 
         * @deprecated field: This will be removed in a future release, please migrate away from it as soon as possible.
         */
        @Deprecated
        public Builder maxDaysFromNow(Optional<Long> maxDaysFromNow) {
            Utils.checkNotNull(maxDaysFromNow, "maxDaysFromNow");
            this.maxDaysFromNow = maxDaysFromNow;
            return this;
        }

        public Builder start(TimePoint start) {
            Utils.checkNotNull(start, "start");
            this.start = Optional.ofNullable(start);
            return this;
        }

        public Builder start(Optional<? extends TimePoint> start) {
            Utils.checkNotNull(start, "start");
            this.start = start;
            return this;
        }

        public Builder end(TimePoint end) {
            Utils.checkNotNull(end, "end");
            this.end = Optional.ofNullable(end);
            return this;
        }

        public Builder end(Optional<? extends TimePoint> end) {
            Utils.checkNotNull(end, "end");
            this.end = end;
            return this;
        }
        
        public Period build() {
            return new Period(
                minDaysFromNow,
                maxDaysFromNow,
                start,
                end);
        }
    }
}
