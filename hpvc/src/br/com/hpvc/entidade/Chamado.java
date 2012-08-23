package br.com.hpvc.entidade;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chamado database table.
 * 
 */
@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;

	private String descricao;

	//bi-directional many-to-one association to Local
    @ManyToOne
	private Local local;

	//bi-directional many-to-one association to StatusChamado
    @ManyToOne
	@JoinColumn(name="fk_status_chamado")
	private StatusChamado statusChamado;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="cadastrante")
	private Usuario cadastrante;

    @ManyToOne
    @JoinColumn(name="cliente")
    private Usuario cliente;
        
    @ManyToOne
    @JoinColumn(name="fk_sub_categoria")
    private SubCategoria subCategoria;
      
    public Chamado() {
    }

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
	public StatusChamado getStatusChamado() {
		return this.statusChamado;
	}

	public void setStatusChamado(StatusChamado statusChamado) {
		this.statusChamado = statusChamado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getCadastrante() {
		return cadastrante;
	}

	public void setCadastrante(Usuario cadastrante) {
		this.cadastrante = cadastrante;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
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
		Chamado other = (Chamado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

	

	
}