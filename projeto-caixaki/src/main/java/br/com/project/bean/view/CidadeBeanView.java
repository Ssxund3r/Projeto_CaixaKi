package br.com.project.bean.view;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CidadeController;

@Controller
@Scope(value="session")
@ManagedBean(name ="cidadeBeanView")
public class CidadeBeanView  extends BeanManagedViewAbstract {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private CidadeController cidadeController;
	
}
