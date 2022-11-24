package cl.ucn.web.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import cl.ucn.web.models.Renta;

@Component(value = "solicitudes/pdf")
public class SolicitdesPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
	List<Renta> list = (List<Renta>) model.get("rentas");

	document.addTitle("Lista de solicitudes de ".concat(list.get(0).getUsuario().getNombre()));

	PdfPTable tabla2 = new PdfPTable(1);

	PdfPTable tabla = new PdfPTable(2);
	for (Renta renta : list) {
	    tabla.addCell(String.valueOf(renta.getId()));
	    tabla.addCell(String.valueOf(renta.getMonto()));
	}

	document.add(tabla);

    }

}
