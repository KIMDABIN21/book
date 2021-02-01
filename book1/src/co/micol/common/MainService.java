package co.micol.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainService implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		//
		return "main/main";
	}

}
