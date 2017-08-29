package smartlock.software.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import smartlock.common.CommonDAO;
import smartlock.software.vo.SoftwareReqVO;
import smartlock.software.vo.SoftwareVO;

@Service
public class SoftwareService {

    @Resource(name="commonDAO")
    private CommonDAO commonDAO;

    /**
     * 소프트웨어 목록 조회
     * @param softwareVO {@link SoftwareVO#sw_name}
     * @return 결과 List
     * @throws Exception DAO Exception
     */
    public ArrayList<SoftwareVO> softwareList() throws Exception {
        return (ArrayList) commonDAO.selectList("software.softwareList", null);
    }
   
    
    /**
     * 소프트웨어 목록 조회
     * @param id 소프트웨어 아이디
     * @return
     * @throws Exception
     */
    public SoftwareReqVO softwareRequest(String id) throws Exception {
    	return (SoftwareReqVO) commonDAO.selectOne("software.softwareSelect", id);
    }
    
    /**
     * 소프트웨어 목록 조회
     * @param id corp 아이디
     * @return
     * @throws Exception
     */
    public ArrayList<SoftwareVO> softwareListByCorp(String corpId) throws Exception {
    	return (ArrayList)commonDAO.selectList("software.selectByCorp", corpId);
    }
}
