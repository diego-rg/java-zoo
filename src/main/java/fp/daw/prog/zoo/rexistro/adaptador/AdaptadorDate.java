package fp.daw.prog.zoo.rexistro.adaptador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorDate extends XmlAdapter<String, Date> {

    public static final String FORMATO_DATA = "dd-MM-yyyy HH:mm:ss";

    @Override
    public String marshal(Date v) {
        return new SimpleDateFormat(FORMATO_DATA).format(v);
    }

    @Override
    public Date unmarshal(String v) throws ParseException {
        return new SimpleDateFormat(FORMATO_DATA).parse(v);
    }

}
