package ed.com.evento.meuappevento.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import ed.com.evento.meuappevento.R;

/**
 * Created by Lenildo on 14/04/2016.
 */
public class qrCodeBusca extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_code_busca);

        TextView conteudo = (TextView) findViewById(R.id.seuNomeText);
        Intent intent = getIntent();
        conteudo.setText(( (String) intent.getSerializableExtra("<---conteudo Lido--->")));

        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(qrCodeBusca.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
