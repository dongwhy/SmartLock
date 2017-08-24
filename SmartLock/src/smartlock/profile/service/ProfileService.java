package smartlock.profile.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import smartlock.common.CommonDAO;
import smartlock.common.Util;
import smartlock.member.vo.UserInfoVO;
import smartlock.member.vo.UserVO;
import smartlock.profile.vo.PasswordVO;
import smartlock.member.vo.LoginReqVO;
import smartlock.member.vo.SignupReqVO;

@Service
public class ProfileService {
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
		
	/**회원정보 수정(UPDATE)
	 * 
	 * @param UserVO
	 * @return void
	 * @throws Exception DAO 예외
	 */
	 public int updateUser(UserVO userVO) throws Exception{
		 userVO.setPassword(Util.encrypt(userVO.getPassword()));
		 
		 int result = commonDAO.update("user.updateUser", userVO);
		 System.out.println(result+"개의 회원정보가 업데이트 되었습니다.");
		 
		 return result;
	 }
	 
	 /**새 비밀번호 변경(UPDATE)
		 * 
		 * @param UserVO
		 * @return void
		 * @throws Exception DAO 예외
		 */
	 public int changePasswordUser(PasswordVO passwordVO) throws Exception{
		// 비밀번호 암호화
		 passwordVO.setPassword(Util.encrypt(passwordVO.getPassword()));
		 passwordVO.setNew_password(Util.encrypt(passwordVO.getNew_password()));
		 
		 int result = commonDAO.update("user.changePassword", passwordVO);
		 System.out.println(result+"개의 회원의 비밀번호가 업데이트 되었습니다.");
		 
		 return result;
	 }
}
