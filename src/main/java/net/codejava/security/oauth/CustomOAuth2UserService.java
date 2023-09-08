package net.codejava.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {
	/*loadUser Trả về OAuth2User sau khi lấy thuộc tính người dùng. Custom để return CustomOAuth2User. CustomOAuth2User 1 lớp con tự viết của OAuth2User nhằm thêm type xem là đăng nhập bằng facebook hay google */
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		String clientName = userRequest.getClientRegistration().getClientName();
		OAuth2User user =  super.loadUser(userRequest);
		return new CustomOAuth2User(user, clientName);
	}

}
