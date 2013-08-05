package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsModelField entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsModelField
  * @author MyEclipse Persistence Tools 
 */

public class WebimsModelFieldDAO implements IWebimsModelFieldDAO {
	// property constants
	public static final String MODEL_ID = "modelId";
	public static final String TYPE = "type";
	public static final String INNER_TYPE = "innerType";
	public static final String LABEL = "label";
	public static final String NAME = "name";
	public static final String PROMPT = "prompt";
	public static final String DEVALUE = "devalue";
	public static final String IS_REQUIRED = "isRequired";
	public static final String SEQ = "seq";
	public static final String IS_DBL_COLUMN = "isDblColumn";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsModelField entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsModelFieldDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModelField entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModelField entity) {
		EntityManagerHelper.log("saving WebimsModelField instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsModelField entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsModelFieldDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModelField entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModelField entity) {
		EntityManagerHelper.log("deleting WebimsModelField instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsModelField.class,
					entity.getModefielId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsModelField entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModelField entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsModelFieldDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModelField entity to update
	 @return WebimsModelField the persisted WebimsModelField entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModelField update(WebimsModelField entity) {
		EntityManagerHelper.log("updating WebimsModelField instance",
				Level.INFO, null);
		try {
			WebimsModelField result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsModelField findById(Integer id) {
		EntityManagerHelper.log("finding WebimsModelField instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsModelField instance = getEntityManager().find(
					WebimsModelField.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsModelField entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsModelField property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsModelField> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsModelField> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsModelField instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsModelField model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<WebimsModelField> findByModelId(Object modelId,
			int... rowStartIdxAndCount) {
		return findByProperty(MODEL_ID, modelId, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByType(Object type,
			int... rowStartIdxAndCount) {
		return findByProperty(TYPE, type, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByInnerType(Object innerType,
			int... rowStartIdxAndCount) {
		return findByProperty(INNER_TYPE, innerType, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByLabel(Object label,
			int... rowStartIdxAndCount) {
		return findByProperty(LABEL, label, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByPrompt(Object prompt,
			int... rowStartIdxAndCount) {
		return findByProperty(PROMPT, prompt, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByDevalue(Object devalue,
			int... rowStartIdxAndCount) {
		return findByProperty(DEVALUE, devalue, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByIsRequired(Object isRequired,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_REQUIRED, isRequired, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findBySeq(Object seq,
			int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	public List<WebimsModelField> findByIsDblColumn(Object isDblColumn,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_DBL_COLUMN, isDblColumn, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsModelField entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModelField> all WebimsModelField entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsModelField> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsModelField instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsModelField model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}