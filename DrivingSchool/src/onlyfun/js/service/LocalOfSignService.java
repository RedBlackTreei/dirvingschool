package onlyfun.js.service;

import java.util.List;

import onlyfun.js.model.LocalOfSign;

/**
 *报名点管理
 * @version
 */
public interface LocalOfSignService {
	/**
	 * 获取报名点列表
	 * @return
	 * List<LocalOfSign> 报名点列表
	 */
	public List<LocalOfSign> getLocalOfSignList();

	/**
	 * 通过物品id获取报名点
	 * @param id 报名点id
	 * @return
	 * LocalOfSign 获得的物品
	 */
	public LocalOfSign getStockById(long id);

	/**
	 * 删除报名点
	 * @param los 报名点
	 * void
	 */
	public void deleteLocalOfSign(LocalOfSign los);

	/**
	 * 通过id删除报名点
	 * @param id
	 * void
	 */
	public void deleteLocalOfSignById(long id);

	/**
	 * 添加报名点
	 * @param los 报名点
	 * void
	 */
	public void addLocalOfSign(LocalOfSign los);

	/**
	 * 更新报名点
	 * @param los 报名点
	 * void
	 */
	public void updateLocalOfSign(LocalOfSign los);
}
