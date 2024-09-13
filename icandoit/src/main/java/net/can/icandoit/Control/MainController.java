package net.can.icandoit.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	@GetMapping("/signIn")
	public String signin(Model model) {
		return "login";
	}
	@GetMapping("/signUp")
	public String signup(Model model) {
		return "join";
	}
	@GetMapping("/inquiry")
	public String inquiry(Model model) {
		return "inquiry_answer";
	}
	@PostMapping("/board")
	public String board() {
		return "boardMain";
	}
}
