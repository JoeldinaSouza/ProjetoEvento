package ed.com.evento.meuappevento.util;

import ed.com.evento.meuappevento.entidade.Pessoa;

import java.util.List;

public interface BuscarPessoaCallBack {

    void backBuscarNome(List<Pessoa> names);

    void errorBuscarNome(String error);
}
