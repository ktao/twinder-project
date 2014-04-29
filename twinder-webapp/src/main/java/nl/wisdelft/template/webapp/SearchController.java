/**
 * 
 */
package nl.wisdelft.template.webapp;

import nl.wisdelft.twinder.lucene.Searcher;

import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ktao
 *
 */
@Controller
public class SearchController {
	
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
		srequest.setQuery(srequest.getQuery() + " again");
		model.addAttribute("srequest", srequest); // get the raw query
		
		Searcher searcher = new Searcher();
		TopDocs tweets = searcher.search(srequest.getQuery());
		model.addAttribute("tweets", tweets.scoreDocs);
		return "results";
	}
}
