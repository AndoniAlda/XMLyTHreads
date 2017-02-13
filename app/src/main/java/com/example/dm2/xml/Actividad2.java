package com.example.dm2.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

    import java.util.List;

    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.app.Activity;
    import android.view.Menu;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

        private Button btnCargar;
        private TextView txtResultado;

        private List<Noticia> noticias;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_actividad2);

            btnCargar = (Button)findViewById(R.id.btnCargar);
            txtResultado = (TextView)findViewById(R.id.txtResultado);

            btnCargar.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    //Sin Tarea Asíncrona
                    //RssParserDom saxparser =
                    //		new RssParserDom("http://212.170.237.10/rss/rss.aspx");

                    //noticias = saxparser.parse();

                    //Tratamos la lista de noticias
                    //Por ejemplo: escribimos los títulos en pantalla
                    //txtResultado.setText("");
                    //for(int i=0; i<noticias.size(); i++)
                    //{
                    //	txtResultado.setText(
                    //		txtResultado.getText().toString() +
                    //			System.getProperty("line.separator") +
                    //			noticias.get(i).getTitulo());
                    //}

                    //Con Tarea Asíncrona
                    CargarXmlTask tarea = new CargarXmlTask();
                    //tarea.execute("http://www.aemet.es/xml/municipios/localidad_01059.xml");
                    tarea.execute("http://www.europapress.es/rss/rss.aspx");
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        //Tarea Asíncrona para cargar un XML en segundo plano
        private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

            protected Boolean doInBackground(String... params) {

                RssParserDom saxparser =
                        new RssParserDom(params[0]);

                noticias = saxparser.parse();

                return true;
            }

            protected void onPostExecute(Boolean result) {

                //Tratamos la lista de noticias
                //Por ejemplo: escribimos los títulos en pantalla
                txtResultado.setText("");
                for(int i=0; i<noticias.size(); i++)
                {
                    txtResultado.setText(
                            txtResultado.getText().toString() +
                                    System.getProperty("line.separator") +
                                    noticias.get(i).getTitulo());
                }
            }
        }
    }