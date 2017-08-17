package smartlock.statistics.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smartlock.common.vo.DataResVO;
import smartlock.statistics.service.StatisticsService;
import smartlock.statistics.vo.StatisticsVO;

@Controller
public class StatisticsApiController {

	
	@Resource(name="statisticsService")
	private StatisticsService statisticsService;

	@RequestMapping(
			value = "/statistics",
			method = RequestMethod.POST
			)
	public @ResponseBody DataResVO viewUserLicense(
			HttpServletRequest request) throws Exception{

		return new DataResVO(request, userVO -> {
			if (userVO == null) return null;

			StatisticsVO statistics = new StatisticsVO();

			statistics = statisticsService.viewStatistics(userVO.getId());

			System.out.println(statistics);

			return statistics;
		});

		/*
		DataResVO dataResVO = new DataResVO();
		StatisticsVO statistics = new StatisticsVO();

		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		statistics = statisticsService.viewStatistics(userVO.getId());

		try{
			System.out.println(statistics);
				dataResVO.setStatus("success");
				dataResVO.setData(statistics);
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		return dataResVO;
		*/
	}

	@RequestMapping(
			value = "/statistics/filter",
			method = RequestMethod.POST
			)
	public @ResponseBody DataResVO viewUserLicense(
			@RequestParam("name") String name,
			HttpServletRequest request) throws Exception{

		return new DataResVO(request, userVO -> {
			if (userVO == null) return null;

			StatisticsVO statistics = new StatisticsVO();

			Map<String, String> map = new HashMap<String, String>();
			map.put("id", userVO.getId());
			//map.put("id", "chelsea");
			map.put("name", name);

			statistics = statisticsService.viewStatisticsMyName(map);

			System.out.println(statistics);

			return statistics;
		});

		/*
		DataResVO dataResVO = new DataResVO();
		StatisticsVO statistics = new StatisticsVO();

		HttpSession httpSession = request.getSession();
		UserVO userVO = (UserVO) httpSession.getAttribute("user");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userVO.getId());
		//map.put("id", "chelsea");
		map.put("name", name);

		statistics = statisticsService.viewStatisticsMyName(map);

		try{
			System.out.println(statistics);
				dataResVO.setStatus("success");
				dataResVO.setData(statistics);
		} catch(Exception e){
			dataResVO.setStatus("error");
			dataResVO.setData("error");
		}
		return dataResVO;
		*/
	}
}
