package smartlock.profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import smartlock.member.service.UserService;
import smartlock.member.vo.*;
import smartlock.profile.service.ProfileService;
import smartlock.profile.vo.PasswordVO;
import smartlock.common.vo.DataResVO;
import smartlock.common.vo.MsgResVO;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileApiController {
	
	@Resource
    private ProfileService profileService;

	/**
	 * 프로필 업데이트
	 * @param userVO {@link UserVO#id},
	 *               {@link UserVO#email},
	 *               {@link UserVO#phone_number}
	 * @return 성공시 "회원정보 수정이 완료되었습니다.", 실패시 "error"
	 */	
	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO updateProfile(
			@RequestBody UserVO userVO,
			HttpServletRequest request) {

		return new MsgResVO(request, sessionUserVO -> {
			profileService.updateUser(userVO);
			return "회원정보 수정이 완료되었습니다.";
		});
	}
	
	/**
	 * 비밀번호 체크
	 * @param userVO {@link UserVO#id},
	 *               {@link UserVO#password}
	 * @return 성공시 "비밀번호 일치", 실패시 "비밀번호 불일치"
	 */
	@RequestMapping(value = "/profile/checkPassword", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO checkPassword(
			@RequestBody UserVO userVO,
			HttpServletRequest request) {

		return new MsgResVO(request, sessionUserVO -> {
			boolean checkpassword = profileService.checkPassword(userVO);
			return checkpassword ? "비밀번호 일치" : "비밀번호 불일치";
		});
	}

	/**
	 * 비밀번호 변경
	 * @param userVO {@link UserVO#id},
	 *               {@link UserVO#password}
	 * @return 성공시 "비밀번호 수정이 완료되었습니다.", 실패시 "error"
	 */
	@RequestMapping(value = "/profile/change/success", method = RequestMethod.POST)
	public  @ResponseBody MsgResVO changeNewPassword(
			@RequestBody UserVO userVO,
			HttpServletRequest request) {
		
		return new MsgResVO(request, sessionUserVO -> {
			boolean checkpassword = profileService.checkPassword(userVO);
			return checkpassword ? "비밀번호 일치" : "비밀번호 불일치";
		});
	}
	
	// /profile/checkPassword
}
