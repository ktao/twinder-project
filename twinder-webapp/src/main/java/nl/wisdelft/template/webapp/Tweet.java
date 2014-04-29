/**
 * 
 */
package nl.wisdelft.template.webapp;

import org.springframework.data.annotation.Id;

/**
 * @author ktao
 *
 */
public class Tweet {
	@Id
	private String mid;
	
	private Long id;
	
	private String content;
	
	public Tweet() {
	}
	
	public Tweet(Long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public String toString() {
		return String.format("Tweet[mid=%s, id=%d, content='%s']", 
				mid, id, content);
	}
	
	public static void main(String args[]) {
		Tweet t = new Tweet(1L, "First tweet.");
		System.out.println(t);
	}
}
