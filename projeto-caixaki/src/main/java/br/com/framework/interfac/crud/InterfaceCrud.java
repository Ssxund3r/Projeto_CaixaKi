package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable{
	//salva os dados
	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	//salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;
	
	//realiza o update/atualização dos dados
	void update(T obj) throws Exception;
	
	//realiza exclusão dos dados
	void delete(T ojb) throws Exception;
	
	//realiza o Merge/Salvar ou atualiza e retornar o objeto em estado persistente
	T merge (T obj) throws Exception;
	
	//carrega a lista de dados de determinada classe 
	List<T> findList(Class<T> objs) throws Exception;
	
	Object FinById(Class<T> entidade, Long Id) throws Exception;
	
	T FinByPorId(Class<T> entidade, Long Id) throws Exception;
	
	List<T> findListByQueryDinamica(String s) throws Exception;
	
	//Executar update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Executar update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	//limpa a sessão do Hibernate
	void clearSession() throws Exception;
	
	//Retira um objeto da sessão do hibernate
	void evict(Object objs) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String sql) throws Exception;
	
	//Jdbc do Spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	Long totalRegistro(String table) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	//Carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDinamica (String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
}