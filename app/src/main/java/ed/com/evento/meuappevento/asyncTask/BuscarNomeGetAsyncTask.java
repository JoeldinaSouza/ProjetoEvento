package ed.com.evento.meuappevento.asyncTask;

import android.util.Log;
import android.os.AsyncTask;

import ed.com.evento.meuappevento.util.BuscarPessoaCallBack;
import ed.com.evento.meuappevento.util.HttpService;
import ed.com.evento.meuappevento.entidade.Pessoa;
import ed.com.evento.meuappevento.util.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import ed.com.evento.meuappevento.activity.nomeBusca;

/**
 * Created by Lenildo on 14/04/2016.
 */
public class BuscarNomeGetAsyncTask extends AsyncTask<Pessoa, Void, Response>{

    private BuscarPessoaCallBack buscarNomeCallBack;

    public BuscarNomeGetAsyncTask (nomeBusca buscarNomeCallBack) {

        this.buscarNomeCallBack = buscarNomeCallBack;
    }

    @Override
    protected Response doInBackground(Pessoa... pessoas) {

        Response response = null;

        Pessoa pessoa = pessoas[0];

        Gson gson = new Gson();
        Log.i("EditTextListener", "doInBackground (JSON): " + pessoa);

        try {

            response = HttpService.sendJSONPostResquest("pesquisar/nome/", pessoa.getNome());

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {


        if(response == null)
            Log.i("É NULO","NULO");

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            buscarNomeCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Pessoa> pessoas = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Pessoa>>() {
                    }.getType());

            buscarNomeCallBack.backBuscarNome(pessoas);
        }
    }
}