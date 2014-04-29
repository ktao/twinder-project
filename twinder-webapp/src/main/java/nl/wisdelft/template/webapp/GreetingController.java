/**
 * 
 */
package nl.wisdelft.template.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ktao
 *
 */
@Controller
public class GreetingController {

	/**
	 * ensures that HTTP requests to /greeting are mapped to the greeting() method.
	 * use @RequestMapping(method=GET) to narrow this mapping.
	 */
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}