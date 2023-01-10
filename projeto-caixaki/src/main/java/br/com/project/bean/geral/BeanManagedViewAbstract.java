package br.com.project.bean.geral;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.report.util.BeanReportView;

@Component
public abstract class BeanManagedViewAbstract extends BeanReportView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected abstract Class<?> getClassImplement();
	
	protected abstract InterfaceCrud<?> getController();
	
	public ObjetoCampoConsulta getObjetoCampoConsultaSelecionado;

	public ObjetoCampoConsulta getGetObjetoCampoConsultaSelecionado() {
		return getObjetoCampoConsultaSelecionado;
	}

	public void setGetObjetoCampoConsultaSelecionado(ObjetoCampoConsulta 
			getObjetoCampoConsultaSelecionado) {
		
		this.getObjetoCampoConsultaSelecionado = getObjetoCampoConsultaSelecionado;
	}
	
	

}
