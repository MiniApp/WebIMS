/**    
 * Class Name：	
 *			MyJpaPersistServiceImpl.java
 * Version：	1.1   
 * Date：	2013-8-7       
 * Copyright	
 */
package im.shs.base.persist;

import javax.persistence.EntityManager;

/**    
 *         
 * Class Name：
 *			MyJpaPersistServiceImpl    
 * Description：    
 *			描述
 * @Author：	suhao    
 * @Date：	2013-8-7 下午6:16:13    
 * @version	
 *     
 */
public class MyJpaPersistServiceImpl implements MyJpaPersistService {
	private EntityManager em;

	public void save(Object entity) {
		em.persist(entity);
	}
}
