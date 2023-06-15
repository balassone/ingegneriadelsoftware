package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.EntityCentralino;

public class EntityCentralinoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistraEsitoChiamata() {
		//fail("Not yet implemented");
		boolean expected=true;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/12/2022", "15:30", "Telefonata Effettuata", 2, 1);
		assertEquals(expected,(ret>0));
	}
	
	@Test
	public void testRegistraEsitoChiamataDataNonValida() {
		//fail("Not yet implemented");
		int expected = -1;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/13/2022", "15:30", "Telefonata Effettuata", 2, 1);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testRegistraEsitoChiamataOraNonValida() {
		int expected = -2;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/12/2022", "25:30", "Telefonata Effettuata", 2, 1);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testRegistraEsitoChiamataNoteNonValide() {
		int expected = -3;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/12/2022", "12:30", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam tristique risus nec ipsum cursus, sit amet tincidunt ligula facilisis. Sed fringilla sem ac est congue bibendum. Sed dapibus justo auctor, consequat felis nec, dignissim velit. Sed tincidunt ultrices diam. Mauris eu enim non justo lobortis volutpat at vitae lectus. Cras eu orci at sapien faucibus feugiat. Nulla vulputate eleifend mi, ut ullamcorper lacus varius at. Mauris id massa porta, tristique libero eu, lacinia dui. Sed vitae diam dignissim, pretium sapien vel, ultricies nulla. Etiam efficitur viverra nulla, at facilisis lorem scelerisque sit amet. Nulla volutpat felis sed tortor rutrum vestibulum. Cras cursus mauris quis ante dapibus feugiat. Sed rhoncus congue leo, eget posuere risus tristique eu. Proin at orci nunc.Mauris id massa porta, tristique libero eu, lacinia dui. Sed vitae diam dignissim, pretium sapien vel, ultricies nulla. Etiam efficitur viverra nulla, at facilisis lorem scelerisque sit amet. Nulla volutpat felis sed tortor rutrum vestibulum. Cras cursus mauris quis ante dapibus feugiat. Sed rhoncus congue leo, eget posuere risus tristique eu. Proin at orci nunc.", 2, 1);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testRegistraEsitoChiamataEsitoNegativo() {
		int expected = -4;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/12/2022", "11:30", "Telefonata Effettuata", -1, 1);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testRegistraEsitoChiamataEsitoMaggiore() {
		int expected = -4;
		EntityCentralino singleton = EntityCentralino.getInstance();
		int ret = singleton.registraEsitoChiamata("11/12/2022", "11:30", "Telefonata Effettuata", 6, 1);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testCreaAppuntamentoCorretto() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		boolean expected = true;
		int ret=singleton.creaAppuntamento("12/12/2022","12:30","ABCDEF00D11H123N", 1);
		assertEquals(expected, (ret>0));
	}
	
	@Test
	public void testCreaAppuntamentoDataNV() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		int expected = -1;
		int ret=singleton.creaAppuntamento("33/13/2022","12:30","ABCDEF00D11H123N", 1);
		assertEquals(expected, ret);
		
	}
	
	@Test
	public void testCreaAppuntamentoOraNV() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		int expected = -2;
		int ret=singleton.creaAppuntamento("12/12/2022","25:30","ABCDEF00D11H123N", 1);
		assertEquals(expected, ret);
	}
	
	@Test
	public void testModificaNoteAppuntamento() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		boolean expected=true;
		int ret = singleton.modificaNoteAppuntamento("ABCDEF00D11H123N", 1, "Appuntamentos", 0);
		assertEquals(expected,(ret>0));
	}
	
	@Test
	public void testModificaNoteAppuntamentoNoteNV() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		int expected = -1;
		int ret = singleton.modificaNoteAppuntamento("ABCDEF00D11H123N", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam tristique risus nec ipsum cursus, sit amet tincidunt ligula facilisis. Sed fringilla sem ac est congue bibendum. Sed dapibus justo auctor, consequat felis nec, dignissim velit. Sed tincidunt ultrices diam. Mauris eu enim non justo lobortis volutpat at vitae lectus. Cras eu orci at sapien faucibus feugiat. Nulla vulputate eleifend mi, ut ullamcorper lacus varius at. Mauris id massa porta, tristique libero eu, lacinia dui. Sed vitae diam dignissim, pretium sapien vel, ultricies nulla. Etiam efficitur viverra nulla, at facilisis lorem scelerisque sit amet. Nulla volutpat felis sed tortor rutrum vestibulum. Cras cursus mauris quis ante dapibus feugiat. Sed rhoncus congue leo, eget posuere risus tristique eu. Proin at orci nunc.Mauris id massa porta, tristique libero eu, lacinia dui. Sed vitae diam dignissim, pretium sapien vel, ultricies nulla. Etiam efficitur viverra nulla, at facilisis lorem scelerisque sit amet. Nulla volutpat felis sed tortor rutrum vestibulum. Cras cursus mauris quis ante dapibus feugiat. Sed rhoncus congue leo, eget posuere risus tristique eu. Proin at orci nunc.", 0);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testModificaNoteAppuntamentoEsitoGrande() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		int expected = -2;
		int ret = singleton.modificaNoteAppuntamento("ABCDEF00D11H123N", 1, "Appuntamentos", 3);
		assertEquals(expected,ret);
	}
	
	@Test
	public void testModificaNoteAppuntamentoEsitoPiccolo() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		int expected = -2;
		int ret = singleton.modificaNoteAppuntamento("ABCDEF00D11H123N", 1, "Appuntamentos", -1);
		assertEquals(expected,ret);
	}

	
}
