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
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * ChannelInviteInfo
 * 
 * <p>Information regarding the invite status of a person for a particular channel.
 */
public class ChannelInviteInfo {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("channel")
    private Optional<? extends CommunicationChannel> channel;

    /**
     * Bit that tracks if this invite was automatically sent or user-sent
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("isAutoInvite")
    private Optional<Boolean> isAutoInvite;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("inviter")
    private Optional<? extends Person> inviter;

    /**
     * The time this person was invited in ISO format (ISO 8601).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("inviteTime")
    private Optional<OffsetDateTime> inviteTime;

    /**
     * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reminderTime")
    private Optional<OffsetDateTime> reminderTime;

    @JsonCreator
    public ChannelInviteInfo(
            @JsonProperty("channel") Optional<? extends CommunicationChannel> channel,
            @JsonProperty("isAutoInvite") Optional<Boolean> isAutoInvite,
            @JsonProperty("inviter") Optional<? extends Person> inviter,
            @JsonProperty("inviteTime") Optional<OffsetDateTime> inviteTime,
            @JsonProperty("reminderTime") Optional<OffsetDateTime> reminderTime) {
        Utils.checkNotNull(channel, "channel");
        Utils.checkNotNull(isAutoInvite, "isAutoInvite");
        Utils.checkNotNull(inviter, "inviter");
        Utils.checkNotNull(inviteTime, "inviteTime");
        Utils.checkNotNull(reminderTime, "reminderTime");
        this.channel = channel;
        this.isAutoInvite = isAutoInvite;
        this.inviter = inviter;
        this.inviteTime = inviteTime;
        this.reminderTime = reminderTime;
    }
    
    public ChannelInviteInfo() {
        this(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CommunicationChannel> channel() {
        return (Optional<CommunicationChannel>) channel;
    }

    /**
     * Bit that tracks if this invite was automatically sent or user-sent
     */
    @JsonIgnore
    public Optional<Boolean> isAutoInvite() {
        return isAutoInvite;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Person> inviter() {
        return (Optional<Person>) inviter;
    }

    /**
     * The time this person was invited in ISO format (ISO 8601).
     */
    @JsonIgnore
    public Optional<OffsetDateTime> inviteTime() {
        return inviteTime;
    }

    /**
     * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
     */
    @JsonIgnore
    public Optional<OffsetDateTime> reminderTime() {
        return reminderTime;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    public ChannelInviteInfo withChannel(CommunicationChannel channel) {
        Utils.checkNotNull(channel, "channel");
        this.channel = Optional.ofNullable(channel);
        return this;
    }

    public ChannelInviteInfo withChannel(Optional<? extends CommunicationChannel> channel) {
        Utils.checkNotNull(channel, "channel");
        this.channel = channel;
        return this;
    }

    /**
     * Bit that tracks if this invite was automatically sent or user-sent
     */
    public ChannelInviteInfo withIsAutoInvite(boolean isAutoInvite) {
        Utils.checkNotNull(isAutoInvite, "isAutoInvite");
        this.isAutoInvite = Optional.ofNullable(isAutoInvite);
        return this;
    }

    /**
     * Bit that tracks if this invite was automatically sent or user-sent
     */
    public ChannelInviteInfo withIsAutoInvite(Optional<Boolean> isAutoInvite) {
        Utils.checkNotNull(isAutoInvite, "isAutoInvite");
        this.isAutoInvite = isAutoInvite;
        return this;
    }

    public ChannelInviteInfo withInviter(Person inviter) {
        Utils.checkNotNull(inviter, "inviter");
        this.inviter = Optional.ofNullable(inviter);
        return this;
    }

    public ChannelInviteInfo withInviter(Optional<? extends Person> inviter) {
        Utils.checkNotNull(inviter, "inviter");
        this.inviter = inviter;
        return this;
    }

    /**
     * The time this person was invited in ISO format (ISO 8601).
     */
    public ChannelInviteInfo withInviteTime(OffsetDateTime inviteTime) {
        Utils.checkNotNull(inviteTime, "inviteTime");
        this.inviteTime = Optional.ofNullable(inviteTime);
        return this;
    }

    /**
     * The time this person was invited in ISO format (ISO 8601).
     */
    public ChannelInviteInfo withInviteTime(Optional<OffsetDateTime> inviteTime) {
        Utils.checkNotNull(inviteTime, "inviteTime");
        this.inviteTime = inviteTime;
        return this;
    }

    /**
     * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
     */
    public ChannelInviteInfo withReminderTime(OffsetDateTime reminderTime) {
        Utils.checkNotNull(reminderTime, "reminderTime");
        this.reminderTime = Optional.ofNullable(reminderTime);
        return this;
    }

    /**
     * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
     */
    public ChannelInviteInfo withReminderTime(Optional<OffsetDateTime> reminderTime) {
        Utils.checkNotNull(reminderTime, "reminderTime");
        this.reminderTime = reminderTime;
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
        ChannelInviteInfo other = (ChannelInviteInfo) o;
        return 
            Objects.deepEquals(this.channel, other.channel) &&
            Objects.deepEquals(this.isAutoInvite, other.isAutoInvite) &&
            Objects.deepEquals(this.inviter, other.inviter) &&
            Objects.deepEquals(this.inviteTime, other.inviteTime) &&
            Objects.deepEquals(this.reminderTime, other.reminderTime);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            channel,
            isAutoInvite,
            inviter,
            inviteTime,
            reminderTime);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ChannelInviteInfo.class,
                "channel", channel,
                "isAutoInvite", isAutoInvite,
                "inviter", inviter,
                "inviteTime", inviteTime,
                "reminderTime", reminderTime);
    }
    
