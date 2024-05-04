/*
 * Copyright (C) 2018 eduar
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package carreraovni;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author eduar
 */
public class CreatePDF {
    private Controlador c;
    public CreatePDF(Controlador c) throws FileNotFoundException, DocumentException{
        this.c=c;
        
        // Se crea el documento
        Document documento = new Document();

        // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        FileOutputStream ficheroPdf = new FileOutputStream("resultados.pdf");

        // Se asocia el documento al OutputStream y se indica que el espaciado entre
        // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
        PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

        // Se abre el documento.
        documento.open();
        
        switch(c.getCircuito()){
            case 0:
                try
                {
                    Image foto = Image.getInstance("src/imagenes/pista.png");
                    foto.scaleToFit(100, 65);
                    foto.setAlignment(Chunk.ALIGN_MIDDLE);
                    documento.add(foto);
                }
                catch ( Exception e ){e.printStackTrace();}
                break;
            case 1:
                try
                {
                    Image foto = Image.getInstance("src/imagenes/pista1.png");
                    foto.scaleToFit(100, 65);
                    foto.setAlignment(Chunk.ALIGN_MIDDLE);
                    documento.add(foto);
                }
                catch ( Exception e ){e.printStackTrace();}
                break;
            default:
                break;
                       
        }
        
        documento.add(new Paragraph("Results:"));
        
        try
        {
            Image foto = Image.getInstance("src/imagenes/ovni.png");
            foto.scaleToFit(100, 100);
            documento.add(foto);
        }
        catch ( Exception e ){e.printStackTrace();}
        
        documento.add(new Paragraph("Ovni 1: "+c.getContador()+" turns",
				FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));             // color
        
        if(c.getNumPlayer()==1){
            documento.add(new Paragraph("Time left : "+c.getTime()+ " s",
				FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.BLACK)));             // color
        }
        
        if(c.getNumPlayer()==2){
            
            try
            {
                Image foto = Image.getInstance("src/imagenes/ovni2.png");
                foto.scaleToFit(100, 100);
                documento.add(foto);
            }
            catch ( Exception e ){e.printStackTrace();}
            
            documento.add(new Paragraph("Ovni 2: "+c.getContador2()+" turns",
                                    FontFactory.getFont("arial",   // fuente
                                    22,                            // tamaño
                                    Font.ITALIC,                   // estilo
                                    BaseColor.BLACK)));             // color
        }
        documento.close();
    }
}
