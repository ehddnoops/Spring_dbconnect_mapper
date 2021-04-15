package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

@Repository // @Component
//- ���� ����(Persistence Layer)�� DB ���� ����� ���
//- Spring Component bean���� �����
//- ������ �����ӿ�ũ�� bean�� �����ϱ� ���ؼ���
//	root-context.xml�� bean���� ����ؾ���
//- <context:component-scan ... />
public class BoardDAOImple implements BoardDAO{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex02.BoardMapper";
	
	//MyBatis�� SqlSession�� ����ϱ� ���ؼ�
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(BoardVO vo) {
		LOGGER.info("insertȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<BoardVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE+ ".select_all");
	}

	@Override
	public BoardVO select(int bno) {
		LOGGER.info("select(bno) ȣ��");
		return (BoardVO) sqlSession.selectOne(NAMESPACE + ".select_bno", bno);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO 
		return 0;
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete(bno) ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete_all", bno);
		// TODO ����2 ���� �ۼ��ϰ�, �׽�Ʈ����
	}

	@Override
	public List<BoardVO> select(PageCriteria c) {
		LOGGER.info("List<BoardVO> pageCriteria ȣ��");
		return sqlSession.selectList(NAMESPACE+".PageCriteria" , c);
		// TODO ����3 ���� �ۼ��ϰ�, �׽�Ʈ���� start: c.getstart() end:c.getend()
	}


	
	@Override
	public int getTotalNums() {
		LOGGER.info("getTotalNums ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".select_totalNum");
		// TODO ����4 ���� �ۼ��ϰ�, �׽�Ʈ����
	}

	
	@Override
	public List<BoardVO> select(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
