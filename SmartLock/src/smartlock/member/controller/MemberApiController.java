package smartlock.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import smartlock.member.service.UserService;
import smartlock.member.vo.LoginReqVO;
import smartlock.member.vo.SignupReqVO;
import smartlock.member.vo.UserIdReqVO;
import smartlock.common.vo.DataResVO;

import javax.annotation.Resource;

@Controller
public class MemberApiController {

    @Resource
    private UserService userService;

    /**
     * 로그인
     * @param loginReqVO 로그인 정보
     * @return 성공시 UserInfoVO
     */
    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO loginPost(
            @RequestBody LoginReqVO loginReqVO) {
        DataResVO dataResVO = new DataResVO();

        try {
            if (userService.checkPassword(loginReqVO)) {
                dataResVO.setStatus("success");
                dataResVO.setData(userService.getUserInfoVO(loginReqVO.getId()));
            } else {
                // TODO: 비밀번호가 틀렸을 때
                dataResVO.setStatus("success");
                dataResVO.setData(null);
            }
        } catch (Exception e) {
            dataResVO.setStatus("error");
            dataResVO.setData("error");
        }

        return dataResVO;
    }

    /**
     * 아이디 중복 체크
     * @param userIdReqVO 아이디
     * @return DataResVO
     */
    @RequestMapping(
            value="/check/id",
            method=RequestMethod.GET
    )
    public @ResponseBody DataResVO checkId(
            UserIdReqVO userIdReqVO){
        DataResVO dataResVO = new DataResVO();

        try {
            if(userService.existId(userIdReqVO.getId())) {
                dataResVO.setStatus("success");
                dataResVO.setData("no");
            } else {
                dataResVO.setStatus("success");
                dataResVO.setData("ok");
            }
        } catch (Exception e) {
            dataResVO.setStatus("error");
            dataResVO.setData("error");
        }

        return dataResVO;
    }

    /**
     * 회원가입
     * @param signupReqVO 회원가입 계정 정보
     * @return UserVO
     */
    @RequestMapping(
            value = "/signup",
            method = RequestMethod.POST
    )
    public @ResponseBody DataResVO signupPost(
            @RequestBody SignupReqVO signupReqVO) {
        DataResVO dataResVO = new DataResVO();

        try {
            if (userService.signup(signupReqVO)) {
                dataResVO.setStatus("success");
                dataResVO.setData(userService.getUserInfoVO(signupReqVO.getId()));
            } else {
                dataResVO.setStatus("success");
                dataResVO.setData(null);
            }
        } catch (Exception e) {
            dataResVO.setStatus("error");
            dataResVO.setData("error");
        }

        return dataResVO;
    }
}
