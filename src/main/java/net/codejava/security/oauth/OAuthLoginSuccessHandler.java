package net.codejava.security.oauth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.user.LogSignIn;
import net.codejava.user.LogSigninService;
import net.codejava.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import net.codejava.user.UserService;

@Component
public class OAuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired UserService userService;
	@Autowired
	LogSigninService logSigninService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		CustomOAuth2User oauth2User = (CustomOAuth2User) authentication.getPrincipal();
		String oauth2ServerAuthName = oauth2User.getOauth2ClientName();
		String username = oauth2User.getEmail();

		User user = userService.getUserByUserName(username);
		if(user == null){
			User newUser = new User();
			newUser.setUsername(username);
			userService.saveNewUser(newUser);
		}
		LogSignIn  log = new LogSignIn();
		log.setUsername(username);
		log.setLoginDate(new Date());
		log.setAuthServerName(oauth2ServerAuthName);
		logSigninService.saveNewLog(log);

		super.onAuthenticationSuccess(request, response, authentication);
	}

}
