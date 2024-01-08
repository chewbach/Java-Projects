/**

The Comment class represents a comment made by a user on a post in a social media platform.
It extends the Interaction class and adds a content field to store the text content of the comment.
*/


package homework1;

public class Comment extends Interaction {
	private String content;
	protected String getContent() {return content;}


/**
 * Constructs a new Comment object with the given parameters.
 * 
 * @param interactionId The ID of the interaction.
 * @param accountId The ID of the account of the user who made the comment.
 * @param postId The ID of the post that the comment was made on.
 * @param content The text content of the comment.
 */
	protected Comment (int interactionId,int accountId,int postId,String content) {
		super(interactionId,accountId,postId);
		this.content = content;
	}
}
