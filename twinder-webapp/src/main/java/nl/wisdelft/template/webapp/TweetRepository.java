/**
 * 
 */
package nl.wisdelft.template.webapp;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ktao
 *
 */
public interface TweetRepository extends MongoRepository<Tweet, String> {
	public Tweet findById(Long id);
}