    public final static class Builder {
 
        private Optional<? extends CommunicationChannel> channel = Optional.empty();
 
        private Optional<Boolean> isAutoInvite = Optional.empty();
 
        private Optional<? extends Person> inviter = Optional.empty();
 
        private Optional<OffsetDateTime> inviteTime = Optional.empty();
 
        private Optional<OffsetDateTime> reminderTime = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        public Builder channel(CommunicationChannel channel) {
            Utils.checkNotNull(channel, "channel");
            this.channel = Optional.ofNullable(channel);
            return this;
        }

        public Builder channel(Optional<? extends CommunicationChannel> channel) {
            Utils.checkNotNull(channel, "channel");
            this.channel = channel;
            return this;
        }

        /**
         * Bit that tracks if this invite was automatically sent or user-sent
         */
        public Builder isAutoInvite(boolean isAutoInvite) {
            Utils.checkNotNull(isAutoInvite, "isAutoInvite");
            this.isAutoInvite = Optional.ofNullable(isAutoInvite);
            return this;
        }

        /**
         * Bit that tracks if this invite was automatically sent or user-sent
         */
        public Builder isAutoInvite(Optional<Boolean> isAutoInvite) {
            Utils.checkNotNull(isAutoInvite, "isAutoInvite");
            this.isAutoInvite = isAutoInvite;
            return this;
        }

        public Builder inviter(Person inviter) {
            Utils.checkNotNull(inviter, "inviter");
            this.inviter = Optional.ofNullable(inviter);
            return this;
        }

        public Builder inviter(Optional<? extends Person> inviter) {
            Utils.checkNotNull(inviter, "inviter");
            this.inviter = inviter;
            return this;
        }

        /**
         * The time this person was invited in ISO format (ISO 8601).
         */
        public Builder inviteTime(OffsetDateTime inviteTime) {
            Utils.checkNotNull(inviteTime, "inviteTime");
            this.inviteTime = Optional.ofNullable(inviteTime);
            return this;
        }

        /**
         * The time this person was invited in ISO format (ISO 8601).
         */
        public Builder inviteTime(Optional<OffsetDateTime> inviteTime) {
            Utils.checkNotNull(inviteTime, "inviteTime");
            this.inviteTime = inviteTime;
            return this;
        }

        /**
         * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
         */
        public Builder reminderTime(OffsetDateTime reminderTime) {
            Utils.checkNotNull(reminderTime, "reminderTime");
            this.reminderTime = Optional.ofNullable(reminderTime);
            return this;
        }

        /**
         * The time this person was reminded in ISO format (ISO 8601) if a reminder was sent.
         */
        public Builder reminderTime(Optional<OffsetDateTime> reminderTime) {
            Utils.checkNotNull(reminderTime, "reminderTime");
            this.reminderTime = reminderTime;
            return this;
        }
        
        public ChannelInviteInfo build() {
            return new ChannelInviteInfo(
                channel,
                isAutoInvite,
                inviter,
                inviteTime,
                reminderTime);
        }
    }
}
