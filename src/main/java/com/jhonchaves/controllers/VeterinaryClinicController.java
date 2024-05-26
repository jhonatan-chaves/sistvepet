package com.jhonchaves.controllers;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.io.image.ImageDataFactory;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.jhonchaves.models.ReceitaModel;
import com.jhonchaves.repository.ReceitaRepository;
import com.jhonchaves.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VeterinaryClinicController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping("/generate-receipt/{id}")
    public void generateReceipt(HttpServletResponse response, @PathVariable(value = "id")Long id) throws IOException, WriterException {

        Optional<ReceitaModel> receitaOp = receitaRepository.findById(id);

        var receita = receitaOp.get();


        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=receipt.pdf");

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Título
        Paragraph title = new Paragraph();
        Text sist = new Text("Sist").setFontColor(new DeviceRgb(0, 0, 255)); // Azul
        Text vet = new Text("Vet").setFontColor(new DeviceRgb(255, 0, 0)); // Vermelho
        Text pet = new Text("Pet").setFontColor(new DeviceRgb(0, 255, 0)); // Verde
        title.add(sist);
        title.add(vet);
        title.add(pet);
        title.setFontSize(20);
        document.add(title);
        document.add(new Paragraph("\n"));

        // Dados do veterinário em tabela
        Table vetTable = new Table(1);
       // vetTable.setWidthPercent(100);
        vetTable.addCell(new Cell().add(new Paragraph("Veterinário: Dr. " + receita.getMedVet().getFirstName())));
        vetTable.addCell(new Cell().add(new Paragraph("CRMV: " + receita.getCrmv())));
        vetTable.addCell(new Cell().add(new Paragraph("Telefone: (22) 99957-2148")));
        vetTable.addCell(new Cell().add(new Paragraph("Endereço: BR-101, 111, Campos dos Goytacazes - RJ")));
        document.add(vetTable);
        document.add(new Paragraph("\n"));

        // Dados do paciente
        document.add(new Paragraph("Paciente: " + receita.getPet().getNomePet() +", Espécie: " + receita.getPet().getType() + "" +
                ", Raça: " + receita.getPet().getRaca() + ", Idade: " + receita.getPet().getDataNascimentoPet()));
        document.add(new Paragraph("Dono: " + receita.getPet().getTutor().getFirstName()));
        document.add(new Paragraph("Telefone do Dono: (11) 91234-5678"));
        document.add(new Paragraph("\n"));

        // Medicamentos como parágrafos
        document.add(new Paragraph("Medicamento: " + receita.getPrescricao()));
        document.add(new Paragraph("\n"));

        // Instruções adicionais
        document.add(new Paragraph("Instruções Adicionais:"));
        document.add(new Paragraph("Administrar o medicamento junto com alimentos para evitar desconforto gástrico."));
        document.add(new Paragraph("Retornar em caso de qualquer reação adversa."));
        document.add(new Paragraph("Manter o animal hidratado."));
        document.add(new Paragraph("\n"));

        // Geração do QR code
        String qrCodeText = "Dr. " + receita.getMedVet().getFirstName() + ", CRMV: " + receita.getCrmv() + ", Telefone: (22) 99957-2148";
        ByteArrayOutputStream qrCodeOutputStream = generateQRCode(qrCodeText, 100, 100);

        // Adiciona o QR code ao PDF
        Image qrCodeImage = new Image(ImageDataFactory.create(qrCodeOutputStream.toByteArray()));
        document.add(qrCodeImage);
        document.add(new Paragraph("\n"));

        // Assinatura
        document.add(new Paragraph("________________________________"));
        document.add(new Paragraph("Assinatura do Veterinário"));

        document.close();
    }

    private ByteArrayOutputStream generateQRCode(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream;
    }
}