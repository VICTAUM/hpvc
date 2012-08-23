package br.com.hpvc.entidade;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the status_chamado database table.
 * 
 */
@Entity
@Table(name="status_chamado")
public class StatusChamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String descricao;

	//bi-directional many-to-one association to Chamado
	@OneToMany(mappedBy="statusChamado")
	private Set<Chamado> chamados;

    public StatusChamado() {
    }

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Chamado> getChamados() {
		return this.chamados;
	}

	public void setChamados(Set<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusChamado other = (StatusChamado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}