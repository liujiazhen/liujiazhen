package org.liujiazhen.report.service;

import net.sf.jasperreports.engine.JRException;

public interface IreportService {
    byte[] front(String draftNo)  throws JRException;
    byte[] back(String draftNo) throws JRException;
}
