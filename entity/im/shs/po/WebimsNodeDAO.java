package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsNode entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsNode
  * @author MyEclipse Persistence Tools 
 */

public class WebimsNodeDAO implements IWebimsNodeDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String PARENT_ID = "parentId";
	public static final String CREATOR_ID = "creatorId";
	public static final String NODE_MODEL_ID = "nodeModelId";
	public static final String WORKFLOW_ID = "workflowId";
	public static final String INFO_MODEL_ID = "infoModelId";
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String TREE_NUMBER = "treeNumber";
	public static final String TREE_LEVEL = "treeLevel";
	public static final String TREE_MAX = "treeMax";
	public static final String VIEWS = "views";
	public static final String IS_REAL_NODE = "isRealNode";
	public static final String IS_HIDDEN = "isHidden";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String P4 = "p4";
	public static final String P5 = "p5";
	public static final String P6 = "p6";
	public static final String REFERS = "refers";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsNode entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsNodeDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNode entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNode entity) {
		EntityManagerHelper.log("saving WebimsNode instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsNode entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsNodeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNode entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNode entity) {
		EntityManagerHelper.log("deleting WebimsNode instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsNode.class,
					entity.getNodeId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsNode entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNode entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsNodeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNode entity to update
	 @return WebimsNode the persisted WebimsNode entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNode update(WebimsNode entity) {
		EntityManagerHelper.log("updating WebimsNode instance", Level.INFO,
				null);
		try {
			WebimsNode result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsNode findById(Integer id) {
		EntityManagerHelper.log("finding WebimsNode instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsNode instance = getEntityManager().find(WebimsNode.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsNode entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsNode property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsNode> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsNode> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsNode instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsNode model where model."
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

	public List<WebimsNode> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByParentId(Object parentId,
			int... rowStartIdxAndCount) {
		return findByProperty(PARENT_ID, parentId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount) {
		return findByProperty(CREATOR_ID, creatorId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByNodeModelId(Object nodeModelId,
			int... rowStartIdxAndCount) {
		return findByProperty(NODE_MODEL_ID, nodeModelId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount) {
		return findByProperty(WORKFLOW_ID, workflowId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByInfoModelId(Object infoModelId,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_MODEL_ID, infoModelId, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByNumber(Object number,
			int... rowStartIdxAndCount) {
		return findByProperty(NUMBER, number, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByName(Object name, int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_NUMBER, treeNumber, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_LEVEL, treeLevel, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_MAX, treeMax, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByViews(Object views,
			int... rowStartIdxAndCount) {
		return findByProperty(VIEWS, views, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByIsRealNode(Object isRealNode,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_REAL_NODE, isRealNode, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByIsHidden(Object isHidden,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_HIDDEN, isHidden, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP1(Object p1, int... rowStartIdxAndCount) {
		return findByProperty(P1, p1, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP2(Object p2, int... rowStartIdxAndCount) {
		return findByProperty(P2, p2, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP3(Object p3, int... rowStartIdxAndCount) {
		return findByProperty(P3, p3, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP4(Object p4, int... rowStartIdxAndCount) {
		return findByProperty(P4, p4, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP5(Object p5, int... rowStartIdxAndCount) {
		return findByProperty(P5, p5, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByP6(Object p6, int... rowStartIdxAndCount) {
		return findByProperty(P6, p6, rowStartIdxAndCount);
	}

	public List<WebimsNode> findByRefers(Object refers,
			int... rowStartIdxAndCount) {
		return findByProperty(REFERS, refers, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsNode entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNode> all WebimsNode entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsNode> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsNode instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsNode model";
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