package smartlock.license.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import smartlock.member.service.UserService;
import smartlock.member.vo.*;
import smartlock.common.vo.DataResVO;
import smartlock.license.service.LicenseService;
import smartlock.license.vo.LicenseUserReqVO;
import smartlock.license.vo.LicenseUserVO;
import smartlock.license.vo.LicenseVO;
import smartlock.license.vo.ReqLicenseVO;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LicenseApiController {
	
	
	@Resource(name="licenseService")
	private LicenseService licenseService;

   
    /**
     * 개인 라이센스 전체 조회
     * @param UserVO 정보
     * @return DataResVO
     */
    @RequestMapping(
            value = "/license/user",
            method = RequestMethod.GET
    )
    public @ResponseBody DataResVO test(
            HttpServletRequest request) throws Exception {
        DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserVO> license = new ArrayList<LicenseUserVO>();
		//dataResVO = licenseService.viewUserLicense(userVO.getId());
		license = licenseService.viewUserLicense("swan");
		
		try{
			System.out.println(license);
			if(license.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(license);
			}
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		
        return dataResVO;
    }
    
    /**
     * 개인 라이센스 소프트웨어명 별로 조회
     * @param UserVo, name (소프트웨어명)
     * @return DataResVO
     */
    @RequestMapping(
            value = "/license/user/filter",
            method = RequestMethod.GET
    )
    public @ResponseBody DataResVO viewUserLicenseByName(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {
        DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserVO> license = new ArrayList<LicenseUserVO>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		//map.put("id", userVO.getId());
		map.put("id", "swan");
		
		license = licenseService.viewUserLicenseByName(map);
		
		try{
			System.out.println(license);
			if(license.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(license);
			}
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
        return dataResVO;
    }
    
    /**
     * 개인 요청 라이센스 전체 조회
     * @param UserVO 정보 
     * @return 성공시 DataResVO 
     */
    @RequestMapping(
            value = "/license/user/request",
            method = RequestMethod.GET
    )
    public @ResponseBody DataResVO viewUserReqLicense(
            HttpServletRequest request) throws Exception {
        DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<LicenseUserReqVO> license = new ArrayList<LicenseUserReqVO>();
		//dataResVO = licenseService.viewUserLicense(userVO.getId())
		license = licenseService.viewUserReqLicense("madrid");
		
		try{
			System.out.println(license);
			if(license.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(license);
			}
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
        return dataResVO;
    }

    /**
     * 개인 요청 라이센스 전체 조회
     * @param UserVO 정보 
     * @return 성공시 DataResVO 
     */
    @RequestMapping(
            value = "/license/user/request/filter",
            method = RequestMethod.GET
    )
    public @ResponseBody DataResVO viewUserReqLiceneByName(
    		@RequestParam("name") String name,
            HttpServletRequest request) throws Exception {
        DataResVO dataResVO = new DataResVO();
        
        HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		ArrayList<ReqLicenseVO> license = new ArrayList<ReqLicenseVO>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		//map.put("id", userVO.getId());
		map.put("id", "swan");
		license = licenseService.viewUserReqLicenseByName(map);
		
		try{
			System.out.println(license);
			if(license.isEmpty()) {
				dataResVO.setStatus("success");
				dataResVO.setData(null);
			} else {
				dataResVO.setStatus("success");
				dataResVO.setData(license);
			}
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
        return dataResVO;
    }
    
}
