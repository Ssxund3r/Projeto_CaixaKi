package br.com.project.bean.geral;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.stereotype.Component;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.annotation.IdentificaCampoPesquisa;
import br.com.project.report.util.BeanReportView;

@Component
public abstract class BeanManagedViewAbstract extends BeanReportView {
	private static final long serialVersionUID = 1L;

	protected abstract Class<?> getClassImplement();

	protected abstract InterfaceCrud<?> getController();

	public ObjetoCampoConsulta getObjetoCampoConsultaSelecionado;

	public List<SelectItem> listaCampoPesquisa;

	public ObjetoCampoConsulta getGetObjetoCampoConsultaSelecionado() {
		return getObjetoCampoConsultaSelecionado;
	}

	public void setGetObjetoCampoConsultaSelecionado(ObjetoCampoConsulta getObjetoCampoConsultaSelecionado) {
		this.getObjetoCampoConsultaSelecionado = getObjetoCampoConsultaSelecionado;
	}

	public List<SelectItem> getListaCampoPesquisa() {

		listaCampoPesquisa = new ArrayList<SelectItem>();
		List<ObjetoCampoConsulta> listTemp = new ArrayList<ObjetoCampoConsulta>();

		for (Field field : getClassImplement().getDeclaredFields()) {
			if (field.isAnnotationPresent(IdentificaCampoPesquisa.class)) {
				String descricao = field.getAnnotation(IdentificaCampoPesquisa.class).descricaoCampo();
				String descricaoCampoConsulta = field.getAnnotation(IdentificaCampoPesquisa.class).campoConsulta();
				int isPrincipal = field.getAnnotation(IdentificaCampoPesquisa.class).principal();

				ObjetoCampoConsulta objetoCampoConsulta = new ObjetoCampoConsulta();
				objetoCampoConsulta.setDescricao(descricao);
				objetoCampoConsulta.setCampoBanco(descricaoCampoConsulta);
				objetoCampoConsulta.setTipoClass(field.getType().getCanonicalName());
				objetoCampoConsulta.setPrincipal(isPrincipal);
				listTemp.add(objetoCampoConsulta);
			}
		}

		orderReverse(listTemp);
		
		for (ObjetoCampoConsulta objetoCampoConsulta : listTemp) {
			listaCampoPesquisa.add(new SelectItem(objetoCampoConsulta));
		}
		
		return listaCampoPesquisa;
	}

	private void orderReverse(List<ObjetoCampoConsulta> listTemp) {
		Collections.sort(listTemp, new Comparator<ObjetoCampoConsulta>() {

			@Override
			public int compare(ObjetoCampoConsulta objt1, ObjetoCampoConsulta objt2) {
				return objt1.getPrincipal().compareTo(objt2.getPrincipal());
			}
		});
	}
}
