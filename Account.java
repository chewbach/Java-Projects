/**

This class represents a social media account.
It stores the account's unique ID, username, birthday, location, and various other information.
The account can also interact with other accounts, such as adding posts, following other accounts,
sending and receiving messages, and blocking other accounts.
*/
package homework1;
public class Account {
private int accountId;
private String userName;
private String birthday;
private String location;
private boolean canAccess;
private int postCounter;
private int followingCounter;
private int followerCounter;
private int inboxCounter;
private int outboxCounter;
private int blockedAccountsCounter;
private int blockedThisAccountCounter;
private boolean toBlock;
	
	private Post[] posts;

private Account[] followers;
private Account[] following;

private Message[] inbox;
private Message[] outbox;

private Account[] blockedAccounts;
private Account[] blockedThisAccount;

/**
 * Constructor for the Account class.
 * @param accountId the unique ID of the account
 * @param userName the username of the account
 * @param birthday the birth date of the account owner
 * @param location the location of the account owner
 */
protected Account(int accountId,String userName,String birthday,String location) {
	this.accountId = accountId;
	this.userName = userName;
	this.birthday = birthday;
	this.location = location;
	this.canAccess = false;
	this.postCounter = 0;
	this.followingCounter = 0;
	this.followerCounter = 0;
	this.inboxCounter = 0;
	this.outboxCounter = 0;
	this.toBlock = false;
	this.blockedAccountsCounter = 0;
	this.blockedThisAccountCounter = 0;
	posts = new Post [1000];
	inbox = new Message[1000];
	outbox = new Message[1000];
	followers = new Account [1000];
	following = new Account [1000];
	blockedAccounts = new Account[1000];
	blockedThisAccount = new Account[1000];
	
	System.out.println("An account with username "+userName+" has been created.");
}

/**
 * Logs the account in if the provided username matches the account's username.
 * @param userName the username to check against the account's username
 */
protected void login(String userName) {
	if(this.userName == userName) {
		System.out.println("Successfully logged in");
		canAccess = true;
	}
	else {
		System.out.println("The login failed.");
	}
}
	
	/**
 * Logs out the current account and sets the canAccess flag to false.
 */
protected void logout() {
    System.out.println("The account is logged out.");
    this.canAccess = false;
}

/**
 * Checks if the current account is logged in. If not, prints an error message and exits the program.
 */
protected void isLoggedIn() {
    if (!this.canAccess) {
        System.out.println("You must login.");
        System.exit(0);
    }
}

/**
 * Checks if the current account is following the specified account.
 *
 * @param tempAccount the account to check if the current account is following
 * @return true if the current account is following the specified account, false otherwise
 */
protected boolean isFollow(Account tempAccount) {
    for (int i = 0; i < followingCounter; i++) {
        if (following[i].accountId == tempAccount.accountId)
            return true;
    }
    return false;
}

/**
 * Adds a new post to the current account's list of posts.
 *
 * @param content the content of the new post
 */
protected void addPost(String content) {
    isLoggedIn();
    Post post = new Post(postCounter + 1, accountId, content);
    this.posts[this.postCounter] = post;
    ++postCounter;
}

/**
 * Follows the specified account.
 *
 * @param follow the account to follow
 */
protected void follow(Account follow) {
    isLoggedIn();
    this.following[this.followingCounter] = follow;
    ++followingCounter;
    follow.followers[follow.followerCounter] = this;
    follow.followerCounter += 1;
    System.out.println("Following " + follow.userName);
}

/**
 * Displays the profile information of the specified account.
 *
 * @param profile the account whose profile to display
 */
protected void viewProfile(Account profile) {
    isLoggedIn();
    if (isBlocked(profile)) {
        System.out.println("You are blocked by this account.");
        System.exit(0);
    }
    System.out.println("User ID: " + profile.accountId);
    System.out.println("Username: " + profile.userName);
    System.out.println("Location: " + profile.location);
    System.out.println("Birth Date: " + profile.birthday);
    System.out.println(profile.userName + " is following " + profile.followingCounter + " account(s) and has " + profile.followerCounter + " follower(s).");
    System.out.print(profile.userName + " is following: ");
    for (int i = 0; i < profile.followingCounter; i++)
        System.out.print(profile.following[i].userName + " ");
    System.out.println();
    System.out.println(profile.userName + " has " + profile.postCounter + " posts.");
}

	/**
 	* Displays all posts from a given account.
 	* @param profileposts the account whose posts will be displayed.
	*/
	protected void viewPosts(Account profileposts) {
		isLoggedIn();
		for(int i = 0;i <profileposts.postCounter;i++)
			System.out.println("(PostID: "+ profileposts.posts[i].getPostID()+")"+profileposts.userName+": "+ profileposts.posts[i].getContent());
		
	}

	/**
 	* Adds a like to a given post on a given account.
 	* @param likedAccount the account that the post belongs to.
 	* @param likedPostId the ID of the post to like.
 	*/
	
	protected void like(Account likedAccount,int likedPostId) {
		isLoggedIn();
		likedPostId -= 1;
		likedAccount.posts[likedPostId].addLike(this.accountId);
		
	}
	
