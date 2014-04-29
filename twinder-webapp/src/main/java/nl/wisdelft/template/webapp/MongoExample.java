/**
 * 
 */
package nl.wisdelft.template.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author ktao
 *
 */
@EnableAutoConfiguration
public class MongoExample implements CommandLineRunner {
	@Autowired
	private TweetRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoExample.class, args);
	}
	
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Tweet(1L, "First tweet"));
		repository.save(new Tweet(2L, "Second tweet"));

		// fetch all customers
		System.out.println("Tweets found with findAll():");
		System.out.println("-------------------------------");
		for (Tweet tweet : repository.findAll()) {
			System.out.println(tweet);
		}
		System.out.println();

		// fetch an individual tweet
		System.out.println("Customer found with findById(1L):");
		System.out.println("--------------------------------");
		System.out.println(repository.findById(1L));

		System.out.println("Customers found with findById(2L):");
		System.out.println("--------------------------------");
		System.out.println(repository.findById(2L));
	}
}
