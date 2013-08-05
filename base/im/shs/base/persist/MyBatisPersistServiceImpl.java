package im.shs.base.persist;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

/**    
 *         
 * 类名称：MyBatisPersistServiceImpl    
 * 类描述：    
 * 创建人：MiniApp    
 * 创建时间：2013-8-4 上午9:35:07    
 * 修改人：MiniApp    
 * 修改时间：2013-8-4 上午9:35:07    
 * 修改备注：    
 * @version     
 *     
 */
@Service("mybatisPersist")
public class MyBatisPersistServiceImpl implements
		MyBatisPersistService {
	@Resource(name = "sqlSession")
	private SqlSessionTemplate sqlSession;
	/**    
	 * Method：	findList
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findList(String sqlMap, Object param) {
		return this.sqlSession.selectList(sqlMap, param);
	}
	@Override
	public void add(String sqlMap, Object param) {
		this.sqlSession.insert(sqlMap, param);
	}
}
