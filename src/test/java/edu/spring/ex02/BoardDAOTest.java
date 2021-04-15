package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BoardDAOTest.class);

	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelectAll();
//		testSelectBno();
//		testDeleteBno();
//		testSelectToT();
		testCriteria();
	}


	private void testInsert() {
		BoardVO vo = new BoardVO(0, "테스트", "테스트", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else {
			LOGGER.info("insert 실패");
		}
	}
	private void testCriteria() {
		PageCriteria c = new PageCriteria();
		List<BoardVO> list = dao.select(c);
		for(BoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	private void testSelectAll() {
		List<BoardVO> list = dao.select();
		for(BoardVO vo : list) {
			LOGGER.info(vo.toString());
			
		}
				
	}
	private void testSelectBno() {
		BoardVO vo = dao.select(1);
		LOGGER.info(vo.toString());
	}
	
	private void testDeleteBno() {
		int result = dao.delete(1);
		if(result == 1) {
			LOGGER.info("delete 성공");
		} else {
			LOGGER.info("delete 실패");
		}
	}
	private void testSelectToT() {
		int result = dao.getTotalNums();
		
		LOGGER.info(Integer.toString(result));
	}
	
}
