package report;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcelo on 28/10/16.
 */
public class TestReport {

    public static void main(String[] args) throws JRException, URISyntaxException {

        URL resource = TestReport.class.getResource("/testFontsEmbeed.jrxml");
        File file = new File(resource.toURI());

        JasperReport jasperReport = JasperCompileManager
                .compileReport(file.getAbsolutePath());

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("title", "Oi Marcelo,,, funcionou");

        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, dataSource);

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                String.format("/tmp/FontsEmbeed%d.pdf", System.currentTimeMillis()));

    }

}
