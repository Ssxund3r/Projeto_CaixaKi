package br.com.framework.implementacao.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.framework.interfac.crud.InterfaceCrud;

@Component
@Transactional
public class ImplementacaoCrud<T> implements InterfaceCrud<T> {
	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Autowired
	private JdbcTemplateImpl jdbcTemplateImpl;

	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Autowired
	private SimpleJdbcInsertImplements simpleJdbcInsertImplements;

	@Autowired
	private SimpleJdbcClassImpl jdbcClassImpl;

	public SimpleJdbcClassImpl getJdbcClassImpl() {
		return jdbcClassImpl;
	}

	@Override
	public void save(T obj) throws Exception {
	}

	@Override
	public void persist(T obj) throws Exception {

	}

	@Override
	public void saveOrUpdate(T obj) throws Exception {

	}

	@Override
	public void update(T obj) throws Exception {

	}

	@Override
	public void delete(T ojb) throws Exception {

	}

	@Override
	public T merge(T obj) throws Exception {
		return null;
	}

	@Override
	public List<T> findList(Class<T> objs) throws Exception {
		return null;
	}

	@Override
	public Object FinById(Class<T> entidade, Long Id) throws Exception {
		return null;
	}

	@Override
	public T FinByPorId(Class<T> entidade, Long Id) throws Exception {
		return null;
	}

	@Override
	public List<T> findListByQueryDinamica(String s) throws Exception {
		return null;
	}

	@Override
	public void executeUpdateQueryDinamica(String s) throws Exception {

	}

	@Override
	public void executeUpdateSQLDinamica(String s) throws Exception {

	}

	@Override
	public void clearSession() throws Exception {

	}

	@Override
	public void evict(Object objs) throws Exception {

	}

	@Override
	public Session getSession() throws Exception {
		return null;
	}

	@Override
	public List<?> getListSQLDinamica(String sql) throws Exception {
		return null;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplateImpl;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {

		return simpleJdbcTemplate;
	}

	@Override
	public SimpleJdbcInsert getSimpleJdbcInsert() {

		return simpleJdbcInsertImplements;
	}

	@Override
	public Long totalRegistro(String table) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query obterQuery(String query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private void validaTransaction() {
		if (!sessionFactory.getCurrentSession().getTransaction().isActive());
		sessionFactory.getCurrentSession().beginTransaction();
	}

	private void commitProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().commit();
	}

	private void rollBackProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().rollback();
	}

	private void validaSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		validaTransaction();
	}

}
