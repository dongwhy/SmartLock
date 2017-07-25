package smartlock.common;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("commonDAO")
public class CommonDAO extends SqlSessionDaoSupport{
	
	@Resource(name="sqlSession")
	public void setSuperSqlMapClient(SqlSessionTemplate sqlSessionTemplate) throws Exception {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
	/**
	 * ����� �������� ����� �Ѵ�
	 * @param sql 
	 * @param paramVO ����� �������� ���� �ʿ��� VO
	 * @return List<Object> ��� ����� ��ȯ�Ѵ�
	 */
	public List<Object> selectList(String sql, Object paramVO) throws Exception {
		return getSqlSession().selectList(sql, paramVO);
	}
		
	/**
	 * �������� Object���·� ��ȯ�Ѵ�.
	 * @param sql
	 * @param paramVO
	 * @return
	 */
	public Object selectOne(String sql, Object paramVO) throws Exception {
		return getSqlSession().selectOne(sql, paramVO);
	}
	
	/**
	 * �׸��� ����ϴ� ����� �Ѵ�
	 * @param sql
	 * @param paramVO
	 * @return ������ null / ���н� ����
	 */
	public int insert(String sql, Object paramVO) throws Exception {
		return getSqlSession().insert(sql, paramVO);
	}
	
	/**
	 * �׸��� �����ϴ� ����� �Ѵ�
	 * @param sql
	 * @param paramVO
	 * @return ������ 1 / ���н� 0
	 */
	public int update(String sql, Object paramVO) throws Exception {
		return getSqlSession().update(sql, paramVO);
	}
	
	/**
	 * �׸��� �����ϴ� ����� �Ѵ�
	 * @param sql
	 * @param paramVO
	 * @return ������ row���� ��ȯ�Ѵ�
	 */
	public int delete(String sql, Object paramVO) throws Exception {
		return getSqlSession().delete(sql, paramVO);
	}
}
