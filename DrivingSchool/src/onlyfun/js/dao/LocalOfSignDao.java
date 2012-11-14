package onlyfun.js.dao;

import java.util.List;

import onlyfun.js.model.LocalOfSign;

/**
 * 报名点管理操作
 */
public interface LocalOfSignDao {
	/**
	 * 获取报名点列表
	 */
	public List<LocalOfSign> getLocal();

	/**
	 * 通过id获取报名点信息
	 */
	public LocalOfSign getLocalById(long localId);

	/**
	 * 更新报名点信息
	 */
	public void updateLocal(LocalOfSign local);

	/**
	 * 删除报名点
	 */
	public void deleteLocalById(long localId);

	/**
	 * 删除报名点
	 */
	public void deleteLocal(LocalOfSign local);

	/**
	 * 添加报名点
	 */
	public void addLocal(LocalOfSign local);
}
