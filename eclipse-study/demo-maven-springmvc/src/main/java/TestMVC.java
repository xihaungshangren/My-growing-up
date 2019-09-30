import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestMVC {
	@RequestMapping("/hello")
	public ModelAndView test01() {
		ModelAndView mView = new ModelAndView("hello");
		mView.addObject("msg","spring mvc");
		return mView;
		
	}

}
