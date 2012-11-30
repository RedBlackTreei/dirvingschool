package onlyfun.js.service.impl;

import java.util.List;

import javax.annotation.Resource;

import onlyfun.js.dao.LocalOfSignDao;
import onlyfun.js.model.LocalOfSign;
import onlyfun.js.service.LocalOfSignService;

import org.springframework.stereotype.Service;

/**
 * 报名点管理
 * @version  
 */
@Service
public class LocalOfSignServiceImpl implements LocalOfSignService {
	private LocalOfSignDao localOfSignDao;

	@Override
	public List<LocalOfSign> getLocalOfSignList() {
		List<LocalOfSign> localOfSigns = localOfSignDao.getLocal();
		return localOfSigns;
	}

	@Override
	public LocalOfSign getStockById(long id) {
		return localOfSignDao.getLocalById(id);
	}

	@Override
	public void deleteLocalOfSign(LocalOfSign los) {
		localOfSignDao.deleteLocal(los);
		
	}

	@Override
	public void deleteLocalOfSignById(long id) {
		localOfSignDao.deleteLocalById(id);
		
	}

	@Override
	public void addLocalOfSign(LocalOfSign los) {
		localOfSignDao.addLocal(los);
		
	}

	@Override
	public void updateLocalOfSign(LocalOfSign los) {
		localOfSignDao.updateLocal(los);
		
	}
	public LocalOfSignDao getLocalOfSignDao() {
		return localOfSignDao;
	}

	@Resource
	public void setLocalOfSignDao(LocalOfSignDao localOfSignDao) {
		this.localOfSignDao = localOfSignDao;
	}

}
