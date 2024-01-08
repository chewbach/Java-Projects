package homework1;

/**
 * Represents a post made by a user on a social media platform.
 */
public class Post {

    private int postId;
    private int accountId;
    private String content;
    private Like[] likes;
    private Comment[] comments;
    private int likeCounter;
    private int commentCounter;

    /**
     * Creates a new Post object with the specified parameters.
     *
     * @param postId     the ID of the post
     * @param accountId  the ID of the user who made the post
     * @param content    the content of the post
     */
    Post(int postId, int accountId, String content) {
        this.postId = postId;
        this.accountId = accountId;
        this.content = content;
        this.likes = new Like[1000];
        this.comments = new Comment[1000];
        this.likeCounter = 0;
        this.commentCounter = 0;
    }

    /**
     * Returns the ID of this post.
     *
     * @return the ID of this post
     */
    protected int getPostID() {
        return postId;
    }

    /**
     * Returns the number of comments on this post.
     *
     * @return the number of comments on this post
     */
    protected int getCommentCounter() {
        return commentCounter;
    }

    /**
     * Returns the content of this post.
     *
     * @return the content of this post
     */
    protected String getContent() {
        return content;
    }

    /**
     * Returns the number of likes on this post.
     *
     * @return the number of likes on this post
     */
    protected int getLikeCounter() {
        return likeCounter;
    }

    /**
     * Adds a like to this post by the specified user.
     *
     * @param id the ID of the user who liked the post
     */
    protected void addLike(int id) {
        likes[likeCounter] = new Like(5, id, postId);
        ++likeCounter;
    }

    /**
     * Adds a comment to this post by the specified user.
     *
     * @param comment the comment text
     * @param id      the ID of the user who made the comment
     */
    protected void addComment(String comment, int id) {
        comments[commentCounter] = new Comment(8, id, postId, comment);
        ++commentCounter;
    }

    /**
     * Prints the usernames of users who have liked this post.
     */
    protected void getLikers() {
        for (int i = 0; i < likeCounter; i++) {
            if (likes[i].accountId == 1)
                System.out.print("gizemsungu ");
            if (likes[i].accountId == 2)
                System.out.print("sibelgulmez ");
            if (likes[i].accountId == 3)
                System.out.print("gokhankaya ");

        }
    }


		
		/**
     * Prints information about the comments on this post.
     */
		protected void commentInfo() {
			for(int i = 0;i<commentCounter;i++) {
				System.out.print("Comment "+(i+1)+": "+"'");
				
					if(comments[i].accountId == 1) 
						System.out.print("gizemsungu");
					if(comments[i].accountId == 2)
						System.out.print("sibelgulmez");
					if(comments[i].accountId == 3)
						System.out.print("gokhankaya");
				
			System.out.println("' said "+"'"+comments[i].getContent()+"'");
			}
				
		}
		
		protected int getLikeCount() { return likeCounter++;}
}
