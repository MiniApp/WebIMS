package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsNodeDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsNodeDAO {
	/**
	Perform an initial save of a previously unsaved WebimsNode entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsNodeDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNode entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNode entity);

	/**
	 Delete a persistent WebimsNode entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsNodeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNode entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNode entity);

	/**
	 Persist a previously saved WebimsNode entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNode entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsNodeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNode entity to update
	 @return WebimsNode the persisted WebimsNode entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNode update(WebimsNode entity);

	public WebimsNode findById(Integer id);

	/**
	* Find all WebimsNode entities with a specific property value.  
	
	 @param propertyName the name of the WebimsNode property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsNode> found by query
	*/
	public List<WebimsNode> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByParentId(Object parentId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByNodeModelId(Object nodeModelId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByInfoModelId(Object infoModelId,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByNumber(Object number,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsNode> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByViews(Object views,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByIsRealNode(Object isRealNode,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByIsHidden(Object isHidden,
			int... rowStartIdxAndCount);

	public List<WebimsNode> findByP1(Object p1, int... rowStartIdxAndCount);

	public List<WebimsNode> findByP2(Object p2, int... rowStartIdxAndCount);

	public List<WebimsNode> findByP3(Object p3, int... rowStartIdxAndCount);

	public List<WebimsNode> findByP4(Object p4, int... rowStartIdxAndCount);

	public List<WebimsNode> findByP5(Object p5, int... rowStartIdxAndCount);

	public List<WebimsNode> findByP6(Object p6, int... rowStartIdxAndCount);

	public List<WebimsNode> findByRefers(Object refers,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsNode entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNode> all WebimsNode entities
	 */
	public List<WebimsNode> findAll(int... rowStartIdxAndCount);
}