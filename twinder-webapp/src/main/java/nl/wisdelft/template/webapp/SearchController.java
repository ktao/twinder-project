/**
 * 
 */
package nl.wisdelft.template.webapp;

import java.io.IOException;
import java.util.Date;

import nl.wisdelft.twinder.PrototypeSearch;
import nl.wisdelft.twinder.io.MongoDBUtility;
import nl.wisdelft.twinder.lucene.Searcher;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.BasicDBObject;

/**
 * @author ktao
 *
 */
@Controller
public class SearchController {
	
	/**
	 * The index is just the search page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET) 
    public String index(Model model) {
		model.addAttribute("srequest", new SearchRequest()); // todo
		return "search";
	}
	
	/**
	 * The default page for starting a search
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("srequest", new SearchRequest()); // todo
		return "search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchForm(@ModelAttribute SearchRequest srequest, Model model) {
		srequest.setQuery(srequest.getQuery());
		model.addAttribute("srequest", srequest); // get the raw query
		
		Date start = new Date();
		PrototypeSearch search = new PrototypeSearch();
		BasicDBObject[] results = search.search(srequest.getQuery());
		
		Object[][] contents = new String[results.length][4];
		for (int i = 0; i < contents.length; i++) {
			try {
				BasicDBObject user = (BasicDBObject)results[i].get("user");
				contents[i][0] = Long.toString(results[i].getLong("id"));
				contents[i][1] = results[i].getString("content");
				contents[i][2] = user.getString("screenName");
				contents[i][3] = user.getString("profile_image_url");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println(results[i]);
			}
		}
		model.addAttribute("contents", contents);
		Date end = new Date();
		double time = (double)(end.getTime() - start.getTime()) / 1000.000;
		model.addAttribute("time", time);
		model.addAttribute("number", contents.length);
		return "results";
	}
}
