package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsModelFieldDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsModelFieldDAO {
	/**
	Perform an initial save of a previously unsaved WebimsModelField entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsModelFieldDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModelField entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModelField entity);

	/**
	 Delete a persistent WebimsModelField entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsModelFieldDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModelField entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModelField entity);

	/**
	 Persist a previously saved WebimsModelField entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModelField entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsModelFieldDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModelField entity to update
	 @return WebimsModelField the persisted WebimsModelField entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModelField update(WebimsModelField entity);

	public WebimsModelField findById(Integer id);

	/**
	* Find all WebimsModelField entities with a specific property value.  
	
	 @param propertyName the name of the WebimsModelField property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsModelField> found by query
	*/
	public List<WebimsModelField> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsModelField> findByModelId(Object modelId,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByType(Object type,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByInnerType(Object innerType,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByLabel(Object label,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByPrompt(Object prompt,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByDevalue(Object devalue,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByIsRequired(Object isRequired,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	public List<WebimsModelField> findByIsDblColumn(Object isDblColumn,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsModelField entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModelField> all WebimsModelField entities
	 */
	public List<WebimsModelField> findAll(int... rowStartIdxAndCount);
}