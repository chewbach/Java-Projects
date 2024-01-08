package homework1;

/**
 * Represents a message sent between two users.
 */
public class Message {
    private int messageId;
    private int senderId;
    private int recieverId;
    private String content;
    private String fromMessage;
    private String toMessage;

    /**
     * Sets the sender and receiver usernames for this message.
     *
     * @param fromMessage the username of the sender
     * @param toMessage   the username of the receiver
     */
    protected void setMessageInfo(String fromMessage, String toMessage) {
        this.fromMessage = fromMessage;
        this.toMessage = toMessage;
    }

    /**
     * Returns the username of the sender of this message.
     *
     * @return the username of the sender
     */
    protected String getSenderUserName() {
        return fromMessage;
    }

    /**
     * Returns the username of the receiver of this message.
     *
     * @return the username of the receiver
     */
    protected String getRecieverUserName() {
        return toMessage;
    }

    /**
     * Returns the content of this message.
     *
     * @return the content of this message
     */
    protected String getContent() {
        return content;
    }

    /**
     * Returns the ID of this message.
     *
     * @return the ID of this message
     */
    protected int getMessageId() {
        return messageId;
    }

    /**
     * Creates a new Message object with the specified parameters.
     *
     * @param messageId  the ID of the message
     * @param senderId   the ID of the sender of the message
     * @param receiverId the ID of the receiver of the message
     * @param content    the content of the message
     */
    protected Message(int messageId, int senderId, int receiverId, String content) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.content = content;
    }
}
