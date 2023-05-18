package view;

import java.util.List;

import bean.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;
import util.PrintUtils;

public class ItemGroupPage {
	private static ItemGroupService itemGroupService;
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}
	public static void main(String[] args) {
		System.out.println("****_______********");
//		save and update
		ItemGroup newig = new ItemGroup(4, "Áo", "Loại Hàng - Áo");
		itemGroupService.saveOrUpdate(newig);
//		update
//		ItemGroup upig = new ItemGroup(8, "Áo", "Loại Hàng - Áo");
//		itemGroupService.update(upig);
//		show tất cả
		List<ItemGroup> igAll = itemGroupService.getAll();
		PrintUtils.generate("C1 igAll", igAll);
//		find id
		PrintUtils.generate("C1 igById", itemGroupService.get(2));
		
		PrintUtils.generate("C1 igByName", itemGroupService.get("Áo"));
	}
}