	/**
 	* Adds a comment to a given post on a given account.
 	* @param tocomment the account that the post belongs to.
 	* @param commentedPostId the ID of the post to comment on.
 	* @param comment the comment to add to the post.
 	*/

	protected void comment(Account tocomment,int commentedPostId,String comment){
		isLoggedIn();
		commentedPostId -= 1;
		tocomment.posts[commentedPostId].addComment(comment,this.accountId);
		
		
	}

	/**
 	* Displays all interactions (likes and comments) on all posts from a given account.
 	* @param profile the account whose posts and interactions will be displayed.
 	*/
	
	protected void viewInteractions(Account profile) {
		isLoggedIn();
		for(int i = 0; i<profile.postCounter;i++ ) {
			
			System.out.println("(PostID: "+profile.posts[i].getPostID()+"): "+profile.posts[i].getContent());
			if(profile.posts[i].getLikeCounter() == 0) {
				System.out.println("The post has no likes.");
			}
			else {
			System.out.print("The post was liked by the following account(s): " );
		    profile.posts[i].getLikers();
		    System.out.println();
			}
		    
		    if(profile.posts[i].getCommentCounter() == 0) {
		    	System.out.println("The post has no comments.");
		    }
		    else {
		    System.out.printf("The post has %d comment(s)...\n",profile.posts[i].getCommentCounter());
		    profile.posts[i].commentInfo();
		    }
		}	
	}
	
	/**
 	* Sends a message to a given account.
 	* @param toSendedAccount the account to send the message to.
 	* @param message the message to send.
 	*/

	protected void sendMessage(Account toSendedAccount,String message) {
			
			isLoggedIn();
		    
		    if(isBlocked(toSendedAccount)) {
				System.out.println("You are blocked by this account.");
				System.exit(0);
			}	
		    if (!isFollow(toSendedAccount)) {
		        System.out.println("You can't send messages to accounts you don't follow.");
		        return;
		    }
		    Message newMessage = new Message(outboxCounter, accountId, toSendedAccount.accountId, message);
		  
		    toSendedAccount.inbox[toSendedAccount.inboxCounter] = newMessage;
		    toSendedAccount.inbox[toSendedAccount.inboxCounter].setMessageInfo(userName, toSendedAccount.userName);
		    toSendedAccount.inboxCounter++;
		    outbox[outboxCounter] = newMessage;
		    outbox[outboxCounter].setMessageInfo(userName, toSendedAccount.userName);
		    outboxCounter++;
		

	}
	
	/**
 	* Displays the number of messages in the outbox.
 	*/
	protected void checkOutbox() {
		isLoggedIn();
		System.out.println("There is/are "+outboxCounter+" message(s) in the outbox.");
	}

	/**
 	* Displays the number of messages in the inbox.
 	*/
	
	protected void checkInbox() {
		isLoggedIn();
		System.out.println("There is/are "+inboxCounter+" message(s) in the inbox.");
	}

	/**
	 * Displays all messages in the outbox.
 	*/

	
	protected void viewOutbox() {
		isLoggedIn();
		for(int i = 0;i<outboxCounter;i++) {
			System.out.println("Message ID: "+outbox[i].getMessageId());
			System.out.println("From: "+outbox[i].getSenderUserName());
			System.out.println("To: "+outbox[i].getRecieverUserName());
			System.out.println("Message: "+outbox[i].getContent());
			
		}
	}
	
	/**
 	* Displays all messages in the inbox.
 	*/
	protected void viewInbox() {
		isLoggedIn();

		for(int i = 0;i<inboxCounter;i++) {
			System.out.println("Message ID: "+inbox[i].getMessageId());
			System.out.println("From: "+inbox[i].getSenderUserName());
			System.out.println("To: "+inbox[i].getRecieverUserName());
			System.out.println("Message: "+inbox[i].getContent());
			
		}
	}

	/**
 	* Displays all messages in the inbox sent by a given account.
 	* @param profile the account whose messages will be displayed.
 	*/
	
	protected void readMessagesFrom(Account profile) {
		
			for(int i = 0;i<inboxCounter;i++) {
				
				if(profile.userName == inbox[i].getSenderUserName()) {
					System.out.println(inbox[i].getContent());
				}
			}
		
	}

	/**
	 * Checks if a given account is blocked by this account.
 	* @param profile the account to check.
 	* @return true if the account is blocked, false otherwise.
 	*/
	
	protected boolean isBlocked(Account profile) {
		for(int i = 0; i < blockedThisAccountCounter ;i++) {
			if(blockedThisAccount[i].accountId == profile.accountId ) {
				return true;
			}
		}
		return false;
	}
	
	/**
 	* Blocks a given account.
 	* @param profile the account to block.
 	*/

	protected void block(Account profile) {
		this.blockedAccounts[blockedAccountsCounter] = profile;
		blockedAccountsCounter++;
		profile.blockedThisAccount[profile.blockedThisAccountCounter] = this;
		profile.blockedThisAccountCounter += 1;
	}
	
	
	
}
