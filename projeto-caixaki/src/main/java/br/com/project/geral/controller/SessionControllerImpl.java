package br.com.project.geral.controller;

import java.io.Serializable;
import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped
public class SessionControllerImpl implements SessionController, Serializable {
	private static final long serialVersionUID = 1L;

	private HashMap<String, HttpSession> hashMap = new HashMap<String, HttpSession>();

	@Override
	public void addSession(String keyLoginUser, HttpSession httpSession) {
		hashMap.put(keyLoginUser, httpSession);
	}

	@Override
	public void invalidateSession(String keyLoginUser) {
		HttpSession session = hashMap.get(keyLoginUser);
		if (session != null) { // Remove sessão do usuário passado como parametro
			try {
				session.invalidate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("não tem usuário.... ");
		}
		hashMap.remove(keyLoginUser);
	}
}
