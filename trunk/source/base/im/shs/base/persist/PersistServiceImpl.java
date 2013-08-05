package im.shs.base.persist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("persist")
public class PersistServiceImpl implements PersistService {
	@Resource(name = "mybatisPersist")
	private MyBatisPersistService batis;

	@Override
	public <T> List<T> findList(String sqlMap, Object param) {
		return batis.findList(sqlMap, param);
	}

	@Override
	public void add(String sqlMap, Object param) {
		this.batis.add(sqlMap, param);
	}
}
