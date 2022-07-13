package com.shopme.admin.user;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin","manager everything");
		Role savedRole = repo.save(roleAdmin);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleSaleperson = new Role("Saleperson","manage product price,"+" customer, shipping, orders and sales report");
		Role roleEditor = new Role("Editor","manage categories, brand,"+"products, articles and menus");
		Role roleShipper = new Role("Shipper","view products, view orders "+"and update order status");
		Role roleAssistant = new Role("Assistant","manage questions and reviews");
		
		repo.saveAll(List.of(roleSaleperson,roleEditor,roleShipper,roleAssistant));
	}
}














