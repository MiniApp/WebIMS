package im.shs.base.persist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("persist")
public class PersistServiceImpl implements PersistService {
	@Resource(name = "mybatisPersistence")
	private MyBatisPersistService mybatisPersistence;
	
	@Resource(name = "jpaPersistence")
	private MyJpaPersistService jpaPersistence;

	@Override
	public <T> List<T> findList(String sqlMap, Object param) {
		return mybatisPersistence.findList(sqlMap, param);
	}

	@Override
	public void add(String sqlMap, Object param) {
		this.mybatisPersistence.add(sqlMap, param);
	}

	/**    
	 * Method：	batchMerge
	 * 
	 * Description：	
	 *			批量将实体对象合并
	 * @param  	objectsToMerge
	 *			待合并的对象集合
	 * @throws 	DataAccessException
	 *          当更新到数据库中发生异常时抛出
	 * @return	void    
	 * @since   
	 */
	@Override
	public void batchMerge(List<?> objectsToMerge) {
		jpaPersistence.batchMerge(objectsToMerge);
	}
	
	/**    
	 * Method：	find
	 * 
	 * Description：	
	 *			根据给定标识和实体类返回持久化对象的实例，如果没有符合条件的持久化对象实例则返回null
	 * @param  	entityClass
	 *			要加载的实体类 
	 * @param  	id
	 *			实体对象在数据表里的主键,该参数的实例类型必须符合对应持久对象的'ID'对应类型,否则无法执行查询
	 * @return	T 
	 * @since   
	 */
	@Override
	public <T> T find(Class<T> entityClass, Object id) {
		return jpaPersistence.find(entityClass, id);
	}
}
