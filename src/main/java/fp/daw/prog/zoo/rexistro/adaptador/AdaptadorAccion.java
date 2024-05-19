package fp.daw.prog.zoo.rexistro.adaptador;

import java.text.ParseException;

import fp.daw.prog.zoo.rexistro.TipoAccion;
import fp.daw.prog.zoo.rexistro.TipoAccion.Accion;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorAccion extends XmlAdapter<String, Accion> {

    public static final String FORMATO_DATA = "dd-MM-yyyy HH:mm:ss";

    @Override
    public String marshal(Accion v) {
        return v.toString();
    }

    @Override
    public Accion unmarshal(String v) throws ParseException {
        return TipoAccion.getAccion(v);
    }

}
