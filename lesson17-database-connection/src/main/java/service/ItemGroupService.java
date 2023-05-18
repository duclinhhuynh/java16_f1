package service;

import java.util.List;

import bean.ItemGroup;

//Dùng để view gọi khi view gọi đến service ,service gọi đến DAO
public interface ItemGroupService {
	List<ItemGroup> getAll();
	
	ItemGroup get(int id);
	
	ItemGroup get(String name);
	
	void save(ItemGroup id);
	
	void update(ItemGroup ig);
	
	void saveOrUpdate(ItemGroup ig);
}
