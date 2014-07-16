/**
 * 
 */
package nl.wisdelft.template.webapp;

import java.util.Date;

import nl.wisdelft.twinder.redundancy.NearDuplicateDetectionDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ktao
 *
 */
@Controller
public class NDDDemoController {

//	@RequestMapping(value="/",method=RequestMethod.GET) 
//    public String index(Model model) {
//		model.addAttribute("tselection", new NDDTopicRequest());
//		model.addAttribute("topics", NearDuplicateDetectionDemo.getTopics());
//		return "nddtselect";
//	}
	
	/**
	 * The page for near duplicate detection demo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/nddtselect", method=RequestMethod.GET)
	public String nddtselectForm(Model model) {
		model.addAttribute("tselection", new NDDTopicRequest());
		model.addAttribute("topics", NearDuplicateDetectionDemo.getTopics());
		return "nddtselect";
	}
	
	@RequestMapping(value="/nddtselect", method=RequestMethod.POST)
	public String nddtselectForm(@ModelAttribute NDDTopicRequest tselection, Model model) {
		tselection.setTopicId(tselection.getTopicId());
		model.addAttribute("tselection", tselection); // get the raw query
		model.addAttribute("topics", NearDuplicateDetectionDemo.getTopics());
		
		Object[][] results = NearDuplicateDetectionDemo.demoNearDuplicateDetection(tselection.getTopicId());
		model.addAttribute("contents", results);
		Date start = new Date();
		Date end = new Date();
		double time = (double)(end.getTime() - start.getTime()) / 1000.000;
		model.addAttribute("time", time);
		model.addAttribute("number", results.length);
		return "nddresults";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
