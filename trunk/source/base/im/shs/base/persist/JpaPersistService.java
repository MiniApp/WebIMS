package im.shs.base.persist;

import java.util.List;

public interface JpaPersistService {
	public <T> List<T> findList(String sqlMap, Object param);
	public void add(String sqlMap, Object param);
}
