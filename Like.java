/**

Like class represents the like interaction of a social media platform. It inherits from the Interaction class.
*/
package homework1;
public class Like extends Interaction{
	/**
 * Constructor for the Like class.
 * 
 * @param interactionId The unique identifier for the like interaction.
 * @param accountId The ID of the account that created the like.
 * @param postId The ID of the post that is being liked.
 */
protected Like(int interactionId, int accountId, int postId){
	super(interactionId, accountId, postId);
}

}

