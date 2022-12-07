package br.com.project.bean.view;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CidadeController;
import br.com.project.model.classes.Cidade;

@Controller
@Scope(value = "session")
@ManagedBean(name = "cidadeBeanView")
public class CidadeBeanView extends BeanManagedViewAbstract {
	private static final long serialVersionUID = 1L;

	private Cidade objetoSelecionado = new Cidade();

	private String url = "/cadastro/cad_cidade.jsf?faces-redirect=true";

	@Resource
	private CidadeController cidadeController;

	@Override
	public String save() throws Exception {
		objetoSelecionado = cidadeController.merge(objetoSelecionado);
		return "";
	}

	@Override
	public String novo() throws Exception {
		objetoSelecionado = new Cidade();

		return url;
	}

	public void setObjetoSelecionado(Cidade objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	public Cidade getObjetoSelecionado() {
		return objetoSelecionado;
	}

	/*
	 * public String getUrl() { return url; }
	 */

}
