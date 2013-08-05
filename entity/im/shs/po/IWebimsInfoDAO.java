package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsInfoDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfo entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfo entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfo entity);

	/**
	 Delete a persistent WebimsInfo entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfo entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfo entity);

	/**
	 Persist a previously saved WebimsInfo entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfo entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfo entity to update
	 @return WebimsInfo the persisted WebimsInfo entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfo update(WebimsInfo entity);

	public WebimsInfo findById(Integer id);

	/**
	* Find all WebimsInfo entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfo property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfo> found by query
	*/
	public List<WebimsInfo> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByNodeId(Object nodeId,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByPriority(Object priority,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByIsWithImage(Object isWithImage,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByViews(Object views,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByDownloads(Object downloads,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByComments(Object comments,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByStatus(Object status,
			int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP1(Object p1, int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP2(Object p2, int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP3(Object p3, int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP4(Object p4, int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP5(Object p5, int... rowStartIdxAndCount);

	public List<WebimsInfo> findByP6(Object p6, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfo entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfo> all WebimsInfo entities
	 */
	public List<WebimsInfo> findAll(int... rowStartIdxAndCount);
}