package com.github.sejoung.service;

import com.github.sejoung.domain.SummaryKCP;
import com.github.sejoung.repositories.SummaryKCPRepository;
import java.io.IOException;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ExecelService {

	private final SummaryKCPRepository repository;

	private ExecelService(SummaryKCPRepository repository) {
		this.repository = repository;
	}

	public void saveSummaryKCP(MultipartFile file) throws IOException, InvalidFormatException {
		try (var pkg = OPCPackage.open(file.getInputStream())) {
			var workbook = new XSSFWorkbook(pkg);
			var sheet = workbook.getSheetAt(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (Row row : sheet) {
				var kcp = SummaryKCP.builder().day(sdf.format(row.getCell(0).getDateCellValue()))
						.cnt(Double.valueOf(row.getCell(1).getNumericCellValue()).longValue())
						.amount(Double.valueOf(row.getCell(2).getNumericCellValue()).longValue())
						.cancelCnt(Double.valueOf(row.getCell(3).getNumericCellValue()).longValue())
						.cancelAmount(Double.valueOf(row.getCell(4).getNumericCellValue()).longValue()).build();
				log.debug(kcp.toString());
				repository.save(kcp);

			}
		} catch (Exception e) {
			throw e;
		}
	}

}
