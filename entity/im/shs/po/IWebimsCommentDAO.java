package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsCommentDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsCommentDAO {
	/**
	Perform an initial save of a previously unsaved WebimsComment entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsCommentDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsComment entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsComment entity);

	/**
	 Delete a persistent WebimsComment entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsCommentDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsComment entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsComment entity);

	/**
	 Persist a previously saved WebimsComment entity and return it or a copy of it to the sender. 
	 A copy of the WebimsComment entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsCommentDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsComment entity to update
	 @return WebimsComment the persisted WebimsComment entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsComment update(WebimsComment entity);

	public WebimsComment findById(Integer id);

	/**
	* Find all WebimsComment entities with a specific property value.  
	
	 @param propertyName the name of the WebimsComment property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsComment> found by query
	*/
	public List<WebimsComment> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsComment> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByAuditorId(Object auditorId,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByFtype(Object ftype,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByFid(Object fid, int... rowStartIdxAndCount);

	public List<WebimsComment> findByScore(Object score,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByStatus(Object status,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByText(Object text,
			int... rowStartIdxAndCount);

	public List<WebimsComment> findByIp(Object ip, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsComment entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsComment> all WebimsComment entities
	 */
	public List<WebimsComment> findAll(int... rowStartIdxAndCount);
}