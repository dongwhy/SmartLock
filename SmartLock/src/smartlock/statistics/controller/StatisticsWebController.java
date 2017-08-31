package smartlock.statistics.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import smartlock.member.vo.UserVO;
import smartlock.statistics.service.StatisticsMonthlyService;
import smartlock.statistics.service.StatisticsService;
import smartlock.statistics.vo.StatisticsMonthlyVO;
import smartlock.statistics.vo.StatisticsVO;

// TODO: StatisticsWebController 구현

@Controller
public class StatisticsWebController {

	@Resource(name = "statisticsService")
	private StatisticsService statisticsService;
	
	@Resource(name = "statisticsMonthlyService")
	private StatisticsMonthlyService statisticsMonthlyService;
	
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView statistics(HttpServletRequest request) throws Exception {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");
		StatisticsVO statistics = new StatisticsVO();

        if (userVO != null && userVO.getAuthority() == 1) {
            ModelAndView modelAndView = new ModelAndView("/smartlock/statistics");
            statistics = statisticsService.viewStatistics(userVO.getId());
            modelAndView.addObject("statistics", statistics);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(value = "/statistics/filter", method = RequestMethod.GET)
    public ModelAndView statisticsByName(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/statistics");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    
    /*
     * 라이센스 SW별로 통계 - 전체보기
     */
    @RequestMapping(value = "/statistics/monthly", method = RequestMethod.POST)
    public ModelAndView statisticsMonthly(HttpServletRequest request) throws Exception {
    	/*
    	 * 세션 얻기
    	 */
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) 
        {
        	/*
        	 * DB에서 1년치 라이센스 가져오기
        	 */
        	ArrayList<StatisticsMonthlyVO> dataList 
        		= statisticsMonthlyService.viewStatisticsMonthly(userVO.getCorpId());
        
        	HashMap<Integer, String> swList = new HashMap<Integer, String>();
    		GregorianCalendar cal = new GregorianCalendar();
    		int[] monthCnt = new int[12]; 
    		int swID;
    		
        	/*
        	 * DB에서 뽑은 데이터 월에 따라 배열에 담기
        	 */
        	for(StatisticsMonthlyVO vo : dataList)
        	{        		
        		cal.setTime(vo.getStart_date());
        		++monthCnt[cal.get(Calendar.MONTH)];
        		
        		/*
            	 * SW목록 뽑기
            	 */
        		swID = vo.getSw_id();
        		if(swList.get(swID) == null)
        			swList.put(swID, vo.getSw_name());
        		
        	}        	
        	
        	System.out.println("*****swList:" + swList);
        	ModelAndView modelAndView = new ModelAndView("/smartlock/statistics_monthly");
        	modelAndView.addObject("monthCnt", monthCnt);
        	modelAndView.addObject("swList",swList);
        	
            return modelAndView;    
        }
        else 
        {
            return new ModelAndView("redirect:/");
        }
    }
    
    @RequestMapping(value = "/statistics/monthly/filter", method = RequestMethod.POST)
    public ModelAndView statisticsMonthlyByName(HttpServletRequest request) 
    {
    	/*
    	 * 세션 얻기
    	 */
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO) httpSession.getAttribute("user");

        if (userVO != null && userVO.getAuthority() == 1) {
            return new ModelAndView("/smartlock/statistics_monthly");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
