/**    
 * Class Name：	
 *			MyJpaPersistServiceImpl.java
 * Version：	1.1   
 * Date：	2013-8-7       
 * Copyright	
 */
package im.shs.base.persist;

import im.shs.base.util.CollectionUtils;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Service;

/**    
 *         
 * Class Name：
 *			MyJpaPersistServiceImpl    
 * Description：    
 *			基于JPA的持久服务实现
 * @Author：	suhao    
 * @Date：	2013-8-7 下午6:16:13    
 * @version	
 *     
 */
@SuppressWarnings("deprecation")
@Service("jpaPersistence")
public class MyJpaPersistServiceImpl extends JpaDaoSupport implements MyJpaPersistService {
	protected static final Log logger = LogFactory
			.getLog(MyJpaPersistServiceImpl.class);

	@Autowired
	protected JpaTemplate createJpaTemplate(EntityManagerFactory entityManagerFactory){
		setJpaTemplate(new JpaTemplate(entityManagerFactory));
		return getJpaTemplate();
	}
	protected int batchSize = 10;
	private EntityManager em;

	/**    
	 * Method：	find
	 * 
	 * Description：	
	 *			根据给定标识和实体类返回持久化对象的实例，如果没有符合条件的持久化对象实例则返回null
	 * @param  	entityClass
	 *			要加载的实体类
	 *
	 * @param  	id
	 *			实体对象在数据表里的主键,该参数的实例类型必须符合对应持久对象的'ID'对应类型,否则无法执行查询
	 * @return	返回符合条件的持久对象
	 * @since   
	 */
	@Override
	public <T> T find(Class<T> entityClass, final Object id) {
		return em.find(entityClass, id);
	}

	/**    
	 * Method：	merge
	 * 
	 * Description：	
	 *			将给定的对象的状态复制到具有相同标识的持久化对象上
	 * @param  	entity
	 *			要合并的对象 
	 * @throws 	DataAccessException
	 *          当保存数据出现错误时产生
	 * @return	T
	 * @since   
	 */
	@Override
	public <T> T merge(final T entity) throws DataAccessException {
		return em.merge(entity);
	}

	/**    
	 * Method：	persist
	 * 
	 * Description：	
	 *			将一个自由状态（transient）的实例持久化
	 * @param  	objectToSave
	 *			要保存的实体对象实例
	 * @throws 	DataAccessException
	 *          当保存到数据库发生异常时抛出
	 * @return	void
	 * @since   
	 */
	@Override
	public void persist(Object objectToSave) throws DataAccessException {
		em.persist(objectToSave);
	}

	/**    
	 * Method：	remove
	 *
	 * Description：	
	 *			从数据库中移除持久化(persistent)对象的实例
	 * @param  	objectToRemove
	 *			要删除的持久对象实例
	 * @throws 	DataAccessException
	 *          在删除该对象发异常时抛出
	 * @return	void  
	 * @since   
	 */
	@Override
	public void remove(Object objectToRemove) throws DataAccessException {
		em.remove(objectToRemove);
	}

	/**    
	 * Method：	batchPersist
	 *
	 * Description：	
	 *			批量将实体对象插入到数据库中
	 * @param  	objectsToSave
	 *			待插入到数据库的对象集合
	 * @throws 	DataAccessException
	 *          当保存到数据库中发生异常时抛出
	 * @return	void
	 * @since   
	 */
	@Override
	public void batchPersist(final List<?> objectsToSave) throws DataAccessException {
		if (CollectionUtils.isEmpty(objectsToSave)) {
			return;
		}
		int max = objectsToSave.size();
		for (int i = 0; i < max; i++) {
			em.persist(objectsToSave.get(i));
			if ((i != 0 && i % batchSize == 0) || i == max - 1) {
				em.flush();
				//em.clear();
			}
		}
		/*getJpaTemplate().execute(new JpaCallback() {

			public Object doInJpa(EntityManager emr) throws PersistenceException {
				int max = objectsToSave.size();
				for (int i = 0; i < max; i++) {
					emr.persist(objectsToSave.get(i));
					if ((i != 0 && i % batchSize == 0) || i == max - 1) {
						emr.flush();
						//em.clear();
					}
				}
				return null;
			}

		});*/
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
	public void batchMerge(final List<?> objectsToMerge)
			throws DataAccessException {
		if (CollectionUtils.isEmpty(objectsToMerge)) {
			return;
		}
		int max = objectsToMerge.size();
		for (int i = 0; i < max; i++) {
			em.merge(objectsToMerge.get(i));
			if ((i != 0 && i % batchSize == 0) || i == max - 1) {
				em.flush();
			//	em.clear();
			}
		}
		/*getJpaTemplate().execute(new JpaCallback() {

			public Object doInJpa(EntityManager em) throws PersistenceException {
				int max = objectsToMerge.size();
				for (int i = 0; i < max; i++) {
					em.merge(objectsToMerge.get(i));
					if ((i != 0 && i % batchSize == 0) || i == max - 1) {
						em.flush();
					//	em.clear();
					}
				}
				return null;
			}

		});*/
	}

	/**    
	 * Method：	batchRemove
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public void batchRemove(List<?> objectsToRemove) {
		// TODO Auto-generated method stub
		
	}

	/**    
	 * Method：	findListByField
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findListByField(Class<T> entityClass, String field,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findListByField
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findListByField(Class<T> entityClass, String field,
			Object value, int start, int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findPaginatedByField
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> PaginationSupport<T> findPaginatedByField(Class<T> entityClass,
			String field, Object value, int start, int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	countByField
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public int countByField(Class<?> entityClass, String field, Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**    
	 * Method：	findObjectByField
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> T findObjectByField(Class<T> entityClass, String field,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findObjectByFields
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> T findObjectByFields(Class<T> entityClass, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findListByFields
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findListByFields(Class<T> entityClass,
			Map<String, ?> params, int start, int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findPaginatedByFields
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> PaginationSupport<T> findPaginatedByFields(Class<T> entityClass,
			Map<String, ?> params, int start, int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findListByFields
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findListByFields(Class<T> entityClass,
			Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	countByFields
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public int countByFields(Class<?> entityClass, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**    
	 * Method：	findByNamedQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNamedQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNamedQuery(String queryName, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNamedQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNamedQueryAndNamedParams(String name,
			Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNativeQuery(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNativeQuery(String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNativeQuery(String queryString, int start,
			int maxRows, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findByNativeQuery(Class<T> returnClass,
			String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findByNativeQuery(Class<T> returnClass,
			String queryString, int start, int maxRows, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findObjectByNativeQuery
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> T findObjectByNativeQuery(Class<T> returnClass,
			String queryString, Object... values) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNativeQueryAndNamedParams(String queryString,
			Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public List<?> findByNativeQueryAndNamedParams(String queryString,
			int start, int maxRows, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findByNativeQueryAndNamedParams(Class<T> returnClass,
			String queryString, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findByNativeQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> List<T> findByNativeQueryAndNamedParams(Class<T> returnClass,
			String queryString, int start, int maxRows, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	findObjectByNativeQueryAndNamedParams
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public <T> T findObjectByNativeQueryAndNamedParams(Class<T> returnClass,
			String queryString, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/**    
	 * Method：	flush
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	/**    
	 * Method：	clear
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/**    
	 * Method：	refresh
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public void refresh(Object objectToRefresh) {
		// TODO Auto-generated method stub
		
	}
	
}
