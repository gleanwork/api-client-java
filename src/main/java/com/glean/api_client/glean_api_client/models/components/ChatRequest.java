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
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ChatRequest {

    /**
     * Save the current interaction as a Chat for the user to access and potentially continue later.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("saveChat")
    private Optional<Boolean> saveChat;

    /**
     * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("chatId")
    private Optional<String> chatId;

    /**
     * A list of chat messages, from most recent to least recent. It can be assumed that the first chat message in the list is the user's most recent query.
     */
    @JsonProperty("messages")
    private List<ChatMessage> messages;

    /**
     * Describes the agent that executes the request.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("agentConfig")
    private Optional<? extends AgentConfig> agentConfig;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("inclusions")
    private Optional<? extends ChatRestrictionFilters> inclusions;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("exclusions")
    private Optional<? extends ChatRestrictionFilters> exclusions;

    /**
     * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("timeoutMillis")
    private Optional<Long> timeoutMillis;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sessionInfo")
    private Optional<? extends SessionInfo> sessionInfo;

    /**
     * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("applicationId")
    private Optional<String> applicationId;

    /**
     * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("agentId")
    private Optional<String> agentId;

    /**
     * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("stream")
    private Optional<Boolean> stream;

    @JsonCreator
    public ChatRequest(
            @JsonProperty("saveChat") Optional<Boolean> saveChat,
            @JsonProperty("chatId") Optional<String> chatId,
            @JsonProperty("messages") List<ChatMessage> messages,
            @JsonProperty("agentConfig") Optional<? extends AgentConfig> agentConfig,
            @JsonProperty("inclusions") Optional<? extends ChatRestrictionFilters> inclusions,
            @JsonProperty("exclusions") Optional<? extends ChatRestrictionFilters> exclusions,
            @JsonProperty("timeoutMillis") Optional<Long> timeoutMillis,
            @JsonProperty("sessionInfo") Optional<? extends SessionInfo> sessionInfo,
            @JsonProperty("applicationId") Optional<String> applicationId,
            @JsonProperty("agentId") Optional<String> agentId,
            @JsonProperty("stream") Optional<Boolean> stream) {
        Utils.checkNotNull(saveChat, "saveChat");
        Utils.checkNotNull(chatId, "chatId");
        Utils.checkNotNull(messages, "messages");
        Utils.checkNotNull(agentConfig, "agentConfig");
        Utils.checkNotNull(inclusions, "inclusions");
        Utils.checkNotNull(exclusions, "exclusions");
        Utils.checkNotNull(timeoutMillis, "timeoutMillis");
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        Utils.checkNotNull(applicationId, "applicationId");
        Utils.checkNotNull(agentId, "agentId");
        Utils.checkNotNull(stream, "stream");
        this.saveChat = saveChat;
        this.chatId = chatId;
        this.messages = messages;
        this.agentConfig = agentConfig;
        this.inclusions = inclusions;
        this.exclusions = exclusions;
        this.timeoutMillis = timeoutMillis;
        this.sessionInfo = sessionInfo;
        this.applicationId = applicationId;
        this.agentId = agentId;
        this.stream = stream;
    }
    
    public ChatRequest(
            List<ChatMessage> messages) {
        this(Optional.empty(), Optional.empty(), messages, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * Save the current interaction as a Chat for the user to access and potentially continue later.
     */
    @JsonIgnore
    public Optional<Boolean> saveChat() {
        return saveChat;
    }

    /**
     * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
     */
    @JsonIgnore
    public Optional<String> chatId() {
        return chatId;
    }

    /**
     * A list of chat messages, from most recent to least recent. It can be assumed that the first chat message in the list is the user's most recent query.
     */
    @JsonIgnore
    public List<ChatMessage> messages() {
        return messages;
    }

    /**
     * Describes the agent that executes the request.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<AgentConfig> agentConfig() {
        return (Optional<AgentConfig>) agentConfig;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ChatRestrictionFilters> inclusions() {
        return (Optional<ChatRestrictionFilters>) inclusions;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ChatRestrictionFilters> exclusions() {
        return (Optional<ChatRestrictionFilters>) exclusions;
    }

    /**
     * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
     */
    @JsonIgnore
    public Optional<Long> timeoutMillis() {
        return timeoutMillis;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<SessionInfo> sessionInfo() {
        return (Optional<SessionInfo>) sessionInfo;
    }

    /**
     * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
     */
    @JsonIgnore
    public Optional<String> applicationId() {
        return applicationId;
    }

    /**
     * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
     */
    @JsonIgnore
    public Optional<String> agentId() {
        return agentId;
    }

    /**
     * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
     */
    @JsonIgnore
    public Optional<Boolean> stream() {
        return stream;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Save the current interaction as a Chat for the user to access and potentially continue later.
     */
    public ChatRequest withSaveChat(boolean saveChat) {
        Utils.checkNotNull(saveChat, "saveChat");
        this.saveChat = Optional.ofNullable(saveChat);
        return this;
    }

    /**
     * Save the current interaction as a Chat for the user to access and potentially continue later.
     */
    public ChatRequest withSaveChat(Optional<Boolean> saveChat) {
        Utils.checkNotNull(saveChat, "saveChat");
        this.saveChat = saveChat;
        return this;
    }

    /**
     * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
     */
    public ChatRequest withChatId(String chatId) {
        Utils.checkNotNull(chatId, "chatId");
        this.chatId = Optional.ofNullable(chatId);
        return this;
    }

    /**
     * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
     */
    public ChatRequest withChatId(Optional<String> chatId) {
        Utils.checkNotNull(chatId, "chatId");
        this.chatId = chatId;
        return this;
    }

    /**
     * A list of chat messages, from most recent to least recent. It can be assumed that the first chat message in the list is the user's most recent query.
     */
    public ChatRequest withMessages(List<ChatMessage> messages) {
        Utils.checkNotNull(messages, "messages");
        this.messages = messages;
        return this;
    }

    /**
     * Describes the agent that executes the request.
     */
    public ChatRequest withAgentConfig(AgentConfig agentConfig) {
        Utils.checkNotNull(agentConfig, "agentConfig");
        this.agentConfig = Optional.ofNullable(agentConfig);
        return this;
    }

    /**
     * Describes the agent that executes the request.
     */
    public ChatRequest withAgentConfig(Optional<? extends AgentConfig> agentConfig) {
        Utils.checkNotNull(agentConfig, "agentConfig");
        this.agentConfig = agentConfig;
        return this;
    }

    public ChatRequest withInclusions(ChatRestrictionFilters inclusions) {
        Utils.checkNotNull(inclusions, "inclusions");
        this.inclusions = Optional.ofNullable(inclusions);
        return this;
    }

    public ChatRequest withInclusions(Optional<? extends ChatRestrictionFilters> inclusions) {
        Utils.checkNotNull(inclusions, "inclusions");
        this.inclusions = inclusions;
        return this;
    }

    public ChatRequest withExclusions(ChatRestrictionFilters exclusions) {
        Utils.checkNotNull(exclusions, "exclusions");
        this.exclusions = Optional.ofNullable(exclusions);
        return this;
    }

    public ChatRequest withExclusions(Optional<? extends ChatRestrictionFilters> exclusions) {
        Utils.checkNotNull(exclusions, "exclusions");
        this.exclusions = exclusions;
        return this;
    }

    /**
     * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
     */
    public ChatRequest withTimeoutMillis(long timeoutMillis) {
        Utils.checkNotNull(timeoutMillis, "timeoutMillis");
        this.timeoutMillis = Optional.ofNullable(timeoutMillis);
        return this;
    }

    /**
     * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
     */
    public ChatRequest withTimeoutMillis(Optional<Long> timeoutMillis) {
        Utils.checkNotNull(timeoutMillis, "timeoutMillis");
        this.timeoutMillis = timeoutMillis;
        return this;
    }

    public ChatRequest withSessionInfo(SessionInfo sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = Optional.ofNullable(sessionInfo);
        return this;
    }

    public ChatRequest withSessionInfo(Optional<? extends SessionInfo> sessionInfo) {
        Utils.checkNotNull(sessionInfo, "sessionInfo");
        this.sessionInfo = sessionInfo;
        return this;
    }

    /**
     * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
     */
    public ChatRequest withApplicationId(String applicationId) {
        Utils.checkNotNull(applicationId, "applicationId");
        this.applicationId = Optional.ofNullable(applicationId);
        return this;
    }

    /**
     * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
     */
    public ChatRequest withApplicationId(Optional<String> applicationId) {
        Utils.checkNotNull(applicationId, "applicationId");
        this.applicationId = applicationId;
        return this;
    }

    /**
     * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
     */
    public ChatRequest withAgentId(String agentId) {
        Utils.checkNotNull(agentId, "agentId");
        this.agentId = Optional.ofNullable(agentId);
        return this;
    }

    /**
     * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
     */
    public ChatRequest withAgentId(Optional<String> agentId) {
        Utils.checkNotNull(agentId, "agentId");
        this.agentId = agentId;
        return this;
    }

    /**
     * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
     */
    public ChatRequest withStream(boolean stream) {
        Utils.checkNotNull(stream, "stream");
        this.stream = Optional.ofNullable(stream);
        return this;
    }

    /**
     * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
     */
    public ChatRequest withStream(Optional<Boolean> stream) {
        Utils.checkNotNull(stream, "stream");
        this.stream = stream;
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
        ChatRequest other = (ChatRequest) o;
        return 
            Objects.deepEquals(this.saveChat, other.saveChat) &&
            Objects.deepEquals(this.chatId, other.chatId) &&
            Objects.deepEquals(this.messages, other.messages) &&
            Objects.deepEquals(this.agentConfig, other.agentConfig) &&
            Objects.deepEquals(this.inclusions, other.inclusions) &&
            Objects.deepEquals(this.exclusions, other.exclusions) &&
            Objects.deepEquals(this.timeoutMillis, other.timeoutMillis) &&
            Objects.deepEquals(this.sessionInfo, other.sessionInfo) &&
            Objects.deepEquals(this.applicationId, other.applicationId) &&
            Objects.deepEquals(this.agentId, other.agentId) &&
            Objects.deepEquals(this.stream, other.stream);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            saveChat,
            chatId,
            messages,
            agentConfig,
            inclusions,
            exclusions,
            timeoutMillis,
            sessionInfo,
            applicationId,
            agentId,
            stream);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ChatRequest.class,
                "saveChat", saveChat,
                "chatId", chatId,
                "messages", messages,
                "agentConfig", agentConfig,
                "inclusions", inclusions,
                "exclusions", exclusions,
                "timeoutMillis", timeoutMillis,
                "sessionInfo", sessionInfo,
                "applicationId", applicationId,
                "agentId", agentId,
                "stream", stream);
    }
    
    public final static class Builder {
 
        private Optional<Boolean> saveChat = Optional.empty();
 
        private Optional<String> chatId = Optional.empty();
 
        private List<ChatMessage> messages;
 
        private Optional<? extends AgentConfig> agentConfig = Optional.empty();
 
        private Optional<? extends ChatRestrictionFilters> inclusions = Optional.empty();
 
        private Optional<? extends ChatRestrictionFilters> exclusions = Optional.empty();
 
        private Optional<Long> timeoutMillis = Optional.empty();
 
        private Optional<? extends SessionInfo> sessionInfo = Optional.empty();
 
        private Optional<String> applicationId = Optional.empty();
 
        private Optional<String> agentId = Optional.empty();
 
        private Optional<Boolean> stream = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * Save the current interaction as a Chat for the user to access and potentially continue later.
         */
        public Builder saveChat(boolean saveChat) {
            Utils.checkNotNull(saveChat, "saveChat");
            this.saveChat = Optional.ofNullable(saveChat);
            return this;
        }

        /**
         * Save the current interaction as a Chat for the user to access and potentially continue later.
         */
        public Builder saveChat(Optional<Boolean> saveChat) {
            Utils.checkNotNull(saveChat, "saveChat");
            this.saveChat = saveChat;
            return this;
        }

        /**
         * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
         */
        public Builder chatId(String chatId) {
            Utils.checkNotNull(chatId, "chatId");
            this.chatId = Optional.ofNullable(chatId);
            return this;
        }

        /**
         * The id of the Chat that context should be retrieved from and messages added to. An empty id starts a new Chat, and the Chat is saved if saveChat is true.
         */
        public Builder chatId(Optional<String> chatId) {
            Utils.checkNotNull(chatId, "chatId");
            this.chatId = chatId;
            return this;
        }

        /**
         * A list of chat messages, from most recent to least recent. It can be assumed that the first chat message in the list is the user's most recent query.
         */
        public Builder messages(List<ChatMessage> messages) {
            Utils.checkNotNull(messages, "messages");
            this.messages = messages;
            return this;
        }

        /**
         * Describes the agent that executes the request.
         */
        public Builder agentConfig(AgentConfig agentConfig) {
            Utils.checkNotNull(agentConfig, "agentConfig");
            this.agentConfig = Optional.ofNullable(agentConfig);
            return this;
        }

        /**
         * Describes the agent that executes the request.
         */
        public Builder agentConfig(Optional<? extends AgentConfig> agentConfig) {
            Utils.checkNotNull(agentConfig, "agentConfig");
            this.agentConfig = agentConfig;
            return this;
        }

        public Builder inclusions(ChatRestrictionFilters inclusions) {
            Utils.checkNotNull(inclusions, "inclusions");
            this.inclusions = Optional.ofNullable(inclusions);
            return this;
        }

        public Builder inclusions(Optional<? extends ChatRestrictionFilters> inclusions) {
            Utils.checkNotNull(inclusions, "inclusions");
            this.inclusions = inclusions;
            return this;
        }

        public Builder exclusions(ChatRestrictionFilters exclusions) {
            Utils.checkNotNull(exclusions, "exclusions");
            this.exclusions = Optional.ofNullable(exclusions);
            return this;
        }

        public Builder exclusions(Optional<? extends ChatRestrictionFilters> exclusions) {
            Utils.checkNotNull(exclusions, "exclusions");
            this.exclusions = exclusions;
            return this;
        }

        /**
         * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
         */
        public Builder timeoutMillis(long timeoutMillis) {
            Utils.checkNotNull(timeoutMillis, "timeoutMillis");
            this.timeoutMillis = Optional.ofNullable(timeoutMillis);
            return this;
        }

        /**
         * Timeout in milliseconds for the request. A `408` error will be returned if handling the request takes longer.
         */
        public Builder timeoutMillis(Optional<Long> timeoutMillis) {
            Utils.checkNotNull(timeoutMillis, "timeoutMillis");
            this.timeoutMillis = timeoutMillis;
            return this;
        }

        public Builder sessionInfo(SessionInfo sessionInfo) {
            Utils.checkNotNull(sessionInfo, "sessionInfo");
            this.sessionInfo = Optional.ofNullable(sessionInfo);
            return this;
        }

        public Builder sessionInfo(Optional<? extends SessionInfo> sessionInfo) {
            Utils.checkNotNull(sessionInfo, "sessionInfo");
            this.sessionInfo = sessionInfo;
            return this;
        }

        /**
         * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
         */
        public Builder applicationId(String applicationId) {
            Utils.checkNotNull(applicationId, "applicationId");
            this.applicationId = Optional.ofNullable(applicationId);
            return this;
        }

        /**
         * The ID of the application this request originates from, used to determine the configuration of underlying chat processes. This should correspond to the ID set during admin setup. If not specified, the default chat experience will be used.
         */
        public Builder applicationId(Optional<String> applicationId) {
            Utils.checkNotNull(applicationId, "applicationId");
            this.applicationId = applicationId;
            return this;
        }

        /**
         * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
         */
        public Builder agentId(String agentId) {
            Utils.checkNotNull(agentId, "agentId");
            this.agentId = Optional.ofNullable(agentId);
            return this;
        }

        /**
         * The ID of the Agent that should process this chat request. Only Agents with trigger set to 'User chat message' are invokable through this API. If not specified, the default chat experience will be used.
         */
        public Builder agentId(Optional<String> agentId) {
            Utils.checkNotNull(agentId, "agentId");
            this.agentId = agentId;
            return this;
        }

        /**
         * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
         */
        public Builder stream(boolean stream) {
            Utils.checkNotNull(stream, "stream");
            this.stream = Optional.ofNullable(stream);
            return this;
        }

        /**
         * If set, response lines will be streamed one-by-one as they become available. Each will be a ChatResponse, formatted as JSON, and separated by a new line. If false, the entire response will be returned at once. Note that if this is set and the model being used does not support streaming, the model's response will not be streamed, but other messages from the endpoint still will be.
         */
        public Builder stream(Optional<Boolean> stream) {
            Utils.checkNotNull(stream, "stream");
            this.stream = stream;
            return this;
        }
        
        public ChatRequest build() {
            return new ChatRequest(
                saveChat,
                chatId,
                messages,
                agentConfig,
                inclusions,
                exclusions,
                timeoutMillis,
                sessionInfo,
                applicationId,
                agentId,
                stream);
        }
    }
}
