/**

The Interaction class represents an interaction of a user with a post in a social media platform.
It stores information about the interaction such as the interaction ID, account ID of the user, and post ID.
*/

package homework1;



public class Interaction {
	private int interactionId;
	public int accountId;
	private int postId;
	
	/**
 * Constructs a new Interaction object with the given parameters.
 * 
 * @param interactionId The ID of the interaction.
 * @param accountId The ID of the account of the user who performed the interaction.
 * @param postId The ID of the post that was interacted with.
 */
	protected Interaction(int interactionId,int accountId,int postId) {
		this.interactionId = interactionId;
		this.accountId = accountId;
		this.postId = postId;
		
	}
}
